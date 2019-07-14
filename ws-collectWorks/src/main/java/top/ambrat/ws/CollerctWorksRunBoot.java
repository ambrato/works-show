package top.ambrat.ws;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient //��ע�������ܹ����֣�ɨ�赽�÷���
@SpringBootApplication //����ע�⣬����@ComponentScan����@SpringBootConfiguration��@EnableAutoConfiguration
/*
	@SpringBootConfiguration�̳���@Configuration�����߹���Ҳһ�£���ע��ǰ���������࣬
	���Ὣ��ǰ����������һ��������@Beanע���ǵķ�����ʵ�����뵽srping�����У�����ʵ�������Ƿ�������
	
	@EnableAutoConfiguration�����������Զ������ã�@EnableAutoConfigurationע�����˼����Springboot����
	����ӵ�jar������������Ŀ��Ĭ�����ã��������spring-boot-starter-web ��
	���ж������Ŀ�Ƿ���Ҫ�����webmvc��tomcat���ͻ��Զ��İ�������web��Ŀ������Ҫ��Ĭ�����á�

	@ComponentScan��ɨ�赱ǰ�������Ӱ��±�@Component��@Controller��@Service��@Repositoryע���ǵ��ಢ���뵽spring�����н��й���
	����ǰ��<context:component-scan>����ǰʹ����xml��ʹ�õı�ǩ������ɨ������õ�ƽ��֧�֣������Ա�demo�е�UserΪ�λᱻspring��������
	
*/
@MapperScan(basePackages={"top.ambrat.ws.dao"})//mybatis mapper�ӿ�ɨ���·��
@ServletComponentScan //����ɨ����˹�������ʵ�ֿ���
public class CollerctWorksRunBoot {

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CollerctWorksRunBoot.class, args);
	}

	/** �������� **/
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
  
    /** �ļ��ϴ���� */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //�ļ����KB,MB
        factory.setMaxFileSize("10MB");
        //�������ϴ������ܴ�С
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }

	
	
}
