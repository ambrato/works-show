package top.ambrat.ws.service;

import top.ambrat.ws.entity.Type;
import top.ambrat.ws.util.WsResult;

public interface TypeService {

	/** ������Ʒ���� **/
	public WsResult insertType(Type type);
	
	/** �޸���Ʒ���� **/
	public WsResult updateType(Type type);
	
	/** ��ѯ������Ʒ  **/
	public  WsResult getType();
}
