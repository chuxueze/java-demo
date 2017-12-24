/** 
 * Project Name:hbase-step 
 * File Name:HBasePropertiesToolsTest.java 
 * Package Name:com.steven.util 
 * Date:2017年12月24日下午9:39:05 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName:HBasePropertiesToolsTest <br/>
 * Function: ADD FUNCTION. <br/>
 * Date: 2017年12月24日 下午9:39:05 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class HBasePropertiesToolsTest {

	@Test
	public void test() {
		String value = HBasePropertiesTools.getPropertityValue("hbase.zookeeper.quorum");
		Assert.assertEquals("hadoop-01,hadoop-02,hadoop-03", value);
	}

}
