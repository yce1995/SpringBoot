package cn.et.lesson01.dao;

import org.springframework.data.repository.CrudRepository;

import cn.et.lesson01.Emp;


public interface EmpRepository extends CrudRepository<Emp,Integer> {
}
