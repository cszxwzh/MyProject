package com.xqls.dao.zxw;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xqls.entity.zxw.SelectPerms;
import com.xqls.entity.zxw.User;
import com.xqls.entity.zxw.role;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByName(String username);
    
    Set<String> selectRoleByName(String username);
    
    Set<String> selectPermsByName(String username); 
    
    List<Map> selectUserByPage(Map<String, Object> map);
    
    int selectUserCount(Map<String, Object> map);
    
    List<Map> selectRoles();
    
    Map selectUserById(int userid);
    
    List<Map> selectRoleByPage(Map<String, Object> map);
    
    int selectRoleCount(Map<String, Object> map);
    
    List<Map> selectAllPerms();
    
    List<Map> selectPermsByRoleid(int roleid);
    
    int deletePermsByRole(int rid);
    
    int insertRoleAndPerms(SelectPerms selectPerms);
    
    int insertRole(role role);
}