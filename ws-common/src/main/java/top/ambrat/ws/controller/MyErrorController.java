package top.ambrat.ws.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.ambrat.ws.util.WsResult;

@ControllerAdvice
public class MyErrorController {

	@ExceptionHandler
	@ResponseBody
	public Object handlerException(Exception ex){
		WsResult result = new WsResult();
		result.setStatus(-1);
		result.setMsg("ϵͳ�쳣");
		return result;
	}
	
}
