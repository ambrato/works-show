package top.ambrat.ws.controller;

import org.apache.commons.collections.functors.FalsePredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.entity.Works;
import top.ambrat.ws.service.WorksService;
import top.ambrat.ws.util.WsResult;

/**�����˿�7002**/
@RestController
public class WorksController {

	@Autowired
	private WorksService service;
	
	/** ������Ʒ������� **/
	@PostMapping("/works/add")
	public WsResult addWorks(Works works){
		WsResult result = service.insertWorks(works);
		return result;
	}
	
	/** ������Ʒɾ������ **/
	@PutMapping("/works/delete/{worksId}")
	public WsResult deleteWorks(@PathVariable("worksId")int worksId){
		WsResult result = service.deleteWordsByWid(worksId);
		return result;
	}
	
	/** ������Ʒ�޸����� **/
	@PutMapping("/works/update")
	public WsResult updateWorks(Works works){
		return service.updateWorks(works);
	}
	
	/** ����ͨ��id��ѯ��Ʒ���� **/
	@GetMapping("/works/{id}")
	public WsResult getWorksById(@PathVariable("id")int id){
		return service.selectWorksById(id);
	}
	
	/** ����ͨ��id��ѯ��Ʒ���� **/
	@GetMapping("/works/byuser/{userId}")
	public WsResult getWorksByUserId(@PathVariable("userId")int userId){
		return service.selectWorksByUserId(userId);
	}
	
	/** ����ͨ���ؼ��ֲ�ѯ��Ʒ���� **/
	@GetMapping("/works/keyword")
	public WsResult getWorksByKeyword(
			@RequestParam(value="keyword",required=true)String keyword, 
			@RequestParam(value="pageNum",required=false, defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false, defaultValue="10")int pageSize){
		return service.selectWorksByName(keyword, pageNum, pageSize);
	}
	
	
	/** �����޶�������ѯ��Ʒ **/
	@GetMapping("/works/limit")
	public WsResult getWorksBylimit(
			@RequestParam(value="type_id",required=false)int type_id, 
			@RequestParam(value="orderWhat",required=false, defaultValue="publish_time")String orderWhat, 
			@RequestParam(value="orderType",required=false, defaultValue="desc")String orderType, 
			@RequestParam(value="pageNum",required=false, defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false, defaultValue="9")int pageSize){
		return service.selctWorksByLimit(type_id, orderWhat, orderType, pageNum, pageSize);
	}
	
	/** �����޶�������ѯ��Ʒ **/
	@GetMapping("/works/limit2")
	public WsResult getWorksBylimit(
			@RequestParam(value="orderWhat",required=false, defaultValue="publish_time")String orderWhat, 
			@RequestParam(value="orderType",required=false, defaultValue="desc")String orderType, 
			@RequestParam(value="pageNum",required=false, defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false, defaultValue="9")int pageSize){
		return service.selctWorksByLimit2(orderWhat, orderType, pageNum, pageSize);
	}

	
	
	/** ������Ʒ�����ϴ����� **/
	@PostMapping("/works/img/upload")
	public WsResult uploadImg(@RequestParam("file") MultipartFile multipartFile){
			
		 return service.uploadImg(multipartFile);
		
	}
	
	
	/** ���ӷ����� **/
	@PutMapping("/works/addViewCount/{worksId}")
	public WsResult addViewCount(@PathVariable("worksId")int worksId){
		return service.addViewCount(worksId);
	}
	
}
