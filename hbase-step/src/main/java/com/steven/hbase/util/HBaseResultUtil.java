/** 
 * Project Name:hbase-step 
 * File Name:HBaseResultUtil.java 
 * Package Name:com.steven.hbase.util 
 * Date:2017年12月24日下午11:21:48 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.hbase.util;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;

import lombok.extern.log4j.Log4j;

/**
 * ClassName:HBaseResultUtil <br/>
 * Function: ADD FUNCTION. <br/>
 * Date: 2017年12月24日 下午11:21:48 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
@Log4j
public class HBaseResultUtil {
	/**
	 * 格式化输出
	 *
	 * @param results
	 */
	public static void print(Result... results) {
		log.info("查询结果:");
		for (Result result : results) {
			Cell[] cells = result.rawCells();
			for (Cell cell : cells) {
				log.info("rowkey:" + new String(CellUtil.cloneRow(cell)) + "," + "columnFamily:"
						+ new String(CellUtil.cloneFamily(cell)) + "," + "qualifier:"
						+ new String(CellUtil.cloneQualifier(cell)) + "," + "Timetamp:" + cell.getTimestamp() + ","
						+ "value:" + new String(CellUtil.cloneValue(cell)) + ",");
			}
		}
	}
}
