package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;


import top.ambrat.ws.util.WsResult;

public interface VideoService {

	/** 插入新的音频 **/
	public WsResult insertVideo(int worksId, MultipartFile multipartFile);
	/** 删除音频 **/
	public WsResult deleteVideo(int id);
	/** 恢复音频 **/
	public WsResult recoverVideo(int id);
	/** 根据音频id查询音频 **/
	public WsResult selectVideo(int id);
	/** 根据作品id查询音频 **/
	public WsResult selectVideoByWorksId(int worksId);
	
}
