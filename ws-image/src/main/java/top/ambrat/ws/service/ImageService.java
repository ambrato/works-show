package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.util.WsResult;

public interface ImageService {

	/** 插入新的音频 **/
	public WsResult insertImage(int worksId, MultipartFile multipartFile);
	/** 删除音频 **/
	public WsResult deleteImage(int id);
	/** 恢复音频 **/
	public WsResult recoverImage(int id);
	/** 根据音频id查询音频 **/
	public WsResult selectImage(int id);
	/** 根据作品id查询音频 **/
	public WsResult selectImageByWorksId(int worksId);
	
}
