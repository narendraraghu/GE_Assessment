package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Map.Entry;

public class BankTest {

	private static final String SAVINGS = "Savings";
	private static final String CHECKING = "Checking";
	private  Bank bank;
	private Account checkingAccount;
	private Account savingsAccount;
	
	@Before
	public void setUp() {  
		bank = new Bank();
	}

	@Test
	public void addAccountTest() {
		Account account = new Account("001");
		bank.addAccount(account);
		assertEquals(1, bank.numAccounts());
	}

	@Test
	public void getAccountTest() {
		Account account = new Account("002", CHECKING, 100.0f);
		bank.addAccount(account);
		assertEquals(account, bank.getAccount("002"));
	}

	@Test
	public void depositToAccountTest() {
		Account account = new Account("003", CHECKING, 100.0f);
		bank.addAccount(account);
		bank.depositToAccount("003", 100.0f);
		assertEquals(200.0f, account.getBalance(), 0.01);
	}

	@Test
	public void withdrawFromAccountTest() {
		Account account = new Account("004", CHECKING, 100.0f);
		bank.addAccount(account);
		bank.withdrawFromAccount("004", 100.0f);
		assertEquals(0.0f, account.getBalance(), 0.01);
	}
	@Test
	public void testSumOfCurrentHoldings() {
		
		prepareBankAccountData();

		for(Entry<String, Account> eachAccount: bank.getAccountMap().entrySet()){
			bank.getAccountMap().get(eachAccount.getKey()).setBalance(0);
			bank.getAccountMap().get(eachAccount.getKey()).setBalance(100);
		}
		assertEquals(600.0f, bank.currentHolding(),0.0f);
	}
	
	@Test
	public void calProfit() {
		checkingAccount = new Account("005", CHECKING, 100.0f);
		checkingAccount.setMonthlyFee(1.0f);
		checkingAccount.setMonthlyInterestRate(0.5f);
		
		savingsAccount = new Account("006", SAVINGS, 100.0f);
		savingsAccount.setMonthlyFee(1.0f);
		savingsAccount.setMonthlyInterestRate(0.5f);
		
		bank.addAccount(checkingAccount);
		bank.addAccount(savingsAccount);

		System.out.println(bank.calProfitOrLoss());
		
		assertEquals("PROFIT", bank.calProfitOrLoss());
		
	}
	@Test
	public void calLoss() {
		checkingAccount = new Account("005", CHECKING, 100.0f);
		checkingAccount.setMonthlyFee(0.1f);
		checkingAccount.setMonthlyInterestRate(1.5f);
		
		savingsAccount = new Account("006", SAVINGS, 100.0f);
		savingsAccount.setMonthlyFee(0.1f);
		savingsAccount.setMonthlyInterestRate(1.5f);
		
		bank.addAccount(checkingAccount);
		bank.addAccount(savingsAccount);

		System.out.println(bank.calProfitOrLoss());
		
		assertEquals("LOSS", bank.calProfitOrLoss());
		
	}
	
	private void prepareBankAccountData() {
		checkingAccount = new Account("001", CHECKING);
		bank.addAccount(checkingAccount);

		savingsAccount = new Account("002", SAVINGS);
		bank.addAccount(savingsAccount);

		checkingAccount = new Account("003", CHECKING, 100.0f);
		bank.addAccount(checkingAccount);

		savingsAccount = new Account("004", SAVINGS, 100.0f);
		bank.addAccount(savingsAccount);

		savingsAccount = new Account("005", SAVINGS, 0.0f);
		bank.addAccount(savingsAccount);

		checkingAccount = new Account("006", CHECKING, 0.0f);
		bank.addAccount(checkingAccount);
	}
	
}