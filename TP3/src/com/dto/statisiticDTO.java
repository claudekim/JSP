package com.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class statisiticDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int men;
	private int women;
	private int sum;
	private ArrayList<VPDDTO> list;
	
	public statisiticDTO() {}

	public statisiticDTO(int men, int women, int sum, ArrayList<VPDDTO> list) {
		super();
		this.men = men;
		this.women = women;
		this.sum = sum;
		this.list = list;
	}

	public int getMen() {
		return men;
	}

	public void setMen(int men) {
		this.men = men;
	}

	public int getWomen() {
		return women;
	}

	public void setWomen(int women) {
		this.women = women;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public ArrayList<VPDDTO> getList() {
		return list;
	}

	public void setList(ArrayList<VPDDTO> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
