package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.entity.Audio;
import top.ambrat.ws.util.WsResult;

public interface AudioService {

	/** �����µ���Ƶ **/
	public WsResult insertAudio(int worksId, MultipartFile multipartFile);
	/** ɾ����Ƶ **/
	public WsResult deleteAudio(int id);
	/** �ָ���Ƶ **/
	public WsResult recoverAudio(int id);
	/** ������Ƶid��ѯ��Ƶ **/
	public WsResult selectAudio(int id);
	/** ������Ʒid��ѯ��Ƶ **/
	public WsResult selectAudioByWorksId(int worksId);
	
}
