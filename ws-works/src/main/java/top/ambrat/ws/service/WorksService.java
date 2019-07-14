package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.entity.Works;
import top.ambrat.ws.util.WsResult;

public interface WorksService {

	/** �����Ʒ **/
	public WsResult insertWorks(Works works);
	
	/** ����idɾ����Ʒ **/
	public WsResult deleteWordsByWid(int WorksId);
	
	/** ����id�ָ�ɾ����Ʒ **/
	public WsResult recoverWordsByWid(int WorksId);
	
	/** �޸���Ʒ **/
	public WsResult updateWorks(Works works);
	
	/** ͨ��id��ѯ��Ʒ **/
	public WsResult selectWorksById(int id);
	public WsResult selectWorksByUserId(int userId);
	
	/** ͨ���ؼ��ֲ�ѯ��Ʒ **/
	public WsResult selectWorksByName(String keyword, int pageNum, int pageSize);
	
	/**
	 * ������������ҳ��ѯ��Ʒ
	 * @param type_id ����id
	 * @param orderWhat ͨ����һ���ֶ�����
	 * @param orderType �������ͣ�������߽���
	 * @param pageNum �ڼ�ҳ
	 * @param pageSize ÿһҳ���ٽ��
	 * @return
	 */
	public WsResult selctWorksByLimit(int type_id, String orderWhat, String orderType, int pageNum, int pageSize );
	public WsResult selctWorksByLimit2(String orderWhat, String orderType, int pageNum, int pageSize );
	
	/** �ϴ���Ʒ���� **/
	public WsResult uploadImg(MultipartFile multipartFile);
	
	/** ���ӷ�����  **/
	/** �ϴ���Ʒ���� **/
	public WsResult addViewCount(int worksId);
	
	/**  **/
}
