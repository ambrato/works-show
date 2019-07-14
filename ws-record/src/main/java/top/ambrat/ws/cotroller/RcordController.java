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

/** �����˿� 7011 **/
@RestController
public class RcordController {

	
	@Autowired
	private RecordService service;
	
	/** ���������Ʒ������¼���� **/
	@PostMapping("/record/add")
	public WsResult addRecord(Record record){
		return service.addRcord(record);
	}
	
	/** ����ͨ��idɾ����Ʒ������¼���� **/
	@PutMapping("/record/delete/{id}")
	public WsResult deleteRecord(@PathVariable("id")int id){
		return service.deleteRcord(id);
	}
	
	/** ����ͨ��id�ָ���Ʒ������¼���� **/
	@PutMapping("/record/recover/{id}")
	public WsResult recoverRecord(@PathVariable("id")int id){
		return service.recoverRcord(id);
	}
	
	/** ����ͨ��id��ѯ��Ʒ������¼���� **/	
	@GetMapping("/record/{id}")
	public WsResult getRecordById(@PathVariable("id")int id){
		return service.getRcordById(id);
	}
	
	/** ����ͨ��id��ѯ��Ʒ������¼���� **/	
	@GetMapping("/record/byWorkId")
	public WsResult getRecordByWorksId(
			@RequestParam(value="worksId",required=true)int worksId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="10")int pageSize){
		return service.getRcordByWorksId(worksId, pageNum, pageSize);
	}
	
	
}
