/**
 * 
 */
package com.cbw;

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
	
	@RequestMapping("/hello")
	public String hello() {
		
		
		
		
		return "hello";
		
		
	}
	

}
