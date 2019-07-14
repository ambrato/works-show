package top.ambrat.ws.service;

import top.ambrat.ws.entity.LoginHistory;
import top.ambrat.ws.util.WsResult;

public interface LoginHistoryService {

	/** 插入登录记录 */
	public WsResult addLoginHistory(LoginHistory loginHistory);
	
	/** 通过用户id查询登录记录 */
	public WsResult getLoginHistory(int userId);
}
