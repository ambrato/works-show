package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.entity.Audio;
import top.ambrat.ws.util.WsResult;

public interface AudioService {

	/** 插入新的音频 **/
	public WsResult insertAudio(int worksId, MultipartFile multipartFile);
	/** 删除音频 **/
	public WsResult deleteAudio(int id);
	/** 恢复音频 **/
	public WsResult recoverAudio(int id);
	/** 根据音频id查询音频 **/
	public WsResult selectAudio(int id);
	/** 根据作品id查询音频 **/
	public WsResult selectAudioByWorksId(int worksId);
	
}
