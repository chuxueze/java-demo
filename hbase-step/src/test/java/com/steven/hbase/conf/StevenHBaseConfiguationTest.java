/** 
 * Project Name:hbase-step 
 * File Name:StevenHBaseConfiguationTest.java 
 * Package Name:com.steven.hbase.conf 
 * Date:2017年12月24日下午9:51:04 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.hbase.conf;

import org.apache.hadoop.hbase.client.Table;
import org.junit.Test;

/**
 * ClassName:StevenHBaseConfiguationTest <br/>
 * Function: ADD FUNCTION. <br/>
 * Date: 2017年12月24日 下午9:51:04 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class StevenHBaseConfiguationTest {

	private StevenHBaseConfiguation configuration = new StevenHBaseConfiguation();

	@Test
	public void testGetTable() {

		Table table = configuration.getTable("my_table");
		System.out.println(table);
	}

}
