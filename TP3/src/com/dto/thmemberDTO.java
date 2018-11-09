package com.dto;

import java.io.Serializable;

public class thmemberDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String name;
	private String address;
	private String sex;
	private String birthday;
	private String who;
	
	public thmemberDTO() {}

	public thmemberDTO(String id, String pw, String name, String address, String sex, String birthday, String who) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.who = who;
	}
	public thmemberDTO(String id, String pw,String who) {
		super();
		this.id = id;
		this.pw = pw;
		this.who = who;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		thmemberDTO other = (thmemberDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + pw + name + address +  sex + birthday + who;
	}

}
