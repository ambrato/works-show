package top.ambrat.ws.service;

import top.ambrat.ws.entity.Record;
import top.ambrat.ws.util.WsResult;

public interface RecordService {

	/** 添加作品创作记录 **/
	public WsResult addRcord(Record record); 
	
	/** 通过id删除作品创作记录 **/
	public WsResult deleteRcord(int id);
	
	/** 通过id恢复作品创作记录 **/	
	public WsResult recoverRcord(int id);
	
	/** 通过id查询作品创作记录 **/	
	public WsResult getRcordById(int id);
	
	/** 通过id查询作品创作记录 **/	
	public WsResult getRcordByWorksId(int worksId, int pageNum, int pageSize);

}
