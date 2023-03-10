package com.banks;

import java.util.Random;

import com.accounting.Account;
import com.accounting.Customer;

public class SBI extends RBI {

	private Account account;
	private Customer [] customers;
	private String bankName;
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public SBI(Account account, Customer[] customers, String bankName) {
		super();
		this.account = account;
		this.customers = customers;
		this.bankName = bankName;
	}

	public SBI() {		
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers=new Customer[100];
		Customer c1=new Customer();
		Customer c2=new Customer();
		Account ac1=new Account();
		Account ac2=new Account();
		Random rand=new Random();
		Integer in=rand.nextInt();
		ac1.setAccountNumber(in.toString());
		ac1.setAccountType("Savings");
		c1.setAccount(ac1);
		c1.setCustomerName("Amit");
		c1.setBalance(2000);
		c1.setContactNo("xxxxxxxxxx");
		in=rand.nextInt();
		ac2.setAccountNumber(in.toString());
		ac2.setAccountType("Current");
		c1.setCustomerName("Ajay");
		c2.setAccount(ac2);
		c2.setBalance(10000);
		c2.setContactNo("xxxxxxxxxx");
		this.customers[0]=c1;
		this.customers[1]=c2;
	}
	
}
