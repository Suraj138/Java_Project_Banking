package com.banks;

import com.accounting.Account;
import com.accounting.Customer;

public class RBI {
	
	private Account account;
	private Customer [] customers;
	private final double INTEREST_RATE=4;
	
	public RBI(Account account, Customer[] customers) {
		super();
		this.account = account;
		this.customers = customers;
	}
	
	public RBI() {
		
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer [] getCustomers() {
		return customers;
	}

	public void setCustomer(Customer[] customers) {
		this.customers = customers;
	}

	public double getINTEREST_RATE() {
		return INTEREST_RATE;
	}
	
}
