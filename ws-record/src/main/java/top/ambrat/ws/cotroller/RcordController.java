package top.ambrat.ws.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.ambrat.ws.entity.Record;
import top.ambrat.ws.service.RecordService;
import top.ambrat.ws.util.WsResult;

/** 监听端口 7011 **/
@RestController
public class RcordController {

	
	@Autowired
	private RecordService service;
	
	/** 处理添加作品创作记录请求 **/
	@PostMapping("/record/add")
	public WsResult addRecord(Record record){
		return service.addRcord(record);
	}
	
	/** 处理通过id删除作品创作记录请求 **/
	@PutMapping("/record/delete/{id}")
	public WsResult deleteRecord(@PathVariable("id")int id){
		return service.deleteRcord(id);
	}
	
	/** 处理通过id恢复作品创作记录请求 **/
	@PutMapping("/record/recover/{id}")
	public WsResult recoverRecord(@PathVariable("id")int id){
		return service.recoverRcord(id);
	}
	
	/** 处理通过id查询作品创作记录请求 **/	
	@GetMapping("/record/{id}")
	public WsResult getRecordById(@PathVariable("id")int id){
		return service.getRcordById(id);
	}
	
	/** 处理通过id查询作品创作记录请求 **/	
	@GetMapping("/record/byWorkId")
	public WsResult getRecordByWorksId(
			@RequestParam(value="worksId",required=true)int worksId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="10")int pageSize){
		return service.getRcordByWorksId(worksId, pageNum, pageSize);
	}
	
	
}
