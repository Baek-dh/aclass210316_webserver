package edu.kh.member.model.vo;


import java.sql.Date;

public class Member {
	private int memNo;
	private String memId;
	private String memPw;
	private String memNm;
	private String memPhone;
	private char memGender;
	private Date joinDate;
	private char scsnFl;
	
	
	public Member() {}
	
	
	public Member(String memId, String memNm, String memPhone, char memGender, Date joinDate) {
		super();
		this.memId = memId;
		this.memNm = memNm;
		this.memPhone = memPhone;
		this.memGender = memGender;
		this.joinDate = joinDate;
	}


	public Member(String memId, String memPw, String memNm, String memPhone, char memGender) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memNm = memNm;
		this.memPhone = memPhone;
		this.memGender = memGender;
	}




	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getMemPw() {
		return memPw;
	}


	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}


	public String getMemNm() {
		return memNm;
	}


	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}


	public String getMemPhone() {
		return memPhone;
	}


	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}


	public char getMemGender() {
		return memGender;
	}


	public void setMemGender(char memGender) {
		this.memGender = memGender;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}


	public char getScsnFl() {
		return scsnFl;
	}


	public void setScsnFl(char scsnFl) {
		this.scsnFl = scsnFl;
	}


	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memId=" + memId + ", memPw=" + memPw + ", memNm=" + memNm + ", memPhone="
				+ memPhone + ", memGender=" + memGender + ", joinDate=" + joinDate + ", scsnFl=" + scsnFl + "]";
	}
	
	
	
	
	
}
