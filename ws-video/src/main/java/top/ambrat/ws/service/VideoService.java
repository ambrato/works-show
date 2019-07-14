package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;


import top.ambrat.ws.util.WsResult;

public interface VideoService {

	/** �����µ���Ƶ **/
	public WsResult insertVideo(int worksId, MultipartFile multipartFile);
	/** ɾ����Ƶ **/
	public WsResult deleteVideo(int id);
	/** �ָ���Ƶ **/
	public WsResult recoverVideo(int id);
	/** ������Ƶid��ѯ��Ƶ **/
	public WsResult selectVideo(int id);
	/** ������Ʒid��ѯ��Ƶ **/
	public WsResult selectVideoByWorksId(int worksId);
	
}
