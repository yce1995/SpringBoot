package cn.et.lesson01.serivce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.et.lesson01.Emp;
import cn.et.lesson01.dao.EmpRepository;
import cn.et.lesson01.serivce.EmpService;
@Service
public class EmpSericeImpl implements EmpService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EmpRepository er;
	
	public Emp getEmp(Integer id){
		Emp emp = er.findOne(id);
		return emp;
	}

	public void saveEmp(String ename,double sal, Integer deptid){
		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setSal(sal);
		emp.setDeptid(deptid);
		er.save(emp);
	}
}
