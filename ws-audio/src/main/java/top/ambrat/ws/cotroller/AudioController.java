package top.ambrat.ws.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import top.ambrat.ws.service.AudioService;

import top.ambrat.ws.util.WsResult;

/** 监听端口7005 **/
@RestController
public class AudioController {

	@Autowired
	private AudioService service;
	
	/** 处理添加作品音频的请求 **/
	@PostMapping("/audio/add")
	public WsResult addAudio(@RequestParam("worksId")int worksId,
    		@RequestParam("file") MultipartFile multipartFile){
		return service.insertAudio(worksId, multipartFile);
	}
	
	/**处理删除作品音频的请求**/
	@PutMapping("/audio/delete/{id}")
	public WsResult deleteAudio(@PathVariable("id")int id){
		return service.deleteAudio(id);
	}
	
	/** 处理恢复作品音频的请求 **/
	@PutMapping("/audio/recover/{id}")
	public WsResult recoverAudio(@PathVariable("id")int id){
		return service.recoverAudio(id);
	}
	
	/** 处理根据音频id查询音频请求 **/
	@GetMapping("/audio/{id}")
	public WsResult getAudio(@PathVariable("id")int id){
		return service.selectAudio(id);
	}
	
	/** 处理根据作品id查询音频请求 **/
	@GetMapping("/audio/works/{worksId}")
	public WsResult getAudioByWorksId(@PathVariable("worksId")int worksId){
		return service.selectAudioByWorksId(worksId);
	}
	
	
	
}
