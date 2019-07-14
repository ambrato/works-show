package top.ambrat.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ambrat.ws.dao.TypeMapper;
import top.ambrat.ws.entity.Type;
import top.ambrat.ws.util.WsConstant;
import top.ambrat.ws.util.WsResult;

@Service
public class TypeServiceImp implements TypeService {

	@Autowired
	private TypeMapper mapper;
	
	public WsResult insertType(Type type) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Type byName = mapper.selectByName(type.getName());
		if (byName != null) {
			result.setMsg("类型已存在，添加类型失败");
			result.setStatus(WsConstant.SUCCESS);
			return result;
		}
		mapper.insertSelective(type);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}

	public WsResult updateType(Type type) {
		// TODO Auto-generated method stub
		WsResult result = new WsResult();
		Type type2 = mapper.selectByPrimaryKey(type.getId());
		if (type2 == null) {
			result.setMsg("类型不已存在，修改失败");
			result.setStatus(WsConstant.SUCCESS);
			return result;
		}
		mapper.updateByPrimaryKeySelective(type);
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		return result;
	}
	
	public  WsResult getType(){
		WsResult result = new WsResult();
		List<Type> allType = mapper.selectAllType();
		result.setMsg(WsConstant.SUCCESS_MSG);
		result.setStatus(WsConstant.SUCCESS);
		result.setData(allType);
		return result;
	}

}
