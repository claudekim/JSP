package com.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemPageTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int itemAmount;
	private int perPage=5;
	private int itemCurPage;
	private ArrayList<itemDTO> itemList;
	
	public ItemPageTO() {}

	public ItemPageTO(int itemAmount, int perPage, int itemCurPage, ArrayList<itemDTO> itemList) {
		super();
		this.itemAmount = itemAmount;
		this.perPage = perPage;
		this.itemCurPage = itemCurPage;
		this.itemList = itemList;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getItemCurPage() {
		return itemCurPage;
	}

	public void setItemCurPage(int itemCurPage) {
		this.itemCurPage = itemCurPage;
	}

	public ArrayList<itemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<itemDTO> itemList) {
		this.itemList = itemList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
