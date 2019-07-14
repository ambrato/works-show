package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.util.WsResult;

public interface ImageService {

	/** �����µ���Ƶ **/
	public WsResult insertImage(int worksId, MultipartFile multipartFile);
	/** ɾ����Ƶ **/
	public WsResult deleteImage(int id);
	/** �ָ���Ƶ **/
	public WsResult recoverImage(int id);
	/** ������Ƶid��ѯ��Ƶ **/
	public WsResult selectImage(int id);
	/** ������Ʒid��ѯ��Ƶ **/
	public WsResult selectImageByWorksId(int worksId);
	
}
