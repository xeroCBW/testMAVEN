/**
 * 
 */
package com.cbw.service;

import com.cbw.model.pojo.TTScore;

/**   
* @Title: scoreService.java 
* @Package com.cbw.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author cbw   
* @date 2017年12月27日 下午3:27:49 
* @version V1.0   
*/
public interface ScoreService {

	
	  int deleteByPrimaryKey(Integer cid);

	    int insert(TTScore record);

	    int insertSelective(TTScore record);

	    TTScore selectByPrimaryKey(Integer cid);

	    int updateByPrimaryKeySelective(TTScore record);

	    int updateByPrimaryKey(TTScore record);
	
	
	
	
}
