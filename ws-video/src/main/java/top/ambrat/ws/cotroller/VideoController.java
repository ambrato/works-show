package top.ambrat.ws.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import top.ambrat.ws.service.VideoService;

import top.ambrat.ws.util.WsResult;

/** 监听端口7003 **/
@RestController
public class VideoController {

	@Autowired
	private VideoService service;
	
	/** 处理添加作品音频的请求 **/
	@PostMapping("/video/add")
	public WsResult addVideo(@RequestParam("worksId")int worksId,
    		@RequestParam("file") MultipartFile multipartFile){
		return service.insertVideo(worksId, multipartFile);
	}
	
	/**处理删除作品音频的请求**/
	@PutMapping("/video/delete/{id}")
	public WsResult deleteVideo(@PathVariable("id")int id){
		return service.deleteVideo(id);
	}
	
	/** 处理恢复作品音频的请求 **/
	@PutMapping("/video/recover/{id}")
	public WsResult recoverVideo(@PathVariable("id")int id){
		return service.recoverVideo(id);
	}
	
	/** 处理根据音频id查询音频请求 **/
	@GetMapping("/video/{id}")
	public WsResult getVideo(@PathVariable("id")int id){
		return service.selectVideo(id);
	}
	
	/** 处理根据作品id查询音频请求 **/
	@GetMapping("/video/works/{worksId}")
	public WsResult getVideoByWorksId(@PathVariable("worksId")int worksId){
		return service.selectVideoByWorksId(worksId);
	}
	
	
	
}
