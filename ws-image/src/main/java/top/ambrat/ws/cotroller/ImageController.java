package top.ambrat.ws.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import top.ambrat.ws.service.ImageService;

import top.ambrat.ws.util.WsResult;

/** 监听端口7009 **/
@RestController
public class ImageController {

	@Autowired
	private ImageService service;
	
	/** 处理添加作品音频的请求 **/
	@PostMapping("/image/add")
	public WsResult addImage(@RequestParam("worksId")int worksId,
    		@RequestParam("file") MultipartFile multipartFile){
		System.out.println(worksId);
		return service.insertImage(worksId, multipartFile);
	}
	
	/**处理删除作品音频的请求**/
	@PutMapping("/image/delete/{id}")
	public WsResult deleteImage(@PathVariable("id")int id){
		return service.deleteImage(id);
	}
	
	/** 处理恢复作品音频的请求 **/
	@PutMapping("/image/recover/{id}")
	public WsResult recoverImage(@PathVariable("id")int id){
		return service.recoverImage(id);
	}
	
	/** 处理根据音频id查询音频请求 **/
	@GetMapping("/image/{id}")
	public WsResult getImage(@PathVariable("id")int id){
		return service.selectImage(id);
	}
	
	/** 处理根据作品id查询音频请求 **/
	@GetMapping("/image/works/{worksId}")
	public WsResult getImageByWorksId(@PathVariable("worksId")int worksId){
		return service.selectImageByWorksId(worksId);
	}
	
	
	
}
