/** 
 * Project Name:gaode-api-demo 
 * File Name:GaodeAPITool.java 
 * Package Name:com.steven.gaode.util 
 * Date:2017年12月17日上午12:18:25 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * ClassName:GaodeAPITool <br/>
 * Function: 高德相关API通用的小工具. <br/>
 * Date: 2017年12月17日 上午12:18:25 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class GaodeAPITool<T> {

	/**
	 * APP_KEY:网上学习使用的高德KEY.
	 */
	public static final String APP_KEY = "389880a06e3f893ea46036f030c94700";

	/**
	 * getCurrentWeatherURL:获取指定城市当前天气数据的API URL字符串. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param city
	 * @return
	 */
	public static String getCurrentWeatherURL(String city) {
		return "http://restapi.amap.com/v3/weather/weatherInfo?key=" + APP_KEY + "&city=" + city + "&extensions=base";
	}

	/**
	 * getPOIDetailURL:根据POI ID获取详细数据. <br/>
	 * 例如“深圳市华为技术有限公司”的POI ID为 B02F38IOYE 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param poiID
	 * @return
	 */
	public static String getPOIDetailURL(String poiID) {
		return "http://restapi.amap.com/v3/place/detail?key=" + APP_KEY + "&id=" + poiID;
	}

	/**
	 * getModelByAPIURL:将获取在线API数据的操作，封装通用的工具类，减少重复代码. <br/>
	 * 【适用条件（可选）】.<br/>
	 * 【执行流程 （可选）】.<br/>
	 * 【使用方法（可选）】.<br/>
	 * 【注意事项（可选）】.<br/>
	 * 
	 * @author Steven
	 * @param url
	 * @param returnType
	 * @return
	 */
	public T getModelByAPIURL(String url, final Class<T> returnType) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		T result = null;
		try {

			HttpGet httpget = new HttpGet(url);
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;

					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			if (null != responseBody) {
				ObjectMapper objectMapper = new ObjectMapper();
				// 当反序列化json时，未知属性会引起的反序列化被打断，忽略bean中未定义的属性
				objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				result = objectMapper.readValue(responseBody.getBytes(), returnType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
