package com.clsteach.service;

import java.util.List;

import com.clsteach.entity.cls;
import com.clsteach.entity.clsex;
import com.clsteach.entity.clsex2;

public interface ClsService {
	 public int delcls(Integer clsId);
	 public int addcls(cls cls);
	 public cls selById(Integer clsId);
	 public int update(cls cls);
	 public List<cls> selAll();
	 public List<clsex> selByPage(int start,int length,clsex clsex);
	 public int selRecords(cls cls);
	 public cls selByName(cls cls);
	 public List<clsex2> selByPage2(int start,int length,cls cls);
	 public int selRecords2(cls cls);
}
