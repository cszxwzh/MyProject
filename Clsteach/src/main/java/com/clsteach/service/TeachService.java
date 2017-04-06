package com.clsteach.service;

import java.util.List;
import java.util.Map;

import com.clsteach.entity.teach;
import com.clsteach.entity.teachex;

public interface TeachService {
	 public int delteach(Integer teachId);
	 public int addteach(teach teach);
	 public teach selById(Integer teachId);
	 public int update(teach teach);
	 public List<teach> selByPage(int start,int length,teach teach);
	 public List<teach> selByName(String teachName);
	 public int selCounts(teach teach);
	 public List<teach> selAll();
	 public teachex selClsTeach(int teachId);
	 public List<Map> selByNewPage(int start,int length,teach teach);
}
