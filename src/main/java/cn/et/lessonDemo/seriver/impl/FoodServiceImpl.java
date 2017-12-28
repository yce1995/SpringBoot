package cn.et.lessonDemo.seriver.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lessonDemo.entity.Foods;
import cn.et.lessonDemo.entity.FoodsExample;
import cn.et.lessonDemo.mapper.FoodsMapper;
import cn.et.lessonDemo.seriver.FoodService;
import cn.et.lessonDemo.utils.PageTools;
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodsMapper fm;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.FoodService#queryFood(java.lang.String)
	 */
	public PageTools queryFood(String foodname,Integer page,Integer rows){
		if(foodname==null){
			foodname="";
		}
		//发起SQL 语句查询总记录
		FoodsExample fe = new FoodsExample();
		fe.createCriteria().andFoodnameLike("%"+foodname+"%");
		int total = queryFoodCount(fe);
		//limit 开始位置 ，总记录数
		PageTools pt = new PageTools(page,total,rows);
		RowBounds rb = new RowBounds(pt.getStartIndex()-1,rows);
		List<Foods> foodList = fm.selectByExampleWithRowbounds(fe, rb);
		pt.setRows(foodList);
		return pt;
	}
	
	public int queryFoodCount(FoodsExample fe){
		int total = (int)fm.countByExample(fe);
		return total;
	}
	
	public void saveFood(Foods food){
		fm.insert(food);
	}
	
	public void updateFood(Foods food){
		fm.updateByPrimaryKey(food);
	}

	public void deleteFood(Integer foodid) {
		fm.deleteByPrimaryKey(foodid);
	}
}
