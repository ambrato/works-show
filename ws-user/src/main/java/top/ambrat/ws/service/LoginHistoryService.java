package top.ambrat.ws.service;

import top.ambrat.ws.entity.LoginHistory;
import top.ambrat.ws.util.WsResult;

public interface LoginHistoryService {

	/** �����¼��¼ */
	public WsResult addLoginHistory(LoginHistory loginHistory);
	
	/** ͨ���û�id��ѯ��¼��¼ */
	public WsResult getLoginHistory(int userId);
}
