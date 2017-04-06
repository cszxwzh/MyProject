package com.clsteach.dao;

import java.util.List;
import java.util.Map;

import com.clsteach.entity.loginuser;

public interface loginuserMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(loginuser record);

    int insertSelective(loginuser record);

    loginuser selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(loginuser record);

    int updateByPrimaryKey(loginuser record);
    
    loginuser logincheck(loginuser record);
    
    loginuser signincheck(String logName);
 
    loginuser selectBylogName(String logName);
    
    List<loginuser> selectByPage(Map<String, Object> map);
    
    int selectCounts(String logName);
}