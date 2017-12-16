/** 
 * Project Name:gaode-api-demo 
 * File Name:GaodeWaatherService.java 
 * Package Name:com.steven.gaode.service 
 * Date:2017年12月17日上午12:16:35 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.service;

import java.io.IOException;

import com.steven.gaode.domain.weather.WeatherModel;
import com.steven.gaode.util.GaodeAPITool;

/**
 * ClassName:GaodeWaatherService <br/>
 * Function: 高德天气服务. <br/>
 * Date: 2017年12月17日 上午12:16:35 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class GaodeWaatherService {

	/**
	 * getWeatherByCityName:获取指定城市当前的天气信息. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param cityName
	 * @return
	 * @throws IOException
	 */
	public static WeatherModel getWeatherByCityName(String cityName) throws IOException {
		WeatherModel weather = null;
		String url = GaodeAPITool.getCurrentWeatherURL(cityName);
		GaodeAPITool<WeatherModel> tool = new GaodeAPITool<WeatherModel>();
		weather = tool.getModelByAPIURL(url, WeatherModel.class);
		return weather;
	}
}
