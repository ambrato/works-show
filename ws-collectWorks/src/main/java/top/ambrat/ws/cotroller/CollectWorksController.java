package top.ambrat.ws.cotroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.ambrat.ws.entity.CollectWorks;
import top.ambrat.ws.service.CollectWorksService;
import top.ambrat.ws.util.WsResult;

/** �����˿� 7007 **/
@RestController
public class CollectWorksController {

	@Autowired
	private CollectWorksService service;
	
	/** ���������Ʒ�ղ����� **/
	@PostMapping("/collectWorks/add")
	public WsResult addCW(CollectWorks collectWorks){
		return service.insertCW(collectWorks);
	}
	
	/** ����ȡ���ղ���Ʒ���� **/
	@PutMapping("/collectWorks/delete")
	public WsResult deleteCW(int id){
		return service.deleteCW(id);
	}
	
	/**�����û�id��ѯ��Ʒ�ղ��б������**/
	@GetMapping("/collectWorks/getCWlist")
	public WsResult getCWbyUserId(
			@RequestParam(value="userId",required=true)int userId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="10")int pageSize){
		return service.selectCWbyUserId(userId, pageNum, pageSize);
	}
}
