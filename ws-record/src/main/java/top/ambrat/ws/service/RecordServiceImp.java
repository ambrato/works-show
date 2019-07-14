package top.ambrat.ws.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.ambrat.ws.dao.RecordMapper;
import top.ambrat.ws.entity.Record;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;

@RestController
public class RecordServiceImp implements RecordService {

	@Autowired
	private RecordMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public WsResult addRcord(Record record) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		String worksUrl = "http://WS-WORKS/works/" + record.getWorksId();
		WsResult forObject2 = restTemplate.getForObject(worksUrl, WsResult.class);
		if (forObject2.getStatus() != 0) {
			result.setMsg("作品不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		record.setPublishTime(new Date());
		mapper.insertSelective(record);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult deleteRcord(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Record record = mapper.selectByPrimaryKey(id);
		if (record == null) {
			result.setMsg(WsConstant.ERROR_MSG);
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		mapper.updateStatusTo0ById(id);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult recoverRcord(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Record record = mapper.selectByPrimaryKey(id);
		if (record == null) {
			result.setMsg(WsConstant.ERROR_MSG);
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		mapper.updateStatusTo1ById(id);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult getRcordById(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Record record = mapper.selectByPrimaryKey(id);
		if (record == null) {
			result.setMsg(WsConstant.ERROR_MSG);
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult getRcordByWorksId(int worksId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Record> recordList = mapper.selectByWorksId(worksId);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(recordList);
		result.setPage(page.getPageNum());
		result.setTotalPage(page.getPages());
		result.setTotalRecored(page.getTotal());
		return result;
	}

}
