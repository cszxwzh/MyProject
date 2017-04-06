package com.clsteach.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clsteach.dao.teachMapper;
import com.clsteach.entity.teach;
import com.clsteach.entity.teachex;
import com.clsteach.service.TeachService;
@Service
public class TeachServiceImp implements TeachService {
	
	@Autowired
	private teachMapper teachMapper;
	
	@Override
	public int delteach(Integer teachId) {
		return teachMapper.deleteByPrimaryKey(teachId);
	}

	@Override
	public int addteach(teach teach) {
		return teachMapper.insert(teach);
	}

	@Override
	public teach selById(Integer teachId) {
		return teachMapper.selectByPrimaryKey(teachId);
	}

	@Override
	public int update(teach teach) {
		return teachMapper.updateByPrimaryKey(teach);
	}

	@Override
	public List<teach> selByPage(int start, int length, teach teach) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("index", start+length);
		map.put("teachName", teach.getTeachName());
		map.put("teachIntro", teach.getTeachIntro());
		List<teach> tlist = teachMapper.selectByPage(map);
		return tlist;
	}

	@Override
	public List<teach> selByName(String teachName) {
		List<teach> tlist = null;
		if(teachName!=null)
		tlist = teachMapper.selectByName(teachName);
		return tlist;
	}

	@Override
	public int selCounts(teach teach) {
		int res = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teachName", teach.getTeachName());
		map.put("teachIntro", teach.getTeachIntro());
		res = teachMapper.selectCounts(map);
		return res;
	}

	@Override
	public List<teach> selAll() {
		return teachMapper.selectAll();
	}

	@Override
	public teachex selClsTeach(int teachId) {
		return teachMapper.selectClsteachById(teachId);
	}

	@Override
	public List<Map> selByNewPage(int start, int length, teach teach) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("index", start+length);
		map.put("teachName", teach.getTeachName());
		map.put("teachIntro", teach.getTeachIntro());
		List<Map> teachclslist = teachMapper.selectByNewPage(map);
		return teachclslist;
	}

}
