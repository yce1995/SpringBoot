package cn.et.lessonDemo.seriver;

import cn.et.lessonDemo.entity.Foods;
import cn.et.lessonDemo.utils.PageTools;

public interface FoodService {

	public abstract PageTools queryFood(String foodname,Integer page,Integer rows);
	
	public abstract void saveFood(Foods food);
	
	public abstract void updateFood(Foods food);
	
	public abstract void deleteFood(Integer foodid);
}