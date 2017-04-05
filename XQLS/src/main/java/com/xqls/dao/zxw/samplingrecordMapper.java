package com.xqls.dao.zxw;

import com.xqls.entity.zxw.samplingrecord;

public interface samplingrecordMapper {
    int deleteByPrimaryKey(Integer samplId);

    int insert(samplingrecord record);

    int insertSelective(samplingrecord record);

    samplingrecord selectByPrimaryKey(Integer samplId);

    int updateByPrimaryKeySelective(samplingrecord record);

    int updateByPrimaryKey(samplingrecord record);
}