package com.clsteach.dao;

import java.util.List;

import com.clsteach.entity.stage;
import com.clsteach.entity.stageex;

public interface stageMapper {
    int deleteByPrimaryKey(Integer staId);

    int insert(stage record);

    int insertSelective(stage record);

    stage selectByPrimaryKey(Integer staId);

    int updateByPrimaryKeySelective(stage record);

    int updateByPrimaryKey(stage record);
    
    List<stage> selectAll();
    
    List<stageex> selectByclsteach(int clsId);
}