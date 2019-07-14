package top.ambrat.ws.service;

import top.ambrat.ws.entity.Evaluate;
import top.ambrat.ws.util.WsResult;

public interface EvaluateService {

	/** �������� **/
	public WsResult insertEvaluate(Evaluate evaluate);
	
	/** ɾ������ **/
	public WsResult deleteEvaluate(int id);
	
	/** �ָ����� **/
	public WsResult recoverEvaluate(int id);
	
	/** ͨ��id��ѯ���� **/
	public WsResult selectEvaluateById(int id);
	
	/** ͨ����Ʒid��ѯ���� **/
	public WsResult selectEvaluateByWorksId(int worksId, int pageNum, int pageSize);
	
	/** ͨ���û�id��ѯ���� **/
	public WsResult selectEvaluateByUserId(int userId, int pageNum, int pageSize);
	
	/** �޸ĵ������� **/
	public WsResult updateLikeCount(Evaluate evaluate);
	
	/** ͨ����Ʒid��ѯ�������ߵ����� **/
	public WsResult selectHotEvaluateByWorksId(int worksId, int pageNum, int pageSize);
	
	/** �����û�idɾ������ **/
	public WsResult deleteEvaluateByUserId(int userId);
	
	/** �����û�id�ָ����� **/
	public WsResult recoverEvaluateByUsersId(int userId);

	/** ������Ʒidɾ������ **/
	public WsResult deleteEvaluateByWorksId(int worksId);
	
	/** ������Ʒid�ָ����� **/
	public WsResult recoverEvaluateByWorksId(int worksId);
}
