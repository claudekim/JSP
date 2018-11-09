package com.dto;

import java.io.Serializable;

public class GuestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int guestNum;
	private String day;
	private String gid;
	
	public GuestDTO() {}

	public GuestDTO(int guestNum, String day, String gid) {
		super();
		this.guestNum = guestNum;
		this.day = day;
		this.gid = gid;
	}

	public int getGuestNum() {
		return guestNum;
	}

	public void setGuestNum(int guestNum) {
		this.guestNum = guestNum;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
