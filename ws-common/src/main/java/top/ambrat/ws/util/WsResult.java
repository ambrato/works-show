package top.ambrat.ws.util;

import java.io.Serializable;

public class WsResult implements Serializable {
	private int status;
	private String msg;
	private Object data;
	private int page;
	private int totalPage;
	private long totalRecored;
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getTotalRecored() {
		return totalRecored;
	}
	public void setTotalRecored(long totalRecored) {
		this.totalRecored = totalRecored;
	}
	
}
