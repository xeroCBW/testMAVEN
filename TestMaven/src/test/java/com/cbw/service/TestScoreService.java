/**
 * 
 */
package com.cbw.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cbw.TestMavenApplication;
import com.cbw.model.pojo.TTScore;

/**
 * @Title: TestScoreService.java
 * @Package com.cbw.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author cbw
 * @date 2017年12月27日 下午3:36:33
 * @version V1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestMavenApplication.class)
public class TestScoreService {

	@Autowired
	private ScoreService scoreService;

	/**
	 * 测试查询数据
	 * 
	 * @throws Exception
	 */
	@Test
	public void testService() throws Exception {

		System.out.println("scoreService----的结果.....");
		System.out.println(scoreService);

		TTScore ttscore = scoreService.selectByPrimaryKey(1);

		System.out.println(ttscore);

	}

	/**
	 * 测试批量插入数据
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBatch() throws Exception {
		
		
		

	}

}
