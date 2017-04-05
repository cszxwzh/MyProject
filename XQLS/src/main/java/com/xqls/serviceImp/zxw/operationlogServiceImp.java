package com.xqls.serviceImp.zxw;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dao.zxw.operationlogMapper;
import com.xqls.entity.zxw.operationlog;
import com.xqls.service.zxw.operationlogService;

@Service
public class operationlogServiceImp implements operationlogService{
	@Autowired
	private operationlogMapper operationlogMapper;
	
	@Override
	public List<operationlog> selByPage(Map<String, Object> map) {
		List<operationlog> oplist = operationlogMapper.selectByPage(map);
		return oplist;
	}

	@Override
	public int selcount(Map<String, Object> map) {
		return operationlogMapper.selectcount(map);
	}

	@Override
	public int addoperofuser(operationlog operationlog) {
		return operationlogMapper.insertOfuser(operationlog);
	}

	@Override
	public int addoperofequip(operationlog operationlog) {
		return operationlogMapper.insertOfequip(operationlog);
	}

	@Override
	public List<Map> selByExport(Map<String, Object> map) {
		return operationlogMapper.selectByExport(map);
	}
	
}
