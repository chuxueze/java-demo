/** 
 * Project Name:hbase-step 
 * File Name:HBaseRowHandlerTest.java 
 * Package Name:com.steven.hbase.handler 
 * Date:2017年12月24日下午11:20:22 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/  
  
package com.steven.hbase.handler;

import static org.junit.Assert.fail;

import org.junit.Test;

/** 
 * ClassName:HBaseRowHandlerTest <br/> 
 * Function: ADD FUNCTION. <br/> 
 * Date:     2017年12月24日 下午11:20:22 <br/> 
 * @author   Steven
 * @version   
 * @see       
 */
public class HBaseRowHandlerTest {

	
	private HBaseTableHandler tableHandler = new HBaseTableHandler();
	private HBaseRowHandler rowHandler = new HBaseRowHandler();
	
	@Test
	public void testInsertRow() {
		rowHandler.insertRow("hbase-step-table", "001", "base-info", "name", "liu bei");
	}

	@Test
	public void testInsertMultiRow() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBatchRow() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckAndPut() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRowValue() {
		
//		getRowValue
	}

	@Test
	public void testGetFamilyValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetColumnValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBatchRow() {
		fail("Not yet implemented");
	}

	@Test
	public void testExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRow() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteColumn() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteFamily() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckAndDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testAppend() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrement() {
		fail("Not yet implemented");
	}

}
  