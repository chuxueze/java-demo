/** 
 * Project Name:gaode-api-demo 
 * File Name:WeatherApp.java 
 * Package Name:com.steven.gaode.app 
 * Date:2017年12月17日上午12:32:16 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.app;

import java.io.IOException;

import com.steven.gaode.domain.weather.WeatherModel;
import com.steven.gaode.service.GaodeWaatherService;

/**
 * ClassName:WeatherApp <br/>
 * Function: ADD FUNCTION. <br/>
 * Date: 2017年12月17日 上午12:32:16 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class WeatherApp {

	public static void main(String[] args) {
		System.out.println("获取深圳的天气数据");
		try {
			WeatherModel weather = GaodeWaatherService.getWeatherByCityName("深圳");
			System.out.println(weather);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("获取深圳的天气数据结束");
	}

}
