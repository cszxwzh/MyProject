package com.xqls.serviceImp.zxw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.visitor.functions.Length;
import com.xqls.dao.zxw.UserMapper;
import com.xqls.entity.zxw.SelectPerms;
import com.xqls.entity.zxw.TreeResult;
import com.xqls.entity.zxw.User;
import com.xqls.entity.zxw.role;
import com.xqls.service.zxw.userService;
@Service
public class userServiceImp implements userService{
	@Autowired
	private UserMapper UserMapper;
	
	@Override
	public User selByName(String username) {
		return UserMapper.selectByName(username);
	}

	@Override
	public Set<String> selRoleByName(String username) {
		return UserMapper.selectRoleByName(username);
	}

	@Override
	public Set<String> selPermsByName(String username) {
		return UserMapper.selectPermsByName(username);
	}

	@Override
	public List<Map> selUserByPage(Map<String, Object> map) {
		return UserMapper.selectUserByPage(map);
	}

	@Override
	public int selUserCount(Map<String, Object> map) {
		return UserMapper.selectUserCount(map);
	}

	@Override
	public int adduser(User user) {
		return UserMapper.insert(user);
	}

	@Override
	public List<Map> selRoles() {
		return UserMapper.selectRoles();
	}

	@Override
	public Map selUserById(int userid) {
		return UserMapper.selectUserById(userid);
	}

	@Override
	public List<Map> selRoleByPage(Map<String, Object> map) {
		return UserMapper.selectRoleByPage(map);
	}

	@Override
	public int selRoleCount(Map<String, Object> map) {
		return UserMapper.selectRoleCount(map);
	}

	@Override
	public int updUser(User user) {
		return UserMapper.updateByPrimaryKey(user);
	}

	@Override
	public int delUser(int userid) {
		return UserMapper.deleteByPrimaryKey(userid);
	}
	/**
	 * 搜索权限表，用于权限表的树形显示
	 */
	@Override
	public List<TreeResult> selAllPerms(int roleid) {
		List<Map> permslist = UserMapper.selectAllPerms();
		List<Map> rolepermslist = new ArrayList<Map>();
		if(roleid!=0){
		rolepermslist = UserMapper.selectPermsByRoleid(roleid);
		}
 		List<TreeResult> treeResults = new ArrayList<TreeResult>();
		for (int i = 0; i < permslist.size(); i++) {
			TreeResult treeResult = new TreeResult();
			Map permsMap = permslist.get(i);
			String permsnum = permsMap.get("PERMSNUM").toString();
			int length = permsnum.length();
			if(length>4){
				treeResult.setEid(permsMap.get("PERMSID").toString());
				treeResult.setId(permsnum);
				treeResult.setpId(permsMap.get("PERMSNUM").toString().substring(0, length-4));
				treeResult.setName(permsMap.get("PERMSNAME").toString());
			}else {
				treeResult.setId(permsnum);
				treeResult.setpId("0");
				treeResult.setEid(permsMap.get("PERMSID").toString());
				treeResult.setName(permsMap.get("PERMSNAME").toString());
				treeResult.setIsParent(true);
			}
			for (int j = 0; j < rolepermslist.size(); j++) {
				if(rolepermslist.get(j).get("PERMSNUM").toString().equals(permsnum)){
					treeResult.setChecked(true);
					break;
				}
			}
			treeResults.add(treeResult);
		}
		return treeResults;
	}

	@Override
	public int delPermsByRole(int rid) {
		return UserMapper.deletePermsByRole(rid);
	}

	@Override
	public int addRoleAndPerms(SelectPerms selectPerms) {
		return UserMapper.insertRoleAndPerms(selectPerms);
	}

	@Override
	public int addRoleAndPerms(role role, List<SelectPerms> selectPermslist) {
		int res = 0;
		int res1 = UserMapper.insertRole(role);
		int res2 = 0;
		System.out.println("*********roleid**********"+role.getRoleid());
		for (SelectPerms selectPerms : selectPermslist) {
			selectPerms.setRid(role.getRoleid().toString());
			res2 = UserMapper.insertRoleAndPerms(selectPerms);
			if (res2<0) {
				break;
			}
		}
		if(res1>0&&res2>0){
			res = 1;
		}else {
			res= -1;
		}
		return res;
	}

	
}
