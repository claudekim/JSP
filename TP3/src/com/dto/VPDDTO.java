package com.dto;

public class VPDDTO {
	private int cnt;
	private String day;
	
	public VPDDTO(int cnt, String day) {
		super();
		this.cnt = cnt;
		this.day = day;
	}

	public VPDDTO() {}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}


	
}
