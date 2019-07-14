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

/** �˿ں�7001 */
//@CrossOrigin("*") �������
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/** ͨ���û�id��ȡ�û����ǳƺ�ͷ�� */
	@GetMapping("/user/name")
	public WsResult check(String name){
		return userService.checkUser2(name);
	}
	
	/** ͨ���û�id��ȡ�û���Ϣ�� ���в�����������Ϣ �磺������� */
	@GetMapping("/user/userInfo/{id}")
	public WsResult loadUserInfo(@PathVariable("id")int id){
		return userService.loadUserInfo(id);
	}
	/** ͨ���û�id��ȡ�û����ǳƺ�ͷ�� */
	@GetMapping("/user/{id}")
	public WsResult loadNickNameAndImage(@PathVariable("id")int id){
		return userService.loadNickNameAndImage(id);
	}
	/** �û�ע�Ṧ�� */
	@PostMapping("/user/regist")
	public WsResult regist(String name, String password){
		WsResult wsResult = userService.addUser(name, password);
		return wsResult;
	}
	/** �û���¼���� */
	@PostMapping("/user/login")
	public WsResult login(String name, String password){
		WsResult wsResult = userService.checkUser(name, password);
		return wsResult;
	}
	/** �û��޸����� */
	@PutMapping("/user/updatepwd")
	public WsResult updatePwd(String name, String oldPwd, String  newPwd){
		WsResult wsResult = userService.updatePassword(name, oldPwd, newPwd);
		return wsResult;
	}
	/** �û��޸ĸ�����Ϣ */
	@PutMapping("/user/updateinfo")
	public WsResult updateInfo(User user){
		return userService.updateUserInfo(user);
	}
	
	/** ��֤�û���¼��Ϣ */
	@PostMapping("/user/ticket")
	public WsResult ticket(
			@RequestParam("userId")Integer userId,
			@RequestParam("ticket")String ticket){
		WsResult result = userService.checkTicket(userId, ticket);
		return result;
	}
	
	
	
	/** �û��ϴ�ͷ�� */
    @PostMapping("/user/img/upload")
    public WsResult uploadImg(@RequestParam("userId")int userId,
    		@RequestParam("file") MultipartFile multipartFile)  {
        
       return userService.uploadImg(userId, multipartFile);
    	
    }

	
	
    /** �쳣���� */
	@ExceptionHandler
	public WsResult handleUserException(Exception e){
		WsResult wsResult = new WsResult();
		wsResult.setMsg(WsConstant.ERROR_MSG);
		wsResult.setStatus(WsConstant.ERROR);
		return wsResult;
	}
	
	
}
