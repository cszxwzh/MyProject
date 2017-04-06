package com.clsteach.dao;

import java.util.List;
import java.util.Map;

import com.clsteach.entity.cls;
import com.clsteach.entity.clsex;

public interface clsMapper {
    int deleteByPrimaryKey(Integer clsId);

    int insert(cls record);

    int insertSelective(cls record);

    cls selectByPrimaryKey(Integer clsId);

    int updateByPrimaryKeySelective(cls record);

    int updateByPrimaryKey(cls record);
    
    List<cls> selectAll();
    
    List<clsex> selectByPage(Map<String, Object> map);
    
    int selectCounts(cls record);
    
    List<cls> selectByPage2(Map<String, Object> map);
    
    int selectCounts2(cls record);
    
    cls selectByclsName(cls record);
}