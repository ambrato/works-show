package top.ambrat.ws.service;

import top.ambrat.ws.entity.CollectWorks;
import top.ambrat.ws.util.WsResult;

public interface CollectWorksService {

	/** �����Ʒ�ղ� **/
	public WsResult insertCW(CollectWorks collectWorks);
	
	/** ɾ����Ʒ�ղ� **/
	public WsResult deleteCW(int id);
	
	/** ���û�id������ѯ��Ʒ�ղ� **/
	public WsResult selectCWbyUserId(int userId, int pageNum, int pageSize);
	
	
}
