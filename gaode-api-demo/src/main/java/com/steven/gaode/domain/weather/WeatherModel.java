/** 
 * Project Name:gaode-api-demo 
 * File Name:Weather.java 
 * Package Name:com.steven.gaode.domain 
 * Date:2017年12月17日上午12:05:25 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.domain.weather;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:Weather <br/>
 * Function: 高德天气类. <br/>
 * 天气json串信息详见网页：http://lbs.amap.com/api/webservice/guide/api/weatherinfo <br/>
 * 
 * Date:2017年12月17日 上午12:05:25 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class WeatherModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * status:返回状态.
	 */
	private String status;
	/**
	 * count:返回结果总数目.
	 */
	private String count;
	/**
	 * info:返回的状态信息.
	 */
	private String info;

	/**
	 * infocode:返回状态说明,1000代表正确.
	 */
	private String infocode;
	/**
	 * lives:实况天气数据信息.
	 */
	private List<LiveWeather> lives;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public List<LiveWeather> getLives() {
		return lives;
	}

	public void setLives(List<LiveWeather> lives) {
		this.lives = lives;
	}

	public WeatherModel() {
		super();
	}

	@Override
	public String toString() {
		return "Weather [status=" + status + ", count=" + count + ", info=" + info + ", infocode=" + infocode
				+ ", lives=" + lives + "]";
	}

}
