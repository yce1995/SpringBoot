package cn.et.lesson02.contorller;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson02.entity.Emp;
import cn.et.lesson02.mapper.EmpMapper;

@RestController
public class SbContorller {
	@Autowired
	DataSource ds;
	
	@Autowired
	EmpMapper em;
	
	@RequestMapping("/sysoSource")
	public String saveEmp(){
		return ds.toString();
	}
	
	@RequestMapping("/queryAll")
	public List<Emp> queryAll(){
		return em.queryEmp();
	}
}
