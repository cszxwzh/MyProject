package com.xqls.service.zxw;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xqls.entity.zxw.equipment;

public interface equipmentService {
 public static final List<String> equiptype = Arrays.asList("取水口","出水口"); 
 public List<equipment> selAll();
 public List<Map> selByPage(Map<String, Object> map);
 public int selByCount(Map<String, Object> map);
 public Map selById(int equipId);
 public int addequip(equipment equipment);
 public int updequip(equipment equipment);
 public int delequip(int equipId);
 public List<equipment> selByBlock(String blockNum);
}

