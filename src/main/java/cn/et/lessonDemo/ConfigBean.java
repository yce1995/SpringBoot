package cn.et.lessonDemo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class ConfigBean {
	/**
	 * <bean id='druidStatView' class='cn.*.ServletRegistrationBean'>
	 * */
	@Bean
	public ServletRegistrationBean druidStatView(){
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setName("DruidStatView");
		StatViewServlet sv = new StatViewServlet();
		srb.setServlet(sv);
		String url="/druid/*";
		List<String> map = new ArrayList<String>();
		map.add(url);
		srb.setUrlMappings(map);
		LinkedHashMap<String,String> linkdHashMap = new LinkedHashMap<String,String>();
		linkdHashMap.put("loginUsername", "admin");
		linkdHashMap.put("loginPassword", "123456");
		srb.setInitParameters(linkdHashMap);
		return srb;
	}
}
