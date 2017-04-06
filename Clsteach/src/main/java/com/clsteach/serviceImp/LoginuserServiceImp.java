package com.clsteach.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clsteach.dao.loginuserMapper;
import com.clsteach.entity.loginuser;
import com.clsteach.service.LoginuserService;
@Service
public class LoginuserServiceImp implements LoginuserService {
	
	@Autowired
	private loginuserMapper loginuserMapper;
	
	@Override
	public int delloginuser(Integer loginuserId) {
		return loginuserMapper.deleteByPrimaryKey(loginuserId);
	}

	@Override
	public int addloginuser(loginuser loginuser) {
		int res = 0;
		loginuser loginuser2 = checksignuser(loginuser.getLogName());
		if(loginuser2!=null){
			res=-1;
		}else {
			res = loginuserMapper.insertSelective(loginuser);
		}
		return res;
	}

	@Override
	public loginuser selById(Integer loginuserId) {
		return loginuserMapper.selectByPrimaryKey(loginuserId);
	}

	@Override
	public int update(loginuser loginuser) {
		return loginuserMapper.updateByPrimaryKey(loginuser);
	}

	@Override
	public loginuser checkloginuser(loginuser loginuser) {
		return loginuserMapper.logincheck(loginuser);
	}

	@Override
	public loginuser checksignuser(String logName) {
		return loginuserMapper.signincheck(logName);
	}

	@Override
	public loginuser selBylogName(String logName) {
		return loginuserMapper.selectBylogName(logName);
	}

	@Override
	public List<loginuser> selByPage(int start, int length, String logName) {
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("start", start);
		map.put("index", start+length);
		map.put("logName", logName);
		List<loginuser> llist = loginuserMapper.selectByPage(map);
		return llist;
	}

	@Override
	public int selCounts(String logName) {
		return loginuserMapper.selectCounts(logName);
	}

}
