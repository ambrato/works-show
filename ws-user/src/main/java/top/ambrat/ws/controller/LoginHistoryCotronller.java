package top.ambrat.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import top.ambrat.ws.entity.LoginHistory;
import top.ambrat.ws.service.LoginHistoryService;
import top.ambrat.ws.util.WsResult;

/** 端口号：7001 */
@RestController
public class LoginHistoryCotronller {

	@Autowired
	private LoginHistoryService service;
	
	/** 新增登录历史记录 */
	@PostMapping("/longinHistory/add")
	public WsResult addHistory(LoginHistory loginHistory){
		return service.addLoginHistory(loginHistory);
	}
	
	/** 通过用户id获取登录记录 默认最近20条 */
	@GetMapping("longinHistory/list")
	public WsResult getHistoryList(int userId){
		return service.getLoginHistory(userId);
	}
}
