package com.clsteach.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clsteach.dao.clsMapper;
import com.clsteach.dao.stageMapper;
import com.clsteach.dao.stuMapper;
import com.clsteach.dao.teachMapper;
import com.clsteach.entity.cls;
import com.clsteach.entity.clsex;
import com.clsteach.entity.clsex2;
import com.clsteach.entity.stu;
import com.clsteach.entity.teach;
import com.clsteach.service.ClsService;
@Service
public class ClsServiceImp implements ClsService{
	@Autowired
	private clsMapper clsMapper;
	@Autowired
	private stuMapper stuMapper;
	@Autowired
	private stageMapper stageMapper;
	@Autowired
	private teachMapper teachMapper;
	
	@Override
	public int delcls(Integer clsId) {
		int res= 0;
		List<stu> sList = stuMapper.selectBycls(clsId);
		if(sList==null){
			res = clsMapper.deleteByPrimaryKey(clsId);			
		}else {
			res = -1;
		}
		return res;
	}

	@Override
	public int addcls(cls cls) {
		cls clsn = selByName(cls);
		int res = 0;
		if(clsn!=null){
			res=-1;
		}else if (clsn==null) {
			res = clsMapper.insert(cls);
		}
		return res;
	}

	@Override
	public cls selById(Integer clsId) {
		return clsMapper.selectByPrimaryKey(clsId);
	}

	@Override
	public int update(cls cls) {
		return clsMapper.updateByPrimaryKey(cls);
	}

	@Override
	public List<cls> selAll() {
		return clsMapper.selectAll();
	}

	@Override
	public List<clsex> selByPage(int start, int length, clsex clsex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("index", start+length);
		if(clsex.getClsName()!=null)
			map.put("clsName", clsex.getClsName());
		List<clsex> cList = clsMapper.selectByPage(map);
		return cList;
	}

	@Override
	public int selRecords(cls cls) {
		int res = clsMapper.selectCounts(cls);
		return res;
	}

	@Override
	public List<clsex2> selByPage2(int start, int length, cls cls) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("index", start+length);
		if(cls.getClsName()!=null)
			map.put("clsName", cls.getClsName());
		List<cls> cList = clsMapper.selectByPage2(map);
		List<clsex2> cexList = new ArrayList<clsex2>(); 
		for (cls clsn : cList) {
			clsex2 clsex1 = new clsex2();
			List<teach> teachlist = teachMapper.selectByClsId(clsn.getClsId());
			clsex1.setClsId(clsn.getClsId());
			clsex1.setClsName(clsn.getClsName());
			if(teachlist!=null)
			clsex1.setTeachlist(teachlist);
			cexList.add(clsex1);
		}
		return cexList;
	}

	@Override
	public int selRecords2(cls cls) {
		return clsMapper.selectCounts2(cls);
	}

	@Override
	public cls selByName(cls cls) {
		return clsMapper.selectByclsName(cls);
	}

}
