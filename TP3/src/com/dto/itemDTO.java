package com.dto;

import java.io.Serializable;

public class itemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int gnum;
	private String gtitle;
	private String gcontent;
	private String gwriteday;
	private int greadcnt;
	private int qnaNum;
	
	
	public itemDTO() {}

	public itemDTO(int gnum, String gtitle, String gcontent, String gwriteday, int greadcnt) {
		super();
		this.gnum = gnum;
		this.gtitle = gtitle;
		this.gcontent = gcontent;
		this.gwriteday = gwriteday;
		this.greadcnt = greadcnt;
	}

	public itemDTO(String gtitle, String gcontent) { 
		this.gtitle = gtitle;
		this.gcontent = gcontent;
	}

	public itemDTO(int gnum, String gtitle, String gcontent) {
		this.gnum = gnum;
		this.gtitle = gtitle;
		this.gcontent = gcontent;
	}

	

	public itemDTO(int gnum, String gtitle, String gcontent, String gwriteday, int greadcnt, int qnaNum) {
		super();
		this.gnum = gnum;
		this.gtitle = gtitle;
		this.gcontent = gcontent;
		this.gwriteday = gwriteday;
		this.greadcnt = greadcnt;
		this.qnaNum = qnaNum;
	}

	
	
	
	
	
	public int getGnum() {
		return gnum;
	}

	public void setGnum(int gnum) {
		this.gnum = gnum;
	}

	public String getGtitle() {
		return gtitle;
	}

	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}

	public String getGcontent() {
		return gcontent;
	}

	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}

	public String getGwriteday() {
		return gwriteday;
	}

	public void setGwriteday(String gwriteday) {
		this.gwriteday = gwriteday;
	}

	public int getGreadcnt() {
		return greadcnt;
	}

	public void setGreadcnt(int greadcnt) {
		this.greadcnt = greadcnt;
	}

	public int getQnaNum() {
		return qnaNum;
	}

	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gnum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		itemDTO other = (itemDTO) obj;
		if (gnum != other.gnum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return gnum + gtitle + gcontent + gwriteday +  greadcnt;
	}
	
	
}
