package com.accounting;

public class Account {

	private String accountType;
	private String accountNumber;
	private String bankName;
	private final double SAVINGS_INTEREST_RATE=5;
	private final double CURRENT_INTEREST_RATE=8;
	
	public Account(String accountType, String accountNumber, String bankName) {
		super();
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
	}
	
	public Account() {
		
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getSAVINGS_INTEREST_RATE() {
		return SAVINGS_INTEREST_RATE;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getCURRENT_INTEREST_RATE() {
		return CURRENT_INTEREST_RATE;
	}
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double calculateInterest(int years) {
		return 1.0;
	}
	
}
