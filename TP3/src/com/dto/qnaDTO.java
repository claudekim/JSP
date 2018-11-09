package com.dto;

import java.io.Serializable;

public class qnaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int qnum;
	private String qtitle;
	private String qcontent;
	private String qwriteday;
	private String qid;
	private int readcnt;
	private int repRoot;
	private int repStep;
	private int repIndent;
	private int qgnum;
	
	public qnaDTO() {}

	public qnaDTO(String qtitle, String qcontent, String qid, int qgnum) {
		super();
		this.qtitle = qtitle;
		this.qcontent = qcontent;
		this.qid = qid;
		this.qgnum = qgnum;
	}

	
	public qnaDTO(int qnum, String qtitle, String qcontent, String qwriteday, String qid, int readcnt, int repRoot,
			int repStep, int repIndent, int qgnum) {
		super();
		this.qnum = qnum;
		this.qtitle = qtitle;
		this.qcontent = qcontent;
		this.qwriteday = qwriteday;
		this.qid = qid;
		this.readcnt = readcnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
		this.qgnum = qgnum;
	}

	public int getQnum() {
		return qnum;
	}

	public void setQnum(int qnum) {
		this.qnum = qnum;
	}

	public String getQtitle() {
		return qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public String getQwriteday() {
		return qwriteday;
	}

	public void setQwriteday(String qwriteday) {
		this.qwriteday = qwriteday;
	}

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}

	public int getQgnum() {
		return qgnum;
	}

	public void setQgnum(int qgnum) {
		this.qgnum = qgnum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + qnum;
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
		qnaDTO other = (qnaDTO) obj;
		if (qnum != other.qnum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return qnum + qtitle + qcontent + qwriteday + qid + readcnt + repRoot + repStep + repIndent + qgnum;
	}
	
	

}
