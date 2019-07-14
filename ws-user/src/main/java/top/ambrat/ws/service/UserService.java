package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.entity.User;
import top.ambrat.ws.util.WsResult;

public interface UserService {
	/** ע�Ṧ�� */
	public WsResult addUser(String name, String password);
	
	/** ��ѯ�û����Ƿ���� */
	public WsResult checkUser2(String name);
	
	/** ��¼���� */
	public WsResult checkUser(String name, String password);
	
	/** �޸����� */
	public WsResult updatePassword(String name, String oldPwd, String newPwd);
	
	/** �޸ĸ�����Ϣ */
	public WsResult updateUserInfo(User user);
	
	/** ����id��ѯ�û��ǳƺ�ͷ�� */
	public WsResult loadNickNameAndImage(int id);
	
	/** ����id��ѯ�û�������Ϣ */
	public WsResult loadUserInfo(int id);
	
	/** ����û���¼ƾ֤ */
	public WsResult checkTicket(int userId,String ticket);
	
	/** �ϴ�ͷ��*/
	public WsResult uploadImg(int userId, MultipartFile multipartFile);
}
