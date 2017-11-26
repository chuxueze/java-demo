/** 
 * Project Name:hbase-step 
 * File Name:HBaseDaoTest.java 
 * Package Name:com.steven.hbase.dao 
 * Date:2017年11月26日下午3:10:02 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.hbase.dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName:HBaseDaoTest <br/>
 * Function: 测试HBase DAO操作. <br/>
 * Date: 2017年11月26日 下午3:10:02 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class HBaseDaoTest {

	/**
	 * testCreateTable:测试创建一个表. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 */
	@Test
	public void testCreateTable() {
		System.out.println("【start】: testCreateTable");
		Assert.assertTrue(HBaseDao.createTable("my_table", "info"));
		System.out.println("【end】: testCreateTable");
	}

	/**
	 * testDeleteTable:测试删除表. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 */
	@Test
	public void testDeleteTable() {
		System.out.println("【start】: testDeleteTable");
		Assert.assertTrue(HBaseDao.deleteTable("my_table"));
		System.out.println("【end】: testDeleteTable");
	}

	/**
	 * testDeleteTable:测试插入数据. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 */
	@Test
	public void testAddRecord() {
		System.out.println("【start】: testAddRecord");
		Assert.assertTrue(HBaseDao.addRecord("my_table", "001", "info", "name", "liu bei"));
		// Assert.assertTrue(HBaseDao.deleteTable("my_table"));
		System.out.println("【end】: testAddRecord");
	}

}
