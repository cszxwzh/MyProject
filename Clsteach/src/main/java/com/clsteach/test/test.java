package com.clsteach.test;

import java.util.HashMap;
import java.util.List;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.clsteach.dao.clsMapper;
import com.clsteach.dao.stageMapper;
import com.clsteach.entity.clsex;
import com.clsteach.entity.ctrelation;
import com.clsteach.entity.cls;
import com.clsteach.entity.stage;
import com.clsteach.entity.stageex;
import com.clsteach.entity.teach;
import com.clsteach.entity.teachex;
import com.clsteach.service.ClsService;
import com.clsteach.serviceImp.ClsServiceImp;
import com.clsteach.utils.DBSessionFactory;


public class test {
public static void main(String[] args) {
	SqlSession session = DBSessionFactory.getSessionFactory().openSession();
	stageMapper mapper = session.getMapper(stageMapper.class);
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("start", 0);
	map.put("index", 10);
	map.put("clsName", null);
	
	List<stageex> sList = mapper.selectByclsteach(3);
	System.out.println(sList.size());
	
}
}
