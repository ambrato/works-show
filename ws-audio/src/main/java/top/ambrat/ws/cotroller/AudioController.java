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

/** �����˿�7005 **/
@RestController
public class AudioController {

	@Autowired
	private AudioService service;
	
	/** ���������Ʒ��Ƶ������ **/
	@PostMapping("/audio/add")
	public WsResult addAudio(@RequestParam("worksId")int worksId,
    		@RequestParam("file") MultipartFile multipartFile){
		return service.insertAudio(worksId, multipartFile);
	}
	
	/**����ɾ����Ʒ��Ƶ������**/
	@PutMapping("/audio/delete/{id}")
	public WsResult deleteAudio(@PathVariable("id")int id){
		return service.deleteAudio(id);
	}
	
	/** ����ָ���Ʒ��Ƶ������ **/
	@PutMapping("/audio/recover/{id}")
	public WsResult recoverAudio(@PathVariable("id")int id){
		return service.recoverAudio(id);
	}
	
	/** ���������Ƶid��ѯ��Ƶ���� **/
	@GetMapping("/audio/{id}")
	public WsResult getAudio(@PathVariable("id")int id){
		return service.selectAudio(id);
	}
	
	/** ���������Ʒid��ѯ��Ƶ���� **/
	@GetMapping("/audio/works/{worksId}")
	public WsResult getAudioByWorksId(@PathVariable("worksId")int worksId){
		return service.selectAudioByWorksId(worksId);
	}
	
	
	
}
