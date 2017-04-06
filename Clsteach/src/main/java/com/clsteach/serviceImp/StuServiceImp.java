package com.clsteach.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clsteach.dao.stuMapper;
import com.clsteach.entity.stu;
import com.clsteach.entity.stuex;
import com.clsteach.service.StuService;
@Service
public class StuServiceImp implements StuService{
	
	@Autowired
	private stuMapper stuMapper;
	
	@Override
	public int delStu(Integer stuId) {
		return stuMapper.deleteByPrimaryKey(stuId);
	}

	@Override
	public int addStu(stu stu) {
		stu checkstu = selById(stu.getStuId());
		int res = 0;
		if(checkstu==null){
			res = stuMapper.insert(stu);
			}
		else {
			res=-1;
		}
		return res;
	}

	@Override
	public stu selById(Integer stuId) {
		return stuMapper.selectByPrimaryKey(stuId);
	}

	@Override
	public int update(stu stu) {
		return stuMapper.updateByPrimaryKey(stu);
	}

	@Override
	public List<stuex> selByPage(int start, int length, stuex stuex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("index", start+length);
		map.put("stuName", stuex.getStuName());
		System.out.println("学生姓名是："+stuex.getStuName());
		map.put("clsName", stuex.getCls().getClsName());
		List<stuex> slistList = stuMapper.selectByPage(map);
		return slistList;
	}

	@Override
	public int selCounts(stuex stuex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuName", stuex.getStuName());
		map.put("clsName", stuex.getCls().getClsName());
		int res = stuMapper.selectCounts(map);
		return res;
	}

	@Override
	public List<stu> selByCls(int clsId) {
		return stuMapper.selectBycls(clsId);
	}

}
