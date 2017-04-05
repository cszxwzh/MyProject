package com.xqls.service.zxw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xqls.entity.zxw.SelectPerms;
import com.xqls.entity.zxw.TreeResult;
import com.xqls.entity.zxw.User;
import com.xqls.entity.zxw.role;

public interface userService {
	public static final Map<Integer, String> warn = new HashMap<Integer, String>(){{
		put(1, "1级-局领导");
		put(2, "2级-区域管理员");
		put(3, "3级-值班人员");
	}};
	public User selByName(String username);
	public Set<String> selRoleByName(String username);
	public Set<String> selPermsByName(String username);
	public List<Map> selUserByPage(Map<String, Object> map);
	public int selUserCount(Map<String, Object> map);
	public int adduser(User user);
	public List<Map> selRoles();
	public Map selUserById(int userid);
	public List<Map> selRoleByPage(Map<String, Object> map);
	public int selRoleCount(Map<String, Object> map);
	public int updUser(User user);
	public int delUser(int userid);
	public List<TreeResult> selAllPerms(int roleid);
	public int delPermsByRole(int rid);
	public int addRoleAndPerms(SelectPerms selectPerms);
	public int addRoleAndPerms(role role,List<SelectPerms> selectPermslist);
}
