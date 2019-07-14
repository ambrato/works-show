package top.ambrat.ws.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import top.ambrat.ws.entity.Ticket;

public class CheckStatus {

	
	@Autowired
	private RedisTemplate<Object, Object> redis;
	
	public boolean checkTicket(int userId, String ticket) {
		
		//从redis获取ticket
		Ticket tk = (Ticket)redis.opsForHash().get("tickets", "ticket_"+userId);
		if(tk == null){
			return false;
		}
		//检测用户提交的ticket和redis存储的是否一致
		if(!tk.toString().equals(ticket)){
			return false;
		}
		//检测ticket在有效期
		long time = tk.getCreateTime()+tk.getExpireTime();
		if(time < System.currentTimeMillis()){
			return false;
		}
		//有效结果
		return true;
	}
}
