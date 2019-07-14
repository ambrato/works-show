package top.ambrat.ws.controller;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.entity.User;
import top.ambrat.ws.service.UserService;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;

/** 端口号7001 */
//@CrossOrigin("*") 解决跨域
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/** 通过用户id获取用户的昵称和头像 */
	@GetMapping("/user/name")
	public WsResult check(String name){
		return userService.checkUser2(name);
	}
	
	/** 通过用户id获取用户信息， 其中不包含敏感信息 如：密码和盐 */
	@GetMapping("/user/userInfo/{id}")
	public WsResult loadUserInfo(@PathVariable("id")int id){
		return userService.loadUserInfo(id);
	}
	/** 通过用户id获取用户的昵称和头像 */
	@GetMapping("/user/{id}")
	public WsResult loadNickNameAndImage(@PathVariable("id")int id){
		return userService.loadNickNameAndImage(id);
	}
	/** 用户注册功能 */
	@PostMapping("/user/regist")
	public WsResult regist(String name, String password){
		WsResult wsResult = userService.addUser(name, password);
		return wsResult;
	}
	/** 用户登录功能 */
	@PostMapping("/user/login")
	public WsResult login(String name, String password){
		WsResult wsResult = userService.checkUser(name, password);
		return wsResult;
	}
	/** 用户修改密码 */
	@PutMapping("/user/updatepwd")
	public WsResult updatePwd(String name, String oldPwd, String  newPwd){
		WsResult wsResult = userService.updatePassword(name, oldPwd, newPwd);
		return wsResult;
	}
	/** 用户修改个人信息 */
	@PutMapping("/user/updateinfo")
	public WsResult updateInfo(User user){
		return userService.updateUserInfo(user);
	}
	
	/** 验证用户登录信息 */
	@PostMapping("/user/ticket")
	public WsResult ticket(
			@RequestParam("userId")Integer userId,
			@RequestParam("ticket")String ticket){
		WsResult result = userService.checkTicket(userId, ticket);
		return result;
	}
	
	
	
	/** 用户上传头像 */
    @PostMapping("/user/img/upload")
    public WsResult uploadImg(@RequestParam("userId")int userId,
    		@RequestParam("file") MultipartFile multipartFile)  {
        
       return userService.uploadImg(userId, multipartFile);
    	
    }

	
	
    /** 异常处理 */
	@ExceptionHandler
	public WsResult handleUserException(Exception e){
		WsResult wsResult = new WsResult();
		wsResult.setMsg(WsConstant.ERROR_MSG);
		wsResult.setStatus(WsConstant.ERROR);
		return wsResult;
	}
	
	
}
