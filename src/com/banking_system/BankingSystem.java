package com.banking_system;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import com.accounting.Account;
import com.accounting.Customer;
import com.banks.ICICI;
import com.banks.PNB;
import com.banks.RBI;
import com.banks.SBI;

public class BankingSystem {
	private static Customer[] customers = new Customer[100];
	static Customer c = new Customer();
	private static int i = 0;

	static void createAccount(String choice, String accountType, Customer c) {
		Account ac = new Account();
		RBI bank = null;
		switch (choice) {
		case "1":
			bank = new SBI();
			ac.setBankName("SBI");
			break;
		case "2":
			bank = new PNB();
			ac.setBankName("PNB");
			break;
		case "3":
			bank = new ICICI();
			ac.setBankName("ICICI");
			break;
		default:
			System.out.println("Wrong choice of bank: ");
			System.exit(0);

		}
		switch (accountType) {
		case "1":
			ac.setAccountType("Savings");
			break;
		case "2":
			ac.setAccountType("Current");
			break;
		default:
			System.out.println("Wrong Choice!");
			System.exit(0);
		}
		Integer acId = new Random().nextInt();
		ac.setAccountNumber(acId.toString());
		c.setAccount(ac);
		c.setBankName(ac.getBankName());
		customers[i++] = c;
		bank.setCustomer(customers);
		System.out.println("\nYour account has been created with following details:");
		System.out.println("Bank: " + c.getAccount().getBankName());
		System.out.println("Name: " + c.getCustomerName());
		System.out.println("DOB: " + c.getDateOfBirth());
		System.out.println("Account Type: " + c.getAccount().getAccountType());
		System.out.println("Account Number: " + c.getAccount().getAccountNumber());
	}

	static void deposit(double amount) {
		if (amount != 0) {
			double balance = c.getBalance();
			c.setBalance(balance + amount);
			System.out.println("Balance after deposit: " + c.getBalance());
			c.setPreviousTransaction(amount);
		}
	}

	static void withdraw(double amount) {
		if (amount != 0) {
			double balance = c.getBalance();
			c.setBalance(balance - amount);
			System.out.println("Balance after withdraw: " + c.getBalance());
			c.setPreviousTransaction(-amount);
		}
	}

	static void getPreviousTransaction() {
		FileOutputStream out;
		PrintStream p;

		try {
			out = new FileOutputStream("mini-statement.txt");
			p = new PrintStream(out);

			if (c.getPreviousTransaction() > 0) {
				p.append("Deposited: " + c.getPreviousTransaction());
				System.out.println("Deposited: " + c.getPreviousTransaction());
			} else if (c.getPreviousTransaction() < 0) {
				p.append("Withdraw: " + c.getPreviousTransaction());
				System.out.println("Withdraw: " + Math.abs(c.getPreviousTransaction()));
			} else {
				System.out.println("No Transaction Record..");
			}
			p.close();
		} catch (Exception e) {
			System.out.println("Error is printing in our data" + e);
		}
	}

	static void calculateInterest(String accountType, int years) {
		Account ac = new Account();
		double amount = 0;
		if (accountType.equalsIgnoreCase("1")) {
			amount = c.getBalance() * (1 + ac.getSAVINGS_INTEREST_RATE() * years);
		} else if (accountType.equalsIgnoreCase("2")) {
			amount = c.getBalance() * (Math.pow((1 + (ac.getCURRENT_INTEREST_RATE() / 2)), 2 * years));
		}
		c.setInterestEarned(amount - c.getBalance());
		System.out.println("Your earned interest would be: " + c.getInterestEarned());

	}

	static void showMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Bank Menu: ");
		System.out.println("\n");
		System.out.println(" 1. Check Balance");
		System.out.println(" 2. Deposit Amount");
		System.out.println(" 3. Withdraw Amount");
		System.out.println(" 4. View Previous Transection Details");
		System.out.println(" 5. Claculate Intrest");
		System.out.println(" 6. Exit");

		char option;
		do {
			System.out.println("*****************************************************");
			System.out.println("Enter an option: ");
			System.out.println("*****************************************************");
			option = sc.next().charAt(0);
			System.out.println("\n");

			switch (option) {
			case '1':
				System.out.println("--- --- --- --- --- --- --- --- --- --- --- --- --- ---");
				System.out.println("Balance = " + c.getBalance());
				System.out.println("\n");
				break;

			case '2':
				System.out.println("--- --- --- --- --- --- --- --- --- --- --- --- --- ---");
				System.out.println("Enter an amount to Deposit: ");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;

			case '3':
				System.out.println("--- --- --- --- --- --- --- --- --- --- --- --- --- ---");
				System.out.println("Enter an amount to Withdraw: ");
				int amount2 = sc.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;

			case '4':
				System.out.println("--- --- --- --- --- --- --- --- --- --- --- --- --- ---");
				getPreviousTransaction();
				System.out.println("\n");
				break;

			case '5':
				System.out.println("--- --- --- --- --- --- --- --- --- --- --- --- --- ---");
				System.out.println("Which type of account you have? 1: Savings 2. Current");
				String accountType = sc.next();
				System.out.println("Enter the number of years for calculating interset: ");
				int years = sc.nextInt();
				calculateInterest(accountType, years);
				System.out.println("\n");
				break;

			case '6':
				System.out.println("--- --- --- --- --- --- --- --- --- --- --- --- --- ---");
				break;

			default:
				System.out.println("Entered Invalid Option..! Please enter again.");
				break;
			}
		} while (option != '6');
		System.out.println("Thank you for using our service...  (',')  ");
		sc.close();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		System.out.println("************ WELCOME TO THE NATIONAL BANKING SYSTEM ************");
		System.out.println("DO you want to open your new Account:- \n1. Yes  2. No ");
		choice = sc.next();
		sc.nextLine();
		if (choice.equalsIgnoreCase("1")) {
			System.out.println("In which bank do you want to open account: 1.SBI 2.PNB 3.ICICI");
			choice = sc.nextLine();
			System.out.println("Please enter your name: ");
			c.setCustomerName(sc.nextLine());
			System.out.println("Enter your date of birth:");
			c.setDateOfBirth(sc.next());
			System.out.println("Enter your contact no: ");
			c.setContactNo(sc.next());
			System.out.println("Which type of Account do you want to open: 1. Savings Account. 2. Current Account.");
			String accountType = sc.next();
			createAccount(choice, accountType, c);
			showMenu();

		}else if(choice.equalsIgnoreCase("2")) {
			showMenu();
		}
		else {
			System.out.println("Wrong Choice!");
			System.out.println("Thank you! Visit Again..");
			System.exit(0);
		}

		sc.close();
	}

}