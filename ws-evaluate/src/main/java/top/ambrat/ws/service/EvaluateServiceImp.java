package top.ambrat.ws.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.ambrat.ws.dao.EvaluateMapper;
import top.ambrat.ws.entity.Evaluate;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;

@Service
public class EvaluateServiceImp implements EvaluateService {

	@Autowired
	private EvaluateMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public WsResult insertEvaluate(Evaluate evaluate) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		if (StringUtils.isEmpty(evaluate.getContext())) {
			result.setMsg(WsConstant.ERROR_MSG);
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		if (StringUtils.isEmpty(evaluate.getUseId())) {
			result.setMsg(WsConstant.ERROR_MSG);
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		if (StringUtils.isEmpty(evaluate.getWorksId())) {
			result.setMsg(WsConstant.ERROR_MSG);
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		String userUrl = "http://WS-USER/user/" + evaluate.getUseId();
		WsResult forObject1 = restTemplate.getForObject(userUrl, WsResult.class);
		if (forObject1.getStatus() != 0) {
			result.setMsg("用户不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		String worksUrl = "http://WS-WORKS/works/" + evaluate.getWorksId();
		WsResult forObject2 = restTemplate.getForObject(worksUrl, WsResult.class);
		if (forObject2.getStatus() != 0) {
			result.setMsg("作品不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
		}		
		evaluate.setPublishTime(new Date());
		mapper.insertSelective(evaluate);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult deleteEvaluate(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Evaluate evaluate = mapper.selectByPrimaryKey(id);
		if (evaluate == null) {
			result.setStatus(WsConstant.ERROR);
			result.setMsg(WsConstant.ERROR_MSG);
			return result;
		}
		mapper.updateStatusTo0ById(id);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}
	
	public WsResult recoverEvaluate(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Evaluate evaluate = mapper.selectByPrimaryKey(id);
		if (evaluate == null) {
			result.setStatus(WsConstant.ERROR);
			result.setMsg(WsConstant.ERROR_MSG);
			return result;
		}
		mapper.updateStatusTo1ById(id);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult selectEvaluateById(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Evaluate evaluate = mapper.selectByPrimaryKey(id);
		if (evaluate == null) {
			result.setStatus(WsConstant.ERROR);
			result.setMsg(WsConstant.ERROR_MSG);
			return result;
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(evaluate);
		return result;
	}

	public WsResult selectEvaluateByWorksId(int worksId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		String worksUrl = "http://WS-WORKS/works/" + worksId;
		WsResult forObject2 = restTemplate.getForObject(worksUrl, WsResult.class);
		if (forObject2.getStatus() != 0) {
			result.setMsg("作品不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Evaluate> evaluates = mapper.selectByWorksId(worksId);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(evaluates);
		result.setPage(page.getPageNum());
		result.setTotalPage(page.getPageNum());
		result.setTotalRecored(page.getTotal());
		return result;
	}

	public WsResult selectEvaluateByUserId(int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		String worksUrl = "http://WS-USER/user/" + userId;
		WsResult forObject2 = restTemplate.getForObject(worksUrl, WsResult.class);
		if (forObject2.getStatus() != 0) {
			result.setMsg("用户不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Evaluate> evaluates = mapper.selectByUserId(userId);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(evaluates);
		result.setPage(page.getPageNum());
		result.setTotalPage(page.getPageNum());
		result.setTotalRecored(page.getTotal());
		return result;
	}

	public WsResult updateLikeCount(Evaluate evaluate) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Evaluate evaluate2 = mapper.selectByPrimaryKey(evaluate.getId());
		if (evaluate2 == null) {
			result.setStatus(WsConstant.ERROR);
			result.setMsg(WsConstant.ERROR_MSG);
			return result;
		}
		mapper.updateByPrimaryKeySelective(evaluate);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult selectHotEvaluateByWorksId(int worksId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		String worksUrl = "http://WS-WORKS/works/" + worksId;
		WsResult forObject2 = restTemplate.getForObject(worksUrl, WsResult.class);
		if (forObject2.getStatus() != 0) {
			result.setMsg("作品不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Evaluate> evaluates = mapper.selectByWorksIdOrderByLikeCount(worksId);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(evaluates);
		result.setPage(page.getPageNum());
		result.setTotalPage(page.getPageNum());
		result.setTotalRecored(page.getTotal());
		return result;
	}

	public WsResult deleteEvaluateByUserId(int userId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();		
		int i = mapper.updateStatusTo0ByUserId(userId);
		if (i == 0) {
			result.setStatus(WsConstant.ERROR);
			result.setMsg(WsConstant.ERROR_MSG);
			return result;
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}


	public WsResult recoverEvaluateByUsersId(int userId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();		
		int i = mapper.updateStatusTo1ByUserId(userId);
		if (i == 0) {
			result.setStatus(WsConstant.ERROR);
			result.setMsg(WsConstant.ERROR_MSG);
			return result;
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult deleteEvaluateByWorksId(int worksId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();		
		int i = mapper.updateStatusTo0ByUserId(worksId);
		if (i == 0) {
			result.setStatus(WsConstant.ERROR);
			result.setMsg(WsConstant.ERROR_MSG);
			return result;
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult recoverEvaluateByWorksId(int worksId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();		
		int i = mapper.updateStatusTo1ByUserId(worksId);
		if (i == 0) {
			result.setStatus(WsConstant.ERROR);
			result.setMsg(WsConstant.ERROR_MSG);
			return result;
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

}
