package cn.et.lesson01.contorller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson01.Emp;
import cn.et.lesson01.serivce.EmpService;


@RestController
public class SbContorller {
	/**
	 * 只需要配置application.properties的四要素 即可使用该类
	 * spring.datasource.url=jdbc:mysql://localhost:3307/lessonDemo
	 * spring.datasource.username=root
	 * spring.datasource.password=123456
	 * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	 * */
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	EmpService es;
	
	@RequestMapping("/hello")
	public Map hello(){
		Map map = new HashMap();
		map.put("id", 1);
		map.put("name", "zs");
		return map;
	}
	
	@RequestMapping("/emp/{empid}")
	public Emp getEmp(@PathVariable Integer empid){
		return es.getEmp(empid);
	}
	
	@RequestMapping("/save")
	public void saveEmp(){
		es.saveEmp("你玩吧",12.66,4);
	}
}
