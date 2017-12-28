package cn.et.lesson01.serivce;

import java.util.Map;

import cn.et.lesson01.Emp;

public interface EmpService {
	public Emp getEmp(Integer empid);
	
	public void saveEmp(String ename,double sal,Integer deptid);
}
