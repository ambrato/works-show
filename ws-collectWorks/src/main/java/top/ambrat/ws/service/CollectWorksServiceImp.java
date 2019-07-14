package top.ambrat.ws.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.ambrat.ws.dao.CollectWorksMapper;
import top.ambrat.ws.entity.CollectWorks;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;

@Service
public class CollectWorksServiceImp implements CollectWorksService {

	@Autowired
	private CollectWorksMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;

	public WsResult insertCW(CollectWorks collectWorks) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		if (collectWorks == null) {
			result.setMsg("收藏失败");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		String userUrl = "http://WS-USER/user/" + collectWorks.getUserId();
		WsResult forObject1 = restTemplate.getForObject(userUrl, WsResult.class);
		if (forObject1.getStatus() != 0) {
			result.setMsg("用户不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		CollectWorks byWU = mapper.selectByWU(collectWorks.getWorksId(), collectWorks.getUserId());
		if (byWU != null) {
			result.setMsg("请不要重复收藏！");
			result.setStatus(WsConstant.SUCCESS);
			return result;
		}
		collectWorks.setCollectTime(new Date());
		mapper.insertSelective(collectWorks);
		result.setMsg("收藏成功！");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult deleteCW(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		CollectWorks collectWorks = mapper.selectByPrimaryKey(id);
		if (collectWorks == null) {
			result.setMsg("要删除的收藏记录不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		mapper.updateStatusTo0ByPrimaryKey(id);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult selectCWbyUserId(int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<CollectWorks> collectWorksList = mapper.selectByUserId(userId);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(collectWorksList);
		result.setPage(page.getPageNum());
		result.setTotalPage(page.getPages());
		result.setTotalRecored(page.getTotal());
		return result;
	}
	
	
}
