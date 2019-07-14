package top.ambrat.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import top.ambrat.ws.entity.LoginHistory;
import top.ambrat.ws.service.LoginHistoryService;
import top.ambrat.ws.util.WsResult;

/** �˿ںţ�7001 */
@RestController
public class LoginHistoryCotronller {

	@Autowired
	private LoginHistoryService service;
	
	/** ������¼��ʷ��¼ */
	@PostMapping("/longinHistory/add")
	public WsResult addHistory(LoginHistory loginHistory){
		return service.addLoginHistory(loginHistory);
	}
	
	/** ͨ���û�id��ȡ��¼��¼ Ĭ�����20�� */
	@GetMapping("longinHistory/list")
	public WsResult getHistoryList(int userId){
		return service.getLoginHistory(userId);
	}
}
