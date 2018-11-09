package com.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class PageTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int amount;
	private int perPage=5;
	private int curPage;
	private ArrayList<itemDTO> list;

	public PageTO() {

	}

	public PageTO(int amount, int perPage, int curPage, ArrayList<itemDTO> list) {
		super();
		this.amount = amount;
		this.perPage = perPage;
		this.curPage = curPage;
		this.list = list;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public ArrayList<itemDTO> getList() {
		return list;
	}

	public void setList(ArrayList<itemDTO> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
