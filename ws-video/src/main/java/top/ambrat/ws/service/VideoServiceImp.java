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

import top.ambrat.ws.dao.VideoMapper;
import top.ambrat.ws.entity.Video;
import top.ambrat.ws.util.Upload;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;
@Service
public class VideoServiceImp implements VideoService {

	@Value("${video.location}")
	private String location;
	
	@Autowired
	private VideoMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public WsResult insertVideo(int worksId, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		Video video = new Video();
		WsResult result = new WsResult();
		String url = "http://WS-WORKS/works/" + worksId;
		WsResult forObject = restTemplate.getForObject(url, WsResult.class);
		if (forObject.getStatus() != 0) {
			result.setMsg("作品不存在");
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
	    //logger.info("上传图片:name={},type={}", root_fileName, contentType);
	    //处理图片
	    //User currentUser = mapper.selectNkNameAndImageByPrimaryKey(userId);
	    //获取路径
	   
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
		
		video.setUrl(file_name);
		video.setWorksId(worksId);
		video.setUploadTime(new Date());
		mapper.insertSelective(video);
		result.setMsg("视频上传成功");
		result.setData(file_name);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult deleteVideo(int id) {
		WsResult result = new WsResult();
		Video video = mapper.selectByPrimaryKey(id);
		if (video == null) {
			result.setMsg("要删除的图片不存在！");
			result.setStatus(WsConstant.ERROR);
		}
		mapper.updateStatusTo0ByPrimaryKey(id);
		result.setMsg("删除图片成功！");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}
	
	public WsResult recoverVideo(int id){
		WsResult result = new WsResult();
		Video video = mapper.selectByPrimaryKey(id);
		if (video == null) {
			result.setMsg("要恢复的图片不存在！");
			result.setStatus(WsConstant.ERROR);
		}
		mapper.updateStatusTo1ByPrimaryKey(id);
		result.setMsg("恢复图片成功！");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult selectVideo(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Video video = mapper.selectByPrimaryKey(id);
		if (video == null) {
			result.setMsg("要查询的音频不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
			
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(video);
		return result;
	}

	public WsResult selectVideoByWorksId(int worksId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		List<Video> videoList = mapper.selectByWorksId(worksId);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(videoList);
		return result;
	}

}
