package com.revature.cukes;

public class Account {
	private int accountNum;
	private String name;
	
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", name=" + name + "]";
	}
}
