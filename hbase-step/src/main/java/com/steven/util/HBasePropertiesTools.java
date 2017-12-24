/** 
 * Project Name:hbase-step 
 * File Name:PropertiesTools.java 
 * Package Name:com.steven.util 
 * Date:2017年12月24日下午8:28:14 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import lombok.extern.log4j.Log4j;

/**
 * ClassName:HBasePropertiesTools <br/>
 * Function: 专门处理HBase配置的文件工具类：hbase.properties <br/>
 * Date: 2017年12月24日 下午8:28:14 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
@Log4j
public class HBasePropertiesTools {

	private static ResourceBundle bundle = null;

	public static String ZOOKEEPER_QUORUM = "hbase.zookeeper.quorum";
	public static String CLIENTPORT = "hbase.zookeeper.property.clientPort";
	public static String ROOTDIR = "hbase.rootdir";
	public static String ZNODE_PARENT = "zookeeper.znode.parent";

	private HBasePropertiesTools() {

	}

	static {
		bundle = PropertyResourceBundle.getBundle("hbase");
		if (bundle != null) {
			log.info("配置文件加载成功");
		} else {
			log.error("配置文件加载失败");
		}
	}

	public static String getPropertityValue(String propertityKey) {
		if (!bundle.containsKey(propertityKey)) {
			log.error("配置文件中无法找到key值：" + propertityKey);
			return null;
		}
		return bundle.getString(propertityKey);
	}

}
