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

/** �����˿�7003 **/
@RestController
public class VideoController {

	@Autowired
	private VideoService service;
	
	/** ���������Ʒ��Ƶ������ **/
	@PostMapping("/video/add")
	public WsResult addVideo(@RequestParam("worksId")int worksId,
    		@RequestParam("file") MultipartFile multipartFile){
		return service.insertVideo(worksId, multipartFile);
	}
	
	/**����ɾ����Ʒ��Ƶ������**/
	@PutMapping("/video/delete/{id}")
	public WsResult deleteVideo(@PathVariable("id")int id){
		return service.deleteVideo(id);
	}
	
	/** ����ָ���Ʒ��Ƶ������ **/
	@PutMapping("/video/recover/{id}")
	public WsResult recoverVideo(@PathVariable("id")int id){
		return service.recoverVideo(id);
	}
	
	/** ���������Ƶid��ѯ��Ƶ���� **/
	@GetMapping("/video/{id}")
	public WsResult getVideo(@PathVariable("id")int id){
		return service.selectVideo(id);
	}
	
	/** ���������Ʒid��ѯ��Ƶ���� **/
	@GetMapping("/video/works/{worksId}")
	public WsResult getVideoByWorksId(@PathVariable("worksId")int worksId){
		return service.selectVideoByWorksId(worksId);
	}
	
	
	
}
