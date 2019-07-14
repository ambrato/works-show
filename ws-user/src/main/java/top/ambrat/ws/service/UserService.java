package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.entity.User;
import top.ambrat.ws.util.WsResult;

public interface UserService {
	/** 注册功能 */
	public WsResult addUser(String name, String password);
	
	/** 查询用户名是否存在 */
	public WsResult checkUser2(String name);
	
	/** 登录功能 */
	public WsResult checkUser(String name, String password);
	
	/** 修改密码 */
	public WsResult updatePassword(String name, String oldPwd, String newPwd);
	
	/** 修改个人信息 */
	public WsResult updateUserInfo(User user);
	
	/** 根据id查询用户昵称和头像 */
	public WsResult loadNickNameAndImage(int id);
	
	/** 根据id查询用户所以信息 */
	public WsResult loadUserInfo(int id);
	
	/** 检查用户登录凭证 */
	public WsResult checkTicket(int userId,String ticket);
	
	/** 上传头像*/
	public WsResult uploadImg(int userId, MultipartFile multipartFile);
}
