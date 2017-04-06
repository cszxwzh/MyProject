package com.clsteach.dao;

import java.util.List;
import java.util.Map;

import com.clsteach.entity.stu;
import com.clsteach.entity.stuex;

public interface stuMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(stu record);

    int insertSelective(stu record);

    stu selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(stu record);

    int updateByPrimaryKey(stu record);
    
    List<stuex> selectByPage(Map<String, Object> map);
    
    int selectCounts(Map<String, Object> map);
    
    List<stu> selectBycls (int clsId);
}