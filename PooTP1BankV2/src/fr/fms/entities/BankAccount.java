package fr.fms.entities;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private long bankAccountId; 
    private String accountType;
    private double balance;
    private long customerId;
    private String date;
    protected List<Transaction> transactions = new ArrayList<Transaction>();

    public BankAccount(long bankAccountId, String accountType, double balance, long customerId, String date, List<Transaction> transactions) {
        this.bankAccountId = bankAccountId;
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;
        this.date = date;
        this.transactions = transactions;
    }

    public BankAccount(long bankAccountId, String accountType, double balance, long customerId, String date) {
        this.bankAccountId = bankAccountId;
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;
        this.date = date;
    }
    
    public List<Transaction> getTransactions() {
		return transactions;
	}

	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}

	@Override
    public String toString() {
        return accountType + "[" + "accountId=" + bankAccountId + ", creationDate=" + date + ", balance=" + balance + "]";
    }

    public long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
