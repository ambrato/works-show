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


import top.ambrat.ws.dao.ImageMapper;

import top.ambrat.ws.entity.Image;
import top.ambrat.ws.util.Upload;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;
@Service
public class ImageServiceImp implements ImageService {

	@Value("${img.location}")
	private String location;
	
	@Autowired
	private ImageMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public WsResult insertImage(int worksId, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		Image image = new Image();
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
		image.setUrl(file_name);		
		image.setWorksId(worksId);
		image.setUploadTime(new Date());
		mapper.insertSelective(image);
		result.setMsg("图片上传成功");
		result.setStatus(WsConstant.SUCCESS);
		result.setData(file_name);
		return result;
	}

	public WsResult deleteImage(int id) {
		WsResult result = new WsResult();
		Image image = mapper.selectByPrimaryKey(id);
		if (image == null) {
			result.setMsg("要删除的图片不存在！");
			result.setStatus(WsConstant.ERROR);
		}
		mapper.updateStatusTo0ByPrimaryKey(id);
		result.setMsg("删除图片成功！");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}
	
	public WsResult recoverImage(int id){
		WsResult result = new WsResult();
		Image image = mapper.selectByPrimaryKey(id);
		if (image == null) {
			result.setMsg("要恢复的图片不存在！");
			result.setStatus(WsConstant.ERROR);
		}
		mapper.updateStatusTo1ByPrimaryKey(id);
		result.setMsg("恢复图片成功！");
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult selectImage(int id) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Image image = mapper.selectByPrimaryKey(id);
		if (image == null) {
			result.setMsg("要查询的图片不存在");
			result.setStatus(WsConstant.ERROR);
			return result;
			
		}
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(image);
		return result;
	}

	public WsResult selectImageByWorksId(int worksId) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		List<Image> ImageList = mapper.selectByWorksId(worksId);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(ImageList);
		return result;
	}

}
