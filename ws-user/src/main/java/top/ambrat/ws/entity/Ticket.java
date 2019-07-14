package top.ambrat.ws.entity;

import java.io.Serializable;

import org.springframework.util.Base64Utils;

public class Ticket implements Serializable{
	
	private int userId; //用户ID
	private String ticket; //凭证号
	private long createTime;//颁发时间
	private long expireTime;//有效期
	private String userName;//用户名
	
	public String toString(){
		//拼一个串
		String s = userId+"-"+ticket;
		//采用Base64算法处理
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
