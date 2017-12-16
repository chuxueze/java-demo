/** 
 * Project Name:gaode-api-demo 
 * File Name:LiveWeather.java 
 * Package Name:com.steven.gaode.domain 
 * Date:2017年12月17日上午12:09:27 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.domain.weather;

import java.io.Serializable;

/**
 * ClassName:LiveWeather <br/>
 * Function: 高德天气类中的实时天气数据对象 <br/>
 * Date: 2017年12月17日 上午12:09:27 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class LiveWeather implements Serializable {
	private static final long serialVersionUID = 1L;
	private String province;
	private String city;
	private String adcode;
	private String weather;
	private String temperature;
	private String winddirection;
	private String windpower;
	private String humidity;
	private String reporttime;

	public LiveWeather() {
		super();
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWinddirection() {
		return winddirection;
	}

	public void setWinddirection(String winddirection) {
		this.winddirection = winddirection;
	}

	public String getWindpower() {
		return windpower;
	}

	public void setWindpower(String windpower) {
		this.windpower = windpower;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getReporttime() {
		return reporttime;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

	@Override
	public String toString() {
		return "LiveWeather [province=" + province + ", city=" + city + ", adcode=" + adcode + ", weather=" + weather
				+ ", temperature=" + temperature + ", winddirection=" + winddirection + ", windpower=" + windpower
				+ ", humidity=" + humidity + ", reporttime=" + reporttime + "]";
	}
}
