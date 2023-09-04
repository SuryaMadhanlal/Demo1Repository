package com.model;

public class Passenger {
	
	private int pnrNo;
	private String pName;
	private int pAge;
	public Passenger() {
		super();
	}
	public Passenger(int pnrNo, String pName, int pAge) {
		super();
		this.pnrNo = pnrNo;
		this.pName = pName;
		this.pAge = pAge;
	}
	public int getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpAge() {
		return pAge;
	}
	public void setpAge(int pAge) {
		this.pAge = pAge;
	}
	

}
