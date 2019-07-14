package top.ambrat.ws.service;

import top.ambrat.ws.entity.Evaluate;
import top.ambrat.ws.util.WsResult;

public interface EvaluateService {

	/** 插入评论 **/
	public WsResult insertEvaluate(Evaluate evaluate);
	
	/** 删除评论 **/
	public WsResult deleteEvaluate(int id);
	
	/** 恢复评论 **/
	public WsResult recoverEvaluate(int id);
	
	/** 通过id查询评论 **/
	public WsResult selectEvaluateById(int id);
	
	/** 通过作品id查询评论 **/
	public WsResult selectEvaluateByWorksId(int worksId, int pageNum, int pageSize);
	
	/** 通过用户id查询评论 **/
	public WsResult selectEvaluateByUserId(int userId, int pageNum, int pageSize);
	
	/** 修改点赞数量 **/
	public WsResult updateLikeCount(Evaluate evaluate);
	
	/** 通过作品id查询点赞数高的评论 **/
	public WsResult selectHotEvaluateByWorksId(int worksId, int pageNum, int pageSize);
	
	/** 根据用户id删除评论 **/
	public WsResult deleteEvaluateByUserId(int userId);
	
	/** 根据用户id恢复评论 **/
	public WsResult recoverEvaluateByUsersId(int userId);

	/** 根据作品id删除评论 **/
	public WsResult deleteEvaluateByWorksId(int worksId);
	
	/** 根据作品id恢复评论 **/
	public WsResult recoverEvaluateByWorksId(int worksId);
}
