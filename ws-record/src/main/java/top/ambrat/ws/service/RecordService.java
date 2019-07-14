package top.ambrat.ws.service;

import top.ambrat.ws.entity.Record;
import top.ambrat.ws.util.WsResult;

public interface RecordService {

	/** �����Ʒ������¼ **/
	public WsResult addRcord(Record record); 
	
	/** ͨ��idɾ����Ʒ������¼ **/
	public WsResult deleteRcord(int id);
	
	/** ͨ��id�ָ���Ʒ������¼ **/	
	public WsResult recoverRcord(int id);
	
	/** ͨ��id��ѯ��Ʒ������¼ **/	
	public WsResult getRcordById(int id);
	
	/** ͨ��id��ѯ��Ʒ������¼ **/	
	public WsResult getRcordByWorksId(int worksId, int pageNum, int pageSize);

}
