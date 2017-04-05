package com.xqls.service.zxw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xqls.entity.zxw.operationlog;

public interface operationlogService {
 public static final Map<String, String> opertype = new HashMap<String, String>(){
	 {
		 put("net","网络");
		 put("power", "电源");
		 put("operate", "操作");
		 put("gate", "仪表门");
		 put("liquidlevel", "液位");
		 put("sampling", "采样仪");
	 }
	 }; 
 public List<operationlog> selByPage(Map<String, Object> map);
 public int selcount(Map<String, Object> map);
 public int addoperofuser(operationlog operationlog);
 public int addoperofequip(operationlog operationlog);
 public List<Map> selByExport(Map<String, Object> map);
}
