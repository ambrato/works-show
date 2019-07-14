package top.ambrat.ws.service;

import top.ambrat.ws.entity.Type;
import top.ambrat.ws.util.WsResult;

public interface TypeService {

	/** 插入作品类型 **/
	public WsResult insertType(Type type);
	
	/** 修改作品类型 **/
	public WsResult updateType(Type type);
	
	/** 查询所有作品  **/
	public  WsResult getType();
}
