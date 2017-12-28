package cn.et.lessonDemo.seriver.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lessonDemo.entity.Dept;
import cn.et.lessonDemo.entity.DeptExample;
import cn.et.lessonDemo.entity.Emp;
import cn.et.lessonDemo.entity.EmpExample;
import cn.et.lessonDemo.entity.TreeNode;
import cn.et.lessonDemo.entity.EmpExample.Criteria;
import cn.et.lessonDemo.mapper.DeptMapper;
import cn.et.lessonDemo.mapper.EmpMapper;
import cn.et.lessonDemo.seriver.DeptService;



@Service
public class deptServiceImpl implements DeptService{
	@Autowired
	DeptMapper dm;
	@Autowired
	EmpMapper em;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.FoodService#queryFood(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.deptService#queryTreeNode(java.lang.Integer)
	 */
	public List<TreeNode> queryTreeNode(Integer pid){
		DeptExample fe = new DeptExample();
		fe.createCriteria().andPidEqualTo(pid);
		List<Dept> dept = dm.selectByExample(fe);
		List<TreeNode> deptList=new ArrayList<TreeNode>();
		for (Dept d:dept) {
			TreeNode tn =new TreeNode();
			tn.setId(d.getId());
			tn.setText(d.getDname());
			//判断节点下是否还存在子节点
			if(queryTreeNode(d.getId()).size()==0){
				tn.setState("open");
			}
			deptList.add(tn);
		}
		return deptList;
	}
	
	public List<Emp> queryEmp(Integer id,String name){
		EmpExample ee = new EmpExample();
		Criteria c = ee.createCriteria();
		if(id!=null){
			c.andDeptidEqualTo(id);
		}
		if(name==null){
			name="";
		}
		c.andEnameLike("%"+name+"%");
		return em.selectByExample(ee);
	}
	
	public void saveFood(Emp emp){
		em.insert(emp);
	}
	
	public void updateEmp(Emp emp){
		em.updateByPrimaryKey(emp);
	}
	
	public void deleteEmp(Integer id){
		em.deleteByPrimaryKey(id);
	}
}
