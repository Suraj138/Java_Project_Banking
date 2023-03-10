package com.accounting;

public class Customer {

	private String customerName;
	private Account account;
	private String contactNo;
	private String dateOfBirth;
	private String bankName;
	private double balance;
	private double interestEarned;
	private double previousTransaction;
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestEarned() {
		return interestEarned;
	}

	public void setInterestEarned(double interestEarned) {
		this.interestEarned = interestEarned;
	}

	
	public double getPreviousTransaction() {
		return previousTransaction;
	}

	public void setPreviousTransaction(double amount) {
		this.previousTransaction = amount;
	}

	public Customer(String customerName, Account account, String contactNo, String dateOfBirth, String bankName,
			double balance, double interestEarned, int previousTransaction) {
		super();
		this.customerName = customerName;
		this.account = account;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
		this.bankName = bankName;
		this.balance = balance;
		this.interestEarned = interestEarned;
		this.previousTransaction = previousTransaction;
	}

	public Customer() {
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	
}
