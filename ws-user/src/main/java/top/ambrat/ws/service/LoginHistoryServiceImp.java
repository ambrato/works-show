package top.ambrat.ws.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import top.ambrat.ws.dao.LoginHistoryMapper;
import top.ambrat.ws.entity.LoginHistory;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;

@Service
public class LoginHistoryServiceImp implements LoginHistoryService {

	@Autowired
	private LoginHistoryMapper mapper;
	
	public WsResult addLoginHistory(LoginHistory loginHistory) {
		WsResult result = new WsResult();
		loginHistory.setLoginTime(new Date());
		mapper.insert(loginHistory);
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.SUCCESS_MSG);
		return result;
	}

	public WsResult getLoginHistory(int userId) {
		WsResult result = new WsResult();
		PageHelper.startPage(1, 20);
		List<LoginHistory> list = mapper.selectByUserId(userId);
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.QUERY_SUCCESS_MSG);
		result.setData(list);
		return result;
	}

}
