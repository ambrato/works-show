package top.ambrat.ws.service;

import org.springframework.web.multipart.MultipartFile;

import top.ambrat.ws.entity.Works;
import top.ambrat.ws.util.WsResult;

public interface WorksService {

	/** 添加作品 **/
	public WsResult insertWorks(Works works);
	
	/** 根据id删除作品 **/
	public WsResult deleteWordsByWid(int WorksId);
	
	/** 根据id恢复删除作品 **/
	public WsResult recoverWordsByWid(int WorksId);
	
	/** 修改作品 **/
	public WsResult updateWorks(Works works);
	
	/** 通过id查询作品 **/
	public WsResult selectWorksById(int id);
	public WsResult selectWorksByUserId(int userId);
	
	/** 通过关键字查询作品 **/
	public WsResult selectWorksByName(String keyword, int pageNum, int pageSize);
	
	/**
	 * 批量按条件分页查询作品
	 * @param type_id 分类id
	 * @param orderWhat 通过哪一个字段排序
	 * @param orderType 排序类型（升序或者降序）
	 * @param pageNum 第几页
	 * @param pageSize 每一页多少结果
	 * @return
	 */
	public WsResult selctWorksByLimit(int type_id, String orderWhat, String orderType, int pageNum, int pageSize );
	public WsResult selctWorksByLimit2(String orderWhat, String orderType, int pageNum, int pageSize );
	
	/** 上传作品封面 **/
	public WsResult uploadImg(MultipartFile multipartFile);
	
	/** 增加访问量  **/
	/** 上传作品封面 **/
	public WsResult addViewCount(int worksId);
	
	/**  **/
}
