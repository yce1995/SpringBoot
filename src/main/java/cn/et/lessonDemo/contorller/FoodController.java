package cn.et.lessonDemo.contorller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.lessonDemo.entity.Foods;
import cn.et.lessonDemo.entity.Result;
import cn.et.lessonDemo.seriver.FoodService;
import cn.et.lessonDemo.utils.PageTools;

@Controller
public class FoodController {
	@Autowired
	FoodService fs;
	@ResponseBody
	@RequestMapping("/queryFoods")
	public PageTools queryFood(String foodname,Integer page,Integer rows){
		return fs.queryFood(foodname,page,rows);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFood/{foodid}",method=RequestMethod.DELETE)
	public Result deleteFood(@PathVariable String foodid,Integer page,Integer rows){
		String[] s = foodid.split(",");
		Result r = new Result();
		try {
			r.setCode(1);
			for (int i = 0; i < s.length; i++) {
				fs.deleteFood(new Integer(s[i]));
			}
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/updateFood/{foodid}",method=RequestMethod.PUT)
	public Result updateFood(@PathVariable Integer foodid,Foods food,Integer page,Integer rows){
		food.setFoodid(foodid);
		Result r = new Result();
		try {
			r.setCode(1);
			fs.updateFood(food);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/saveFood",method=RequestMethod.POST)
	public Result insertFood(Foods food,MultipartFile myImage,Integer page,Integer rows){
		
		Result r = new Result();
		try {
			r.setCode(1);
			String img = myImage.getOriginalFilename();
			File file = new File("D:/aaa/"+img);
			myImage.transferTo(file);
			fs.saveFood(food);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
}
