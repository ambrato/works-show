package top.ambrat.ws.service;

import top.ambrat.ws.entity.CollectWorks;
import top.ambrat.ws.util.WsResult;

public interface CollectWorksService {

	/** 添加作品收藏 **/
	public WsResult insertCW(CollectWorks collectWorks);
	
	/** 删除作品收藏 **/
	public WsResult deleteCW(int id);
	
	/** 按用户id批量查询作品收藏 **/
	public WsResult selectCWbyUserId(int userId, int pageNum, int pageSize);
	
	
}
