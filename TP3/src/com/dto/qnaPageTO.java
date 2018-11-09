package com.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class qnaPageTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int amount;					// ��� �Խñ��� ��
	private int perPage = 5;			// �������� �� �����ִ� �Խñ��� ��(10���� �ʱ�ȭ)
	private int curPage;				// ���� �������� �ش��ϴ� �Խñ��� ���
	private ArrayList<qnaDTO> list;	// ����¡ ó�� ��, �ִ� ������ ��, amount��  perPage�� ���� ����
	
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
