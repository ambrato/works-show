package top.ambrat.ws.cotroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import top.ambrat.ws.entity.Type;
import top.ambrat.ws.service.TypeService;
import top.ambrat.ws.util.WsResult;

/** �����˿�  7012 **/
@RestController
public class TypeController {

	@Autowired
	private TypeService service;
	
	/** ������ӷ������� **/
	@PostMapping("/type/add")
	public WsResult addType(Type type){
		return service.insertType(type);
	}
	
	/** �����޸ķ������� **/
	@PutMapping("/type/update")
	public WsResult updateType(Type type){
		return service.updateType(type);
	}
	
	/** �����ȡ���з������� **/
	@GetMapping("/type/AllType")
	public WsResult getAllType(){
		return service.getType();
	}
	
}
