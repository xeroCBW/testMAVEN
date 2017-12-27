/**
 * 
 */
package com.cbw.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.validator.constraints.ScriptAssert;
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
	 * 测试批量插入数据 耗时51s
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBatch() throws Exception {

		for (int i = 0; i < 10000; i++) {

			TTScore score = new TTScore();
			score.setCid(10000 + i);
			score.setName("name" + "-" + i);
			System.out.println("开始插入....");
			scoreService.insert(score);
			System.out.println("开始插入结束....");
		}
	}

	/**
	 * 测试批量插入2
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBatch2() throws Exception {

		ArrayList<TTScore> list = new ArrayList<TTScore>();

		for (int i = 0; i < 10000; i++) {
			TTScore score = new TTScore();
			score.setCid(20000 + i);
			score.setName("name" + "-" + i);
			list.add(score);
		}

		System.out.println("开始插入数据...");
		scoreService.insertBatch(list);
		System.out.println("插入数据结束...");
	}

}
