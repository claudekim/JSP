package com.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class qnaPageTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int amount;					// 모든 게시글의 수
	private int perPage = 5;			// 한페이지 당 보여주는 게시글의 수(10으로 초기화)
	private int curPage;				// 현재 페이지에 해당하는 게시글의 목록
	private ArrayList<qnaDTO> list;	// 페이징 처리 시, 최대 페이지 수, amount와  perPage로 유도 가능
	
	public qnaPageTO() {}

	public qnaPageTO(int amount, int perPage, int curPage, ArrayList<qnaDTO> list) {
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

	public ArrayList<qnaDTO> getList() {
		return list;
	}

	public void setList(ArrayList<qnaDTO> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
