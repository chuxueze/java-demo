/** 
 * Project Name:gaode-api-demo 
 * File Name:GaodePOIDetailApp.java 
 * Package Name:com.steven.gaode.app 
 * Date:2017年12月17日上午1:09:41 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.app;

import java.io.IOException;

import com.steven.gaode.domain.poi.POIModel;
import com.steven.gaode.service.GaodePOIDetailService;

/**
 * ClassName:GaodePOIDetailApp <br/>
 * Function: ADD FUNCTION. <br/>
 * Date: 2017年12月17日 上午1:09:41 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class GaodePOIDetailApp {

	public static void main(String[] args) {
		// "id": "B02F38IOYE",
		// "name": "深圳市华为技术有限公司",
		System.out.println("获取【深圳市华为技术有限公司】的POI详细数据");
		try {
			POIModel poiDetail = GaodePOIDetailService.getPOIDetailByID("B02F38IOYE");
			System.out.println(poiDetail);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("获取【深圳市华为技术有限公司】的POI详细数据结束");

	}

}
