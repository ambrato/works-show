package top.ambrat.ws.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.ambrat.ws.dao.AudioMapper;
import top.ambrat.ws.entity.Audio;
import top.ambrat.ws.util.Upload;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;
@Service
public class AudioServiceImp implements AudioService {

	@Value("${audio.location}")
	private String location;
	
	@Autowired
	private AudioMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public WsResult insertAudio(int worksId, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		Audio audio = new Audio();
		WsResult result = new WsResult();
		String url = "http://WS-WORKS/works/" + worksId;
		WsResult forObject = restTemplate.getForObject(url, WsResult.class);
		if (forObject.getStatus() != 0) {
			result.setMsg("��Ʒ������");
			result.setStatus(WsConstant.ERROR);
			return result;
		}
		
		
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
	    System.out.println(filePath);
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
	    
	    audio.setUrl(file_name);
		
		
		audio.setWorksId(worksId);
		audio.setUploadTime(new Date());
		mapper.insertSelective(audio);
		result.setMsg("��Ƶ�ϴ��ɹ�");
		result.setStatus(WsConstant.SUCCESS);
		result.setData(file_name);
		return result;
	}

	public WsResult deleteAudio(int id) {
		WsResult result = new WsResult();
		Audio audio = mapper.selectByPrimaryKey(id);
		if (audio == null) {
			result.setMsg("Ҫɾ����ͼƬ�����ڣ�");
			result.setStatus(WsConstant.ERROR);
		}
		mapper.updateStatusTo0ByPrimaryKey(id);
		result.setMsg("ɾ��ͼƬ�ɹ���");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}
	
	public WsResult recoverAudio(int id){
		WsResult result = new WsResult();
		Audio audio = mapper.selectByPrimaryKey(id);
		if (audio == null) {
			result.setMsg("Ҫ�ָ���ͼƬ�����ڣ�");
			result.setStatus(WsConstant.ERROR);
		}
		mapper.updateStatusTo1ByPrimaryKey(id);
		result.setMsg("�ָ�ͼƬ�ɹ���");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult selectAudio(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Audio audio = mapper.selectByPrimaryKey(id);
		if (audio == null) {
			result.setMsg("Ҫ��ѯ����Ƶ������");
			result.setStatus(WsConstant.ERROR);
			return result;
			
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(audio);
		return result;
	}

	public WsResult selectAudioByWorksId(int worksId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		List<Audio> AudioList = mapper.selectByWorksId(worksId);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(AudioList);
		return result;
	}

}