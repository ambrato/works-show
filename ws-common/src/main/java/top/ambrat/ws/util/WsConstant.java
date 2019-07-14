package top.ambrat.ws.util;

public class WsConstant {
	
	public static final int SUCCESS = 0; //成功
	public static final int ERROR = -1; //异常
	public static final int ERROR1 = 1; //失败1
	public static final int ERROR2 = 2; //失败2
	public static final int ERROR3 = 3; //失败3

	public static final String SUCCESS_MSG = "操作成功";
	public static final String ERROR_MSG = "操作异常";
	
	public static final String REGIST_ERROR1_MSG = "用户名被占用";
	public static final String LOGIN_ERROR1_MSG = "用户名不存在";
	public static final String LOGIN_ERROR2_MSG = "用户名或密码错误";
	public static final String QUERY_SUCCESS_MSG = "查询成功";
	public static final String UPDATE_PWD_ERROR1_MSG = "旧密码输入错误";
	public static final String UPDATE_PWD_SUCCESS = "密码修改成功";
	public static final String UPDATE_SUCCESS = "修改成功";
	public static final String QUERY_ERROR1_MSG = "未找到数据";
	public static final String TICKET_ERROR1_MSG = "无效的Ticket";
	public static final String TICKET_SUCCESS_MSG = "验证成功，Ticket可用";
	public static final String UPDATE_IMG_ERROR1_MSG = "上传失败";
}
