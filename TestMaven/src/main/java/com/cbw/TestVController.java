/**
 * 
 */
package com.cbw;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: TestVController.java
 * @Package com.cbw
 * @Description: TODO(用一句话描述该文件做什么)
 * @author cbw
 * @date 2017年12月18日 下午7:06:37
 * @version V1.0
 */

@RestController
@RequestMapping("/test")
public class TestVController {
	
	

	protected final Log logger = LogFactory.getLog(getClass());


	@RequestMapping("/hello")
	public String hello() {

		
		logger.info("hello service ...");
		
		return "hello";

	}

	@RequestMapping("/hello01")
	public String test02() {
		
		
		logger.info("hello01 service ...");

		return "this is test 02";
	}
	
	
	@RequestMapping("hello02")
	public String test03() {
		
		
		logger.info("this is hello 02 service connect");
		
		return "this is test 03";
	}

}
