package top.ambrat.ws.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import top.ambrat.ws.entity.Ticket;

public class CheckStatus {

	
	@Autowired
	private RedisTemplate<Object, Object> redis;
	
	public boolean checkTicket(int userId, String ticket) {
		
		//��redis��ȡticket
		Ticket tk = (Ticket)redis.opsForHash().get("tickets", "ticket_"+userId);
		if(tk == null){
			return false;
		}
		//����û��ύ��ticket��redis�洢���Ƿ�һ��
		if(!tk.toString().equals(ticket)){
			return false;
		}
		//���ticket����Ч��
		long time = tk.getCreateTime()+tk.getExpireTime();
		if(time < System.currentTimeMillis()){
			return false;
		}
		//��Ч���
		return true;
	}
}
