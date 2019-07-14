package top.ambrat.ws.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.jxpath.servlet.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.dao.UserMapper;
import top.ambrat.ws.entity.Ticket;
import top.ambrat.ws.entity.User;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;
import top.ambrat.ws.util.PasswordUtil;
import top.ambrat.ws.util.Upload;

@Service
public class UserServiceImp implements UserService {
	
	  /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${img.location}")
    private String location;
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private RedisTemplate<Object, Object> redis;
	
	public WsResult addUser(String name, String password) {
		WsResult result  = new WsResult();
		//判断用户名是否存在
		User user1 = mapper.selectByName(name);
		if (user1!=null) {
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.REGIST_ERROR1_MSG);
			return result;
		}
		User user2 = new User();
		user2.setName(name);
		//user2.setPassword(password);
		//TODO 密码加密处理
		String salt = PasswordUtil.salt();
		String md5Pwd = PasswordUtil.md5(password+salt);
		user2.setPassword(md5Pwd);
		user2.setSalt(salt);
		user2.setRegtime(new Date());
		mapper.insertSelective(user2);
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.SUCCESS_MSG);
		return result;
	}
	
	public WsResult checkUser2(String name) {
		WsResult result  = new WsResult();
		//判断用户名是否存在
		User user1 = mapper.selectByName(name);
		if (user1 == null) {
			result.setStatus(WsConstant.SUCCESS);
			result.setMsg(WsConstant.SUCCESS_MSG);
			return result;
		}
		result.setStatus(WsConstant.ERROR);
		result.setMsg(WsConstant.ERROR_MSG);
		return result;
		
	}
	
	

	public WsResult checkUser(String name, String password) {
		WsResult result = new WsResult();
		//判断用户名是否存在
		User user3 = mapper.selectByName(name);
		if (user3 == null) {
			//用户名不存在，登录失败
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.LOGIN_ERROR1_MSG);
			return result;
		}
		//用户名存在则比对密码密文
		String salt = user3.getSalt();
		String password2 = user3.getPassword();
		String md5Pwd = PasswordUtil.md5(password+salt);
		if (!md5Pwd.equals(password2)) {
			//密码密文比对错误， 登录失败
			result.setStatus(WsConstant.ERROR2);
			result.setMsg(WsConstant.LOGIN_ERROR2_MSG);
			return result;
		}
		//密码密文正确登录成功
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.SUCCESS_MSG);
		//创建ticket返回
		Ticket tk = new Ticket();
		tk.setUserId(user3.getId());
		tk.setUserName(user3.getName());
		tk.setCreateTime(System.currentTimeMillis());
		tk.setExpireTime(7*24*3600*1000);//默认一周有效期
		tk.setTicket(PasswordUtil.salt());
		//将ticket信息存入redis，用于以后校验操作
		redis.opsForHash().put("tickets", "ticket_"+user3.getId(), tk);
		//redis.expire("ticket_"+user.getId(), tk.getExpireTime(), TimeUnit.MILLISECONDS);
		//返回userId和tk两个信息
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("ticket", tk.toString());
		data.put("userId", user3.getId());
		result.setData(data);
		return result;
	}

	public WsResult updatePassword(String name, String oldPwd, String newPwd) {
		WsResult result = new WsResult();
		//验证用户名与旧密码是否正确匹配
		//判断用户名是否存在
		User user3 = mapper.selectByName(name);
		if (user3 == null) {
			//用户名不存在，更改密码失败
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.LOGIN_ERROR1_MSG);
			return result;
		}
		//用户名存在则比对密码密文
		String salt = user3.getSalt();
		String password2 = user3.getPassword();
		String md5oldPwd = PasswordUtil.md5(oldPwd+salt);
		if (!md5oldPwd.equals(password2)) {
			//密码密文比对错误， 失败
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.UPDATE_PWD_ERROR1_MSG);
			return result;
		}
		
		//旧密码正确， 修改密码
		String newSalt = PasswordUtil.salt();
		String password = PasswordUtil.md5(newPwd+newSalt);
		mapper.updatePwdByUname(name, password, newSalt);
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.UPDATE_PWD_SUCCESS);
		return result;
	}

	public WsResult updateUserInfo(User user) {
		WsResult result = new WsResult();
		mapper.updateByPrimaryKeySelective(user);
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.UPDATE_SUCCESS);
		return result;
	}

	public WsResult loadNickNameAndImage(int id) {
		WsResult result = new WsResult();
		User user = mapper.selectNkNameAndImageByPrimaryKey(id);
		if (user==null) {
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.QUERY_ERROR1_MSG);
			return result;
		}
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.QUERY_SUCCESS_MSG);
		result.setData(user);
		return result;
	}

	public WsResult checkTicket(int userId, String ticket) {
		WsResult result = new WsResult();
		//从redis获取ticket
		Ticket tk = (Ticket)redis.opsForHash().get("tickets", "ticket_"+userId);
		if(tk == null){
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.TICKET_ERROR1_MSG);
			return result;
		}
		//检测用户提交的ticket和redis存储的是否一致
		if(!tk.toString().equals(ticket)){
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.TICKET_ERROR1_MSG);
			return result;
		}
		//检测ticket在有效期
		long time = tk.getCreateTime()+tk.getExpireTime();
		if(time < System.currentTimeMillis()){
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.TICKET_ERROR1_MSG);
			return result;
		}
		//有效结果
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.TICKET_SUCCESS_MSG);
		return result;
	}

	public WsResult loadUserInfo(int id) {
		WsResult result = new WsResult();
		User user = mapper.selectUserInfoByPrimaryKey(id);
		if (user==null) {
			result.setStatus(WsConstant.ERROR1);
			result.setMsg(WsConstant.QUERY_ERROR1_MSG);
			return result;
		}
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.QUERY_SUCCESS_MSG);
		result.setData(user);
		return result;
	}

	public WsResult uploadImg(int userId, MultipartFile multipartFile) {
		
		WsResult result = new WsResult();
		WsResult upload = Upload.upload(multipartFile, location);
		if (upload.getStatus() != 0) {
			result.setMsg("上传失败");
			result.setStatus(WsConstant.SUCCESS);
			return result;
		}
		String file_name = (String)upload.getData();
		mapper.updateImageById(userId, file_name);
	    return result;
	}
	
	
	


}
