/** 
 * Project Name:hbase-step 
 * File Name:StevenHBaseConfiguation.java 
 * Package Name:com.steven.hbase.conf 
 * Date:2017年12月24日下午9:17:52 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.hbase.conf;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Table;

import com.steven.util.HBasePropertiesTools;

import lombok.extern.log4j.Log4j;

/**
 * ClassName:StevenHBaseConfiguation <br/>
 * Function: hbase配置信息 <br/>
 * Date: 2017年12月24日 下午9:17:52 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
@Log4j
public class StevenHBaseConfiguation {
	// zookeep连接
	private static String HBASE_ZOOKEEPER_ADDRESS = HBasePropertiesTools
			.getPropertityValue(HBasePropertiesTools.ZOOKEEPER_QUORUM);
	// zookeper端口
	private static String HBASE_CLIENT_PORT = HBasePropertiesTools.getPropertityValue(HBasePropertiesTools.CLIENTPORT);

	// HDFS路径
	private static String HBASE_ROOTDIR = HBasePropertiesTools.getPropertityValue(HBasePropertiesTools.ROOTDIR);
	private static String HBASE_ZNODE_PARENT = HBasePropertiesTools
			.getPropertityValue(HBasePropertiesTools.ZNODE_PARENT);

	private Connection connection;
	private Admin admin;
	private Table table;

	/**
	 * getConnect:获取hbase连接. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @return
	 */
	public Connection getConnect() {
		Configuration configuration = org.apache.hadoop.hbase.HBaseConfiguration.create();
		String hbase_zookeeper_address = System.getenv("HBASE_ZOOKEEPER_ADDRESS");
		if (hbase_zookeeper_address != null) {
			HBASE_ZOOKEEPER_ADDRESS = hbase_zookeeper_address;
		}
		configuration.set("hbase.zookeeper.quorum", HBASE_ZOOKEEPER_ADDRESS);
		configuration.set("hbase.zookeeper.property.clientPort", HBASE_CLIENT_PORT);
		configuration.set("hbase.rootdir", HBASE_ROOTDIR);
		configuration.set("zookeeper.znode.parent", HBASE_ZNODE_PARENT);
		try {
			connection = ConnectionFactory.createConnection(configuration);
			return connection;
		} catch (IOException e) {
			log.error("HBase获取连接失败:" + e);
		}
		return null;
	}

	/**
	 * getAdmin:获取admin. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @return
	 */
	public Admin getAdmin() {
		if (connection == null) {
			getConnect();
		}
		try {
			admin = connection.getAdmin();
			return admin;
		} catch (IOException e) {
			log.error("获取admin失败:" + e);
		}
		return null;
	}

	/**
	 * getTable:获取htable实例. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param tableName
	 * @return
	 */
	public Table getTable(String tableName) {
		try {
			if (admin == null) {
				getAdmin();
			}
			TableName tn = TableName.valueOf(tableName);
			if (admin.tableExists(tn)) {
				table = connection.getTable(tn);
			} else {
				log.info("表名【" + tableName + "】不存在");
			}
		} catch (IOException e) {
			log.error(e);
		}
		return table;
	}

	/**
	 * getPool:创建hbase连接池. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @return
	 */
	public HTablePool getPool() {
		Configuration configuration = org.apache.hadoop.hbase.HBaseConfiguration.create();
		String hbase_zookeeper_address = System.getenv("HBASE_ZOOKEEPER_ADDRESS");
		if (hbase_zookeeper_address != null) {
			HBASE_ZOOKEEPER_ADDRESS = hbase_zookeeper_address;
		}
		configuration.set("hbase.zookeeper.quorum", HBASE_ZOOKEEPER_ADDRESS);
		configuration.set("hbase.zookeeper.property.clientPort", HBASE_CLIENT_PORT);
		configuration.set("hbase.rootdir", HBASE_ROOTDIR);
		configuration.set("zookeeper.znode.parent", HBASE_ZNODE_PARENT);
		HTablePool hTablePool = new HTablePool(configuration, 5);
		return hTablePool;
	}

	/**
	 * close:关闭资源. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 */
	public void close() {
		try {
			if (admin != null) {
				admin.close();
			}
			if (table != null) {
				table.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (IOException e) {
			log.error("关闭HBase资源失败" + e);
		}
	}

}
