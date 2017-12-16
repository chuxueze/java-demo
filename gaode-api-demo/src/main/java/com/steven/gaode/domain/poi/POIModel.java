/** 
 * Project Name:gaode-api-demo 
 * File Name:POIDetail.java 
 * Package Name:com.steven.gaode.domain.poi 
 * Date:2017年12月17日上午12:54:10 
 * Copyright (c) 2017, Steven, All Rights Reserved. 
 * 
*/

package com.steven.gaode.domain.poi;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:POIDetail <br/>
 * Function: ADD FUNCTION. <br/>
 * Date: 2017年12月17日 上午12:54:10 <br/>
 * 
 * @author Steven
 * @version
 * @see
 */
public class POIModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String status;
	private String count;
	private String info;
	private String infocode;
	private List<POIDetail> pois;

	public POIModel() {
		super();
	}

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

	public List<POIDetail> getPois() {
		return pois;
	}

	public void setPois(List<POIDetail> pois) {
		this.pois = pois;
	}

	@Override
	public String toString() {
		return "POIModel [status=" + status + ", count=" + count + ", info=" + info + ", infocode=" + infocode
				+ ", pois=" + pois + "]";
	}

}
