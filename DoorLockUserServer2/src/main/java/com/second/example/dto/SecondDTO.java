package com.second.example.dto;

import javax.inject.Inject;

public class SecondDTO {
	@Inject
	private String second_pw;

	public String getSecond_pw() {
		return second_pw;
	}

	public void setSecond_pw(String second_pw) {
		this.second_pw = second_pw;
	}

	@Override
	public String toString() {
		return "SecondDTO [second_pw=" + second_pw + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}