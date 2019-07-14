package top.ambrat.ws.cotroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import top.ambrat.ws.entity.Type;
import top.ambrat.ws.service.TypeService;
import top.ambrat.ws.util.WsResult;

/** 监听端口  7012 **/
@RestController
public class TypeController {

	@Autowired
	private TypeService service;
	
	/** 处理添加分类请求 **/
	@PostMapping("/type/add")
	public WsResult addType(Type type){
		return service.insertType(type);
	}
	
	/** 处理修改分类请求 **/
	@PutMapping("/type/update")
	public WsResult updateType(Type type){
		return service.updateType(type);
	}
	
	/** 处理获取所有分类请求 **/
	@GetMapping("/type/AllType")
	public WsResult getAllType(){
		return service.getType();
	}
	
}
