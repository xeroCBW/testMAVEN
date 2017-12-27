/**
 * 
 */
package com.cbw.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
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
	
	@Autowired  
	private SqlSessionTemplate sqlSessionTemplate;  

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
	 * 使用foreach,5s(最快)
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
	
	/**
	 * 使用mabatis自带的batch进行插入,耗时(10)中等
	 * @throws SQLException 
	 */
	@Test
	public void testInsertBatchByTrue() throws SQLException {  
		   
		//新获取一个模式为BATCH，自动提交为false的session  
		//如果自动提交设置为true,将无法控制提交的条数，改为最后统一提交，可能导致内存溢出  
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);  
		//通过新的session获取mapper  
		    session.getConnection().setAutoCommit(false);//不自动提交  
//		    fooMapper = session.getMapper(TTScoreMapper.class);  
		    int size = 10000;  
		    try {  
		        for (int i = 0; i < size; i++) {  
		                TTScore score = new TTScore();  
		                score.setCid(10000 + i);
		                score.setName(String.valueOf(System.currentTimeMillis())); 
		                
		                scoreService.insert(score);
		                    if (i % 1000 == 0 || i == size - 1) {  
		                    //手动每1000个一提交，提交后无法回滚  
		                    session.commit();  
		                    //清理缓存，防止溢出  
		                    session.clearCache();  
		                  }  
		        }  
		    } catch (Exception e) {  
		        //没有提交的数据可以回滚  
		                        session.rollback();  
		            } finally {  
		        session.close();  
		        }  
		    }  

}
