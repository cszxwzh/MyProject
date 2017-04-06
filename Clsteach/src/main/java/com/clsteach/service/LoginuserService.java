package com.clsteach.service;

import java.util.List;

import com.clsteach.entity.loginuser;

public interface LoginuserService {
	public int delloginuser(Integer loginuserId);
	 public int addloginuser(loginuser loginuser);
	 public loginuser selById(Integer loginuserId);
	 public int update(loginuser loginuser);
	 public loginuser checkloginuser(loginuser loginuser);
	 public loginuser checksignuser(String logName);
	 public loginuser selBylogName(String logName);
	 public List<loginuser> selByPage(int start,int length,String logName);
	 public int selCounts(String logName);
}
