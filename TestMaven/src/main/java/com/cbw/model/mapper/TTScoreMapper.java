package com.cbw.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cbw.model.pojo.TTScore;

@Mapper
public interface TTScoreMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TTScore record);

    int insertSelective(TTScore record);

    TTScore selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(TTScore record);

    int updateByPrimaryKey(TTScore record);
    
    
    int insertBatch(List<TTScore> list);
}