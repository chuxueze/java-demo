/** 
 * Project Name:hbase-step 
 * File Name:HBaseTableHandlerTest.java 
 * Package Name:com.steven.hbase.handler 
 * Date:2017年12月24日下午10:32:53 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/  
  
package com.steven.hbase.handler;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * ClassName:HBaseTableHandlerTest <br/> 
 * Function: ADD FUNCTION. <br/> 
 * Date:     2017年12月24日 下午10:32:53 <br/> 
 * @author   Steven
 * @version   
 * @see       
 */
public class HBaseTableHandlerTest {

	
	private HBaseTableHandler tableHandler = new HBaseTableHandler();
	
	@Test
	public void testCreateTable() {
		tableHandler.createTable("hbase-step-table", "base-info", "extend-info");
	}

	@Test
	public void testDeleteTable() {
		tableHandler.deleteTable("hbase-step-table");
	}

	@Test
	public void testEnableTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisableTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testListTables() {
		 
		tableHandler.listTables();
	}

	@Test
	public void testAddColumn() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteColumn() {
		fail("Not yet implemented");
	}

}
  