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

@EnableDiscoveryClient //让注册中心能够发现，扫描到该服务
@SpringBootApplication //复合注解，包括@ComponentScan，和@SpringBootConfiguration，@EnableAutoConfiguration
/*
	@SpringBootConfiguration继承自@Configuration，二者功能也一致，标注当前类是配置类，
	并会将当前类内声明的一个或多个以@Bean注解标记的方法的实例纳入到srping容器中，并且实例名就是方法名。
	
	@EnableAutoConfiguration的作用启动自动的配置，@EnableAutoConfiguration注解的意思就是Springboot根据
	你添加的jar包来配置你项目的默认配置，比如根据spring-boot-starter-web ，
	来判断你的项目是否需要添加了webmvc和tomcat，就会自动的帮你配置web项目中所需要的默认配置。

	@ComponentScan，扫描当前包及其子包下被@Component，@Controller，@Service，@Repository注解标记的类并纳入到spring容器中进行管理。
	是以前的<context:component-scan>（以前使用在xml中使用的标签，用来扫描包配置的平行支持）。所以本demo中的User为何会被spring容器管理。
	
*/
@MapperScan(basePackages={"top.ambrat.ws.dao"})//mybatis mapper接口扫描包路径
@ServletComponentScan //用于扫描过滤过滤器，实现跨域
public class CollerctWorksRunBoot {

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CollerctWorksRunBoot.class, args);
	}

	/** 服务间调用 **/
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
  
    /** 文件上传组件 */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("10MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }

	
	
}
