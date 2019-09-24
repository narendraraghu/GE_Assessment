package com.ge.exercise3;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {

	private static final String CHECKING = "Checking";

	private static final String SAVINGS = "Savings";

	private static final Logger LOGGER = LogManager.getLogger(Account.class);

	private float monthlyInterestRate;

	private float monthlyFee;

	private String accountNumber;

	private String accountType;

	private float balance;

	private float nexMonthValue;


	public Account(String accountNumber, String accountType, float balance) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;

		if (accountType.equals(SAVINGS)) {
			monthlyInterestRate = 1.0f;
		}
	}  

	public Account(String accountNumber, String accountType) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance =  0.0f;

		if (accountType.equals(SAVINGS)) {
			monthlyInterestRate = 1.0f;
		}
	}

	public Account(String accountNumber) {

		this.accountNumber = accountNumber;
		this.accountType = SAVINGS;
		this.balance =  0.0f;
		monthlyInterestRate = 1.0f;
	}


	public void deposit(float amount) {
		balance += amount;
	}

	public float withdraw(float amount) {
		float overdrawnAmt = balance-amount;
		if(accountType.equals(CHECKING) && overdrawnAmt >= -100){
			balance -= amount;
		}else if(accountType.equals(SAVINGS) && overdrawnAmt >= 0){
			balance -= amount;
		}else{
			LOGGER.info("Not having sufficient balance to withdraw!!! Your current account Balance is: "+ balance);
			overdrawnAmt=0;
		}
		return overdrawnAmt;
	}

	public float getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(float monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public float getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(float monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getBalance() {
		return balance;
	}

	void setBalance(float balance) {
		this.balance = balance;
	}

	public float getNextMonthValue() {
		return nexMonthValue;
	}

	public void setNexMonthValue(float nexMonthValue) {
		this.nexMonthValue = nexMonthValue;
	}

	public float valueNextMonth() {
		return balance+(((balance * monthlyInterestRate)/100) - monthlyFee);
	}
	public float calNextMonthValue() {
		setNexMonthValue(balance+(((balance * monthlyInterestRate)/100) - monthlyFee));
		return getNextMonthValue();
	}
	
	@Override
	public int hashCode() {
		return accountNumber.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}

	@Override
    public String toString() {
      if (accountType.equals(CHECKING)) {
            if (monthlyFee == 0.0f) {
                return "No fee checking account #" + accountNumber;
            } else {
                return "Checking account #" + accountNumber;
            }
        } else {
            if (monthlyInterestRate > 1.01) {
                if (monthlyFee == 0.0f) {
                    return "High interest no fee savings account #" + accountNumber;
                } else {
                    return "High interest savings account #" + accountNumber;
                }
            } else {
                if (monthlyFee == 0.0f) {
                    return "No fee savings account #" + accountNumber;
                } else {
                    return "Savings account #" + accountNumber;
                }
            }
        }

    }
}
