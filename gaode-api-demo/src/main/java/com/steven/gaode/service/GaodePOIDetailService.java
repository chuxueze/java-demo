/** 
 * Project Name:gaode-api-demo 
 * File Name:GaodePOIDetailService.java 
 * Package Name:com.steven.gaode.service 
 * Date:2017年12月17日上午1:05:40 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.service;

import java.io.IOException;

import com.steven.gaode.domain.poi.POIModel;
import com.steven.gaode.util.GaodeAPITool;

/**
 * ClassName:GaodePOIDetailService <br/>
 * Function: ADD FUNCTION. <br/>
 * Date: 2017年12月17日 上午1:05:40 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class GaodePOIDetailService {

	/**
	 * getPOIDetailByID:获取指定POI的详细数据. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param poiID
	 * @return
	 * @throws IOException
	 */
	public static POIModel getPOIDetailByID(String poiID) throws IOException {
		POIModel poiDetail = null;
		String url = GaodeAPITool.getPOIDetailURL(poiID);
		GaodeAPITool<POIModel> tool = new GaodeAPITool<POIModel>();
		poiDetail = tool.getModelByAPIURL(url, POIModel.class);
		return poiDetail;
	}

}
