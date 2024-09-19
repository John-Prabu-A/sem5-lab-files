import java.util.Scanner;
import java.lang.Enum;
/*
 *
 * 8.Create a BankAccount class with attributes like account number, balance, and account type.
 * Implement methods for deposit, withdrawal, and checking balance.
 *
 * */

public class BankAccount extends Accounts {
	private int accNo;
	private double balance;
	private acc accType; 
	
	BankAccount() {
		accNo = accounts + 1;
		accounts += 1;
		balance = 0;
	}

	BankAccount(acc accType) {
		accNo = accounts + 1;
		accounts += 1;
		balance = 0;
		this.accType = accType;
	}

	BankAccount(double bal, acc acType) {
		accNo = accounts + 1;
		accounts += 1;
		balance = bal;
		accType = acType;
	}

	public void deposit(double amount) {
		if(amount <= 0) return;
		balance += amount;
		System.out.println("₹"+ amount + "has been deposited.\nYour Current balance is ₹" + balance );
	}

	public void withdrawal(double amount) {
		if(amount > balance) {
			System.out.println("Insufficient balance. Your Current balance is ₹" + balance);
			return;
		}
		if(amount <= 0) {
			System.out.println("Invalid Input...");
			return;
		}
		balance -= amount;
		System.out.println("₹" + amount + "has been debitted from your account. Your Current balance is ₹" + balance);
	}

	public void Balance() {
		System.out.println("Your current balance is ₹" + balance); 
	}

	public void getAccInfo() {
		System.out.println("Acc No    : " + accNo);
		System.out.println("Acc Type  : " + (accType == acc.current ? "Current" : "Savings"));
		System.out.println("Balance   : " + balance);
	}

	public static void main(String args[]) {
		BankAccount a1 = new BankAccount();
		BankAccount a2 = new BankAccount(acc.savings);
		BankAccount a3 = new BankAccount(1000, acc.current);
		a1.deposit(1000);
		a2.deposit(-1000);
		a3.withdrawal(500);
		a3.getAccInfo();
		
	}
}

enum acc {
	current,
	savings
};

class Accounts {
	public static int accounts = 0;
}
