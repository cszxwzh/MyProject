package com.xqls.dao.zxw;

import java.util.List;

import com.xqls.entity.zxw.block;

public interface blockMapper {
    int deleteByPrimaryKey(Integer blockId);

    int insert(block record);

    int insertSelective(block record);

    block selectByPrimaryKey(Integer blockId);

    int updateByPrimaryKeySelective(block record);

    int updateByPrimaryKey(block record);
    
    List<block> selectAll();
    
    int deleteByNum(String blockNum);
    
    int updateByNum(block block);
    
    block selectByNum(String blockNum);
    
    block selectByNumAndName(block block);
    
    int seletSameNum(String blockNum);
}