/**
 * 
 */
package com.cbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbw.model.mapper.TTScoreMapper;
import com.cbw.model.pojo.TTScore;
import com.cbw.service.ScoreService;

/**
 * @Title: ScoreServiceImpl.java
 * @Package com.cbw.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author cbw
 * @date 2017年12月27日 下午3:28:19
 * @version V1.0
 */
@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private TTScoreMapper ttScoreMapper;

	@Override
	public int deleteByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return ttScoreMapper.deleteByPrimaryKey(cid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cbw.service.scoreService#insert(com.cbw.model.pojo.TTScore)
	 */
	@Override
	public int insert(TTScore record) {
		// TODO Auto-generated method stub
		return ttScoreMapper.insert(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cbw.service.scoreService#insertSelective(com.cbw.model.pojo.TTScore)
	 */
	@Override
	public int insertSelective(TTScore record) {
		// TODO Auto-generated method stub
		return ttScoreMapper.insertSelective(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cbw.service.scoreService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public TTScore selectByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return ttScoreMapper.selectByPrimaryKey(cid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cbw.service.scoreService#updateByPrimaryKeySelective(com.cbw.model.pojo.
	 * TTScore)
	 */
	@Override
	public int updateByPrimaryKeySelective(TTScore record) {
		// TODO Auto-generated method stub
		return ttScoreMapper.updateByPrimaryKey(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cbw.service.scoreService#updateByPrimaryKey(com.cbw.model.pojo.TTScore)
	 */
	@Override
	public int updateByPrimaryKey(TTScore record) {
		// TODO Auto-generated method stub
		return ttScoreMapper.updateByPrimaryKey(record);
	}

}
