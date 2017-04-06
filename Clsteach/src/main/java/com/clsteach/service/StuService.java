package com.clsteach.service;

import java.util.List;

import com.clsteach.entity.stu;
import com.clsteach.entity.stuex;

public interface StuService {
 public int delStu(Integer stuId);
 public int addStu(stu stu);
 public stu selById(Integer stuId);
 public int update(stu stu);
 public List<stuex> selByPage(int start,int length,stuex stuex);
 public int selCounts(stuex stuex);
 public List<stu> selByCls(int clsId);
}
