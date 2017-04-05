package com.xqls.dao.zxw;

import java.util.List;
import java.util.Map;

import com.xqls.entity.zxw.equipment;

public interface equipmentMapper {
    int deleteByPrimaryKey(Integer equipId);

    int insert(equipment record);

    int insertSelective(equipment record);

    equipment selectByPrimaryKey(Integer equipId);

    int updateByPrimaryKeySelective(equipment record);

    int updateByPrimaryKey(equipment record);
    
    List<equipment> selectAll();
    
    List<Map> selectPage(Map<String, Object> map);
    
    int selectCount(Map<String, Object> map);
    
    Map selectById(int equipId);
    
    List<equipment> selectByBlock(String blockNum);
}