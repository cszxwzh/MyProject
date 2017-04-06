package com.clsteach.dao;

import com.clsteach.entity.ctrelation;
import com.clsteach.entity.ctrelationex;

public interface ctrelationMapper {
    int deleteByPrimaryKey(Integer relaId);

    int insert(ctrelation record);

    int insertSelective(ctrelation record);

    ctrelation selectByPrimaryKey(Integer relaId);

    int updateByPrimaryKeySelective(ctrelation record);

    int updateByPrimaryKey(ctrelation record);
    
    ctrelationex selectByclsAndsta(ctrelation record);
}