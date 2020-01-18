package com.member.example.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDTO {
	private String mem_id;
	private String mem_pw;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date mem_birth;
	private String mem_gender;
	private String mem_raspnum;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_raspnum() {
		return mem_raspnum;
	}
	public void setMem_raspnum(String mem_raspnum) {
		this.mem_raspnum = mem_raspnum;
	}
	@Override
	public String toString() {
		return "MemberDTO [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_birth=" + mem_birth + ", mem_gender="
				+ mem_gender + ", mem_raspnum=" + mem_raspnum + "]";
	}
	
//	private String mem_name;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	//private Date mem_birth;
//	private String mem_email;
//	private String mem_phone;
//	private String mem_gender;
//	private String mem_address;
//	private int mem_point;

  

}