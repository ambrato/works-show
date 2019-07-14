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

/** 监听端口 7008 **/

@RestController
public class EvaluateController {

	@Autowired
	private EvaluateService service;
	
	/** 处理添加评论请求 **/
	@PostMapping("/evaluate/add")
	public WsResult addEvaluate(Evaluate evaluate){
		return service.insertEvaluate(evaluate);
	}
	
	/** 处理删除评论请求 **/
	@PutMapping("/evaluate/delete/{id}")
	public WsResult deleteEvaluate(@PathVariable("id")int id){
		return service.deleteEvaluate(id);
	}
	
	/** 处理恢复评论请求 **/
	@PutMapping("/evaluate/recover/{id}")
	public WsResult recoverEvaluate(@PathVariable("id")int id){
		return service.recoverEvaluate(id);
	}
	
	/** 处理通过id查询评论请求 **/
	@GetMapping("/evaluate/{id}")
	public WsResult getEvaluateById(@PathVariable("id")int id){
		return service.selectEvaluateById(id);
	}
	
	
	/** 处理通过作品id查询评论请求 **/
	@GetMapping("/evaluate/worksId")
	public WsResult getEvaluateByWorksId(
			@RequestParam(value="worksId",required=true)int worksId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="10")int pageSize){
		return service.selectEvaluateByWorksId(worksId, pageNum, pageSize);
	}
	
	/** 处理通过用户id查询评论请求 **/
	@GetMapping("/evaluate/userId")
	public WsResult getEvaluateByUserId(
			@RequestParam(value="userId",required=true)int userId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="10")int pageSize){
		return service.selectEvaluateByUserId(userId, pageNum, pageSize);
	}
	
	/** 处理修改点赞数量请求 **/
	@PutMapping("/evaluate/updateLikeCount")
	public WsResult updateLikeCount(Evaluate evaluate){
		return service.updateLikeCount(evaluate);
	}
	
	/** 处理通过作品id查询点赞数高的评论请求 **/
	@GetMapping("/evaluate/getHotEva")
	public WsResult getHotEvaluateByWorksId(
			@RequestParam(value="worksId",required=true)int worksId, 
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum, 
			@RequestParam(value="pageSize",required=false,defaultValue="3")int pageSize){
		return service.selectHotEvaluateByWorksId(worksId, pageNum, pageSize);
	}
	
	/** 处理根据用户id删除评论请求 **/
	@PutMapping("/evaluate/delEvaByU")
	public WsResult deleteEvaluateByUserId(int userId){
		return service.deleteEvaluateByUserId(userId);
	}
	
	/** 处理根据用户id恢复评论请求 **/
	@PutMapping("/evaluate/reEvaByU")
	public WsResult recoverEvaluateByUsersId(int userId){
		return service.recoverEvaluateByUsersId(userId);
	}

	/** 处理根据作品id删除评论请求 **/
	@PutMapping("/evaluate/delEvaByW")
	public WsResult deleteEvaluateByWorksId(int worksId){
		return service.deleteEvaluateByWorksId(worksId);
	}
	
	/** 处理根据作品id恢复评论请求 **/
	@PutMapping("/evaluate/reEvaByW")
	public WsResult recoverEvaluateByWorksId(int worksId){
		return service.recoverEvaluateByWorksId(worksId);
	}
}
