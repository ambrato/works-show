package top.ambrat.ws.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.ambrat.ws.dao.WorksMapper;
import top.ambrat.ws.entity.Works;
import top.ambrat.ws.util.Upload;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;

@Service
public class WorksServiceImp implements WorksService {

	
	  /**
     * �������ļ������õ��ļ�����·��
     */
    @Value("${img.location}")
    private String location;
	
	
	@Autowired
	private WorksMapper mapper;
	
	
	public WsResult insertWorks(Works works) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		if (StringUtils.isEmpty(works.getName())) {
			result.setMsg("���ⲻ��Ϊ�գ�");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		if (StringUtils.isEmpty(works.getIntro())) {
			result.setMsg("��鲻��Ϊ�գ�");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		if (StringUtils.isEmpty(works.getImage())) {
			result.setMsg("�����ϴ����棡");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		
		//�����Ʒ����ͼ�黹�з��涼��Ϊ�� �������ݿ�����µ���Ʒ
		works.setPublishTime(new Date());
		mapper.insertSelective(works);
		result.setStatus(WsConstant.SUCCESS);
		result.setMsg(WsConstant.SUCCESS_MSG);
		
	
		return result;
	}

	public WsResult deleteWordsByWid(int WorksId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		//�Ȳ�ѯ�����Ʒ�Ƿ������ݿ��д���
		Works works = mapper.selectByPrimaryKey(WorksId);
		if (works == null) {
			result.setMsg("��Ʒ������");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		//����Ʒ���ڣ�����Ʒ��״̬���1��Ϊ0
		mapper.updateStatusTo0ByPrimaryKey(WorksId);
		result.setMsg("��Ʒɾ���ɹ�");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}
	
	public WsResult recoverWordsByWid(int WorksId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		//�Ȳ�ѯ�����Ʒ�Ƿ������ݿ��д���
		Works works = mapper.selectByPrimaryKey(WorksId);
		if (works == null) {
			result.setMsg("��Ʒ������");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		//����Ʒ���ڣ�����Ʒ��״̬���0��Ϊ1
		mapper.updateStatusTo1ByPrimaryKey(WorksId);
		result.setMsg("��Ʒɾ���ɹ�");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult updateWorks(Works works) {
		WsResult result = new WsResult();
		int i = mapper.updateByPrimaryKeySelective(works);
		if (i == 0) {
			result.setMsg("�޸�ʧ��");
			result.setStatus(WsConstant.ERROR);
			return result;
			
		}
		// TODO Auto-generated method stub
		result.setMsg("�޸���Ʒ��Ϣ�ɹ�");
		result.setStatus(WsConstant.SUCCESS);
		
		return result;
	}

	public WsResult selectWorksById(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Works works = mapper.selectByPrimaryKey(id);
		if (works == null) {
			result.setMsg("��Ʒ��ѯʧ��");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		result.setMsg("��Ʒ��ѯ�ɹ�");
		result.setStatus(WsConstant.SUCCESS);
		result.setData(works);
		
		return result;
	}
	
	public WsResult selectWorksByUserId(int userId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		List<Works> byUserId = mapper.selectByUserId(userId);
		
		result.setMsg("��Ʒ��ѯ�ɹ�");
		result.setStatus(WsConstant.SUCCESS);
		result.setData(byUserId);
		
		return result;
	}

	public WsResult selectWorksByName(String keyword, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		if (StringUtils.isEmpty(keyword)) {
			result.setMsg("�ؼ���Ϊ�գ��޷���ѯ");
			result.setStatus(WsConstant.ERROR);
		}
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Works> worksList = mapper.selectByKeyword("%" + keyword + "%");
		result.setMsg(WsConstant.QUERY_SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(worksList);
		result.setPage(page.getPageNum());
		result.setTotalPage(page.getPages());
		result.setTotalRecored(page.getTotal());
		return result;
	}

	public WsResult selctWorksByLimit(int type_id, String orderWhat, String orderType, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		if (type_id == 0) {
			Page page = PageHelper.startPage(pageNum, pageSize);
			List<Works> worksList = mapper.selectByLimit2(orderWhat, orderType);
			result.setMsg(WsConstant.QUERY_SUCCESS_MSG);
			result.setStatus(WsConstant.SUCCESS);
			result.setData(worksList);
			result.setPage(page.getPageNum());
			result.setTotalPage(page.getPages());
			result.setTotalRecored(page.getTotal());
			return result;
		}
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Works> worksList = mapper.selectByLimit(type_id, orderWhat, orderType);
		result.setMsg(WsConstant.QUERY_SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(worksList);
		result.setPage(page.getPageNum());
		result.setTotalPage(page.getPages());
		result.setTotalRecored(page.getTotal());
		return result;
	}
	public WsResult selctWorksByLimit2(String orderWhat, String orderType, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Works> worksList = mapper.selectByLimit2(orderWhat, orderType);
		result.setMsg(WsConstant.QUERY_SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(worksList);
		result.setPage(page.getPageNum());
		result.setTotalPage(page.getPages());
		result.setTotalRecored(page.getTotal());
		return result;
	}
	
	public WsResult uploadImg(MultipartFile multipartFile){
		WsResult result = new WsResult();
		if (multipartFile.isEmpty() || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
				result.setStatus(1);
				result.setMsg(WsConstant.UPDATE_IMG_ERROR1_MSG);
				return result;
	    }
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
        	result.setStatus(2);
			result.setMsg(WsConstant.UPDATE_IMG_ERROR1_MSG);
			return result;
        }
        String root_fileName = multipartFile.getOriginalFilename();
        //logger.info("�ϴ�ͼƬ:name={},type={}", root_fileName, contentType);
        //����ͼƬ
        //User currentUser = mapper.selectNkNameAndImageByPrimaryKey(userId);
        //��ȡ·��
       
        String filePath = location;
        String file_name = null;
        try {
            file_name = Upload.saveFile(multipartFile, filePath);
           
            if(StringUtils.isEmpty(file_name)){
            	result.setStatus(3);
            	result.setMsg(WsConstant.UPDATE_IMG_ERROR1_MSG);
            	return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    result.setStatus(WsConstant.SUCCESS);
	result.setMsg("�ϴ��ɹ�");
	result.setData(file_name);
	
    return result;
	}
	
	
	public WsResult addViewCount(int worksId){
		WsResult result = new WsResult();
		Works works = mapper.selectByPrimaryKey(worksId);
		if (works == null) {
			result.setMsg(WsConstant.ERROR_MSG);
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		works.setViewCount(works.getViewCount()+1);
		mapper.updateByPrimaryKeySelective(works);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}
	
	

}
