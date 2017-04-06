package com.clsteach.dao;

import java.util.List;
import java.util.Map;

import com.clsteach.entity.teach;
import com.clsteach.entity.teachex;

public interface teachMapper {
    int deleteByPrimaryKey(Integer teachId);

    int insert(teach record);

    int insertSelective(teach record);

    teach selectByPrimaryKey(Integer teachId);

    int updateByPrimaryKeySelective(teach record);

    int updateByPrimaryKey(teach record);
    
    List<teach> selectByPage(Map<String, Object> map);
    
    List<teach> selectByName(String teachName);
    
    int selectCounts(Map<String, Object> map);
    
    List<teach> selectAll();
    
    teachex selectClsteachById(int teachId);
    
    List<teach> selectByClsId(int clsId);
    
    List<Map> selectByNewPage(Map<String, Object> map);
}