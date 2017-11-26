/** 
 * Project Name:hbase-step 
 * File Name:HBaseDao.java 
 * Package Name:com.steven.hbase.dao 
 * Date:2017年11月26日下午2:50:03 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.hbase.dao;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * ClassName:HBaseDao <br/>
 * Function: HBase操作DAO类 <br/>
 * Date: 2017年11月26日 下午2:50:03 <br/>
 * 
 * @author Steven
 * @version 1.0
 * @see
 */
public class HBaseDao {

	private static Configuration conf = HBaseConfiguration.create();

	static {
		// 配置HDFS路径
		conf.set("hbase.rootdir", "hdfs://hadoop-01:9000/hbase");
		// 设置Zookeeper
		conf.set("hbase.zookeeper.quorum", "hadoop-01,hadoop-02,hadoop-03");
		// zookeeper端口
		conf.set("hbase.zookeeper.property.clientPort", "2181");
	}

	/**
	 * createTable:创建HBase表. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param tablename
	 *            待创建的表格名称
	 * @param columnFamily
	 *            列族
	 * @return true：创建成功；false：创建失败
	 */
	public static boolean createTable(String tablename, String columnFamily) {

		// 执行结果
		boolean result = false;

		try {
			Connection connection = ConnectionFactory.createConnection(conf);
			// 创建表管理类
			Admin admin = connection.getAdmin();
			// 创建表描述类
			TableName tableNameObj = TableName.valueOf(tablename);
			if (admin.tableExists(tableNameObj)) {
				System.out.println("Table exists!");
			} else {
				// 创建列族的描述类
				HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf(tablename));
				// 将列族添加到表中
				tableDesc.addFamily(new HColumnDescriptor(columnFamily));
				// 创建表
				admin.createTable(tableDesc);
				System.out.println("Create table 【" + tablename + "】 success.");
				// 将结果设置为true
				result = true;
			}
			// 关闭相关连接
			admin.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * deleteTable:删除指定的数据表. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param tableName
	 *            待删除的数据表
	 * @return true：删除成功；false：删除失败
	 */
	public static boolean deleteTable(String tableName) {
		// 执行结果
		boolean result = false;

		try {
			Connection connection = ConnectionFactory.createConnection(conf);
			Admin admin = connection.getAdmin();
			TableName table = TableName.valueOf(tableName);
			admin.disableTable(table);
			admin.deleteTable(table);
			System.out.println("delete table 【" + tableName + "】 success.");
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * addRecord:插入一行记录. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param tableName
	 *            数据表
	 * @param rowKey
	 *            主键
	 * @param family
	 *            列族
	 * @param qualifier
	 *            列名
	 * @param value
	 *            列值
	 * @return
	 */
	public static boolean addRecord(String tableName, String rowKey, String family, String qualifier, String value) {
		// 执行结果
		boolean result = false;
		try {
			Connection connection = ConnectionFactory.createConnection(conf);
			Table table = connection.getTable(TableName.valueOf(tableName));
			Put put = new Put(Bytes.toBytes(rowKey));
			put.add(Bytes.toBytes(family), Bytes.toBytes(qualifier), Bytes.toBytes(value));
			put.add(Bytes.toBytes(family), Bytes.toBytes(qualifier), Bytes.toBytes(value));
			table.put(put);
			table.close();
			connection.close();
			System.out.println("insert recored " + rowKey + " to table 【" + tableName + "】 success.");
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
}
