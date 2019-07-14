package top.ambrat.ws.cotroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.ambrat.ws.entity.Evaluate;
import top.ambrat.ws.service.EvaluateService;
import top.ambrat.ws.util.WsResult;

/** �����˿� 7008 **/

@RestController
public class EvaluateController {

	@Autowired
	private EvaluateService service;
	
	/** ��������������� **/
	@PostMapping("/evaluate/add")
	public WsResult addEvaluate(Evaluate evaluate){
		return service.insertEvaluate(evaluate);
	}
	
	/** ����ɾ���������� **/
	@PutMapping("/evaluate/delete/{id}")
	public WsResult deleteEvaluate(@PathVariable("id")int id){
		return service.deleteEvaluate(id);
	}
	
	/** ����ָ��������� **/
	@PutMapping("/evaluate/recover/{id}")
	public WsResult recoverEvaluate(@PathVariable("id")int id){
		return service.recoverEvaluate(id);
	}
	
	/** ����ͨ��id��ѯ�������� **/
	@GetMapping("/evaluate/{id}")
	public WsResult getEvaluateById(@PathVariable("id")int id){
		return service.selectEvaluateById(id);
	}
	
	
	/** ����ͨ����Ʒid��ѯ�������� **/
	@GetMapping("/evaluate/worksId")
	public WsResult getEvaluateByWorksId(
			@RequestParam(value="worksId",required=true)int worksId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="10")int pageSize){
		return service.selectEvaluateByWorksId(worksId, pageNum, pageSize);
	}
	
	/** ����ͨ���û�id��ѯ�������� **/
	@GetMapping("/evaluate/userId")
	public WsResult getEvaluateByUserId(
			@RequestParam(value="userId",required=true)int userId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="10")int pageSize){
		return service.selectEvaluateByUserId(userId, pageNum, pageSize);
	}
	
	/** �����޸ĵ����������� **/
	@PutMapping("/evaluate/updateLikeCount")
	public WsResult updateLikeCount(Evaluate evaluate){
		return service.updateLikeCount(evaluate);
	}
	
	/** ����ͨ����Ʒid��ѯ�������ߵ��������� **/
	@GetMapping("/evaluate/getHotEva")
	public WsResult getHotEvaluateByWorksId(
			@RequestParam(value="worksId",required=true)int worksId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="3")int pageSize){
		return service.selectHotEvaluateByWorksId(worksId, pageNum, pageSize);
	}
	
	/** ��������û�idɾ���������� **/
	@PutMapping("/evaluate/delEvaByU")
	public WsResult deleteEvaluateByUserId(int userId){
		return service.deleteEvaluateByUserId(userId);
	}
	
	/** ��������û�id�ָ��������� **/
	@PutMapping("/evaluate/reEvaByU")
	public WsResult recoverEvaluateByUsersId(int userId){
		return service.recoverEvaluateByUsersId(userId);
	}

	/** ���������Ʒidɾ���������� **/
	@PutMapping("/evaluate/delEvaByW")
	public WsResult deleteEvaluateByWorksId(int worksId){
		return service.deleteEvaluateByWorksId(worksId);
	}
	
	/** ���������Ʒid�ָ��������� **/
	@PutMapping("/evaluate/reEvaByW")
	public WsResult recoverEvaluateByWorksId(int worksId){
		return service.recoverEvaluateByWorksId(worksId);
	}
}
