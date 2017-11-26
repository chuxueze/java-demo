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
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * ClassName:HBaseDao <br/>
 * Function: HBase操作DAO类，用于跟直接与HBase进行交互和操作 <br/>
 * Date: 2017年11月26日 下午2:50:03 <br/>
 * 
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
	 * 【注意事项（可选）】如果已经数据表存在，则创建失败，返回false<br/>
	 * 
	 * @author Steven
	 * @param strTableName
	 *            待创建的表格名称
	 * @param strColumnFamily
	 *            列族名
	 * @return true：创建成功；false：创建失败
	 */
	public static boolean createTable(String strTableName, String strColumnFamily) {

		// 执行结果
		boolean result = false;

		try {
			Connection connection = ConnectionFactory.createConnection(conf);
			// 创建表管理类
			Admin admin = connection.getAdmin();
			// 创建表描述类
			TableName tableNameObj = TableName.valueOf(strTableName);
			if (admin.tableExists(tableNameObj)) {
				System.out.println("Table exists!");
			} else {
				// 创建列族的描述类
				HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf(strTableName));
				// 将列族添加到表中
				tableDesc.addFamily(new HColumnDescriptor(strColumnFamily));
				// 创建表
				admin.createTable(tableDesc);
				System.out.println("Create table 【" + strTableName + "】 success.");
				// 将结果设置为true
				result = true;
			}
			// 关闭相关连接
			admin.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Create table 【" + strTableName + "】 fail.");
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
	 * @param strTableName
	 *            待删除的数据表
	 * @return true：删除成功；false：删除失败
	 */
	public static boolean deleteTable(String strTableName) {
		// 执行结果
		boolean result = false;

		try {
			Connection connection = ConnectionFactory.createConnection(conf);
			Admin admin = connection.getAdmin();
			TableName table = TableName.valueOf(strTableName);
			admin.disableTable(table);
			admin.deleteTable(table);
			System.out.println("delete table 【" + strTableName + "】 success.");
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("delete table 【" + strTableName + "】 fail.");
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
	 * @param strTableName
	 *            数据表
	 * @param strRowkey
	 *            主键
	 * @param strColumnFamily
	 *            列族名
	 * @param strQualifier
	 *            列名
	 * @param strValue
	 *            列值
	 * @return
	 */
	public static boolean addRecord(String strTableName, String strRowkey, String strColumnFamily, String strQualifier,
			String strValue) {
		// 执行结果
		boolean result = false;
		try {
			Connection connection = ConnectionFactory.createConnection(conf);
			Table table = connection.getTable(TableName.valueOf(strTableName));
			Put put = new Put(Bytes.toBytes(strRowkey));
			put.add(Bytes.toBytes(strColumnFamily), Bytes.toBytes(strQualifier), Bytes.toBytes(strValue));
			table.put(put);
			table.close();
			connection.close();
			System.out.println("insert recored " + strRowkey + " to table 【" + strTableName + "】 success.");
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("insert recored " + strRowkey + " to table 【" + strTableName + "】 fail.");
			result = false;
		}
		return result;
	}

	// TODO:批量增加key-value键值对 addRecords

	// TODO：获取指定Rowkey的值
	
	// TODO：删除列族 deleteColumnFamilies

	/**
	 * deleteDataByRowkeys:删除指定Rowkey的值. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param strTableName 数据表
	 * @param lstRowKeys 待删除的Rowkey列表
	 * @return
	 */
	public static boolean deleteDataByRowkeys(String strTableName, List<String> lstRowKeys) {
		// 执行结果
		boolean result = false;
		try {
			Connection connection = ConnectionFactory.createConnection(conf);
			Table table = connection.getTable(TableName.valueOf(strTableName));
			// 获取待删除的列表清单
			List<Delete> lstDeleteRows = new ArrayList<Delete>();
			for (String rowkey : lstRowKeys) {
				Delete d = new Delete(rowkey.getBytes());
				lstDeleteRows.add(d);
			}
			table.delete(lstDeleteRows);
			table.close();
			connection.close();
			System.out.println("Delete recoreds " + lstRowKeys + " from 【" + strTableName + "】 success.");
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Delete recoreds " + lstRowKeys + " from 【" + strTableName + "】 fail.");
			result = false;
		}
		return result;
	}

}
