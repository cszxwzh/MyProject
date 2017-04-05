package com.xqls.dao.zxw;

import java.util.List;
import java.util.Map;

import com.xqls.entity.zxw.operationlog;

public interface operationlogMapper {
    int deleteByPrimaryKey(Integer operId);

    int insert(operationlog record);

    int insertSelective(operationlog record);

    operationlog selectByPrimaryKey(Integer operId);

    int updateByPrimaryKeySelective(operationlog record);

    int updateByPrimaryKey(operationlog record);
    
    List<operationlog> selectByPage(Map<String, Object> map);
    
    int selectcount(Map<String, Object> map);
    
    int insertOfuser(operationlog record);
    
    int insertOfequip(operationlog record);
    
    List<Map> selectByExport(Map<String, Object> map);
}