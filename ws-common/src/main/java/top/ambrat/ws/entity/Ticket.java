package top.ambrat.ws.entity;

import java.io.Serializable;

import org.springframework.util.Base64Utils;

public class Ticket implements Serializable{
	
	private int userId; //�û�ID
	private String ticket; //ƾ֤��
	private long createTime;//�䷢ʱ��
	private long expireTime;//��Ч��
	private String userName;//�û���
	
	public String toString(){
		//ƴһ����
		String s = userId+"-"+ticket;
		//����Base64�㷨����
		return Base64Utils.encodeToString(s.getBytes());
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
