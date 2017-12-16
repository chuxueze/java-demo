/** 
 * Project Name:gaode-api-demo 
 * File Name:POIDetail.java 
 * Package Name:com.steven.gaode.domain.poi 
 * Date:2017年12月17日上午1:19:06 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.domain.poi;

import java.io.Serializable;

/**
 * ClassName:POIDetail <br/>
 * Function: ADD FUNCTION. <br/>
 * Date: 2017年12月17日 上午1:19:06 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class POIDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String type;
	private String typecode;
	private String address;
	private String location;
	private String tel;
	private String pcode;
	private String pname;
	private String citycode;
	private String cityname;
	private String adcode;
	private String adname;
	private String entr_location;
	public POIDetail() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getAdcode() {
		return adcode;
	}
	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getEntr_location() {
		return entr_location;
	}
	public void setEntr_location(String entr_location) {
		this.entr_location = entr_location;
	}
	@Override
	public String toString() {
		return "POIDetail [id=" + id + ", name=" + name + ", type=" + type + ", typecode=" + typecode + ", address="
				+ address + ", location=" + location + ", tel=" + tel + ", pcode=" + pcode + ", pname=" + pname
				+ ", citycode=" + citycode + ", cityname=" + cityname + ", adcode=" + adcode + ", adname=" + adname
				+ ", entr_location=" + entr_location + "]";
	}
	
}
