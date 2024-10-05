package fr.fms.entities;

import java.util.List;

public class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(long bankAccountId, double balance, long customerId, String date, double interestRate, List<Transaction> transactions) {
        super(bankAccountId, "SavingAccount", balance, customerId, date, transactions);
        this.interestRate = interestRate;
    }
    
    public SavingAccount(long bankAccountId, double balance, long customerId, String date, double interestRate) {
        super(bankAccountId, "SavingAccount", balance, customerId, date);
        this.interestRate = interestRate;
    }


    @Override
    public String toString() {
        return super.toString() + ", InterestRate= " + interestRate+"\n";
    }
    
    public List<Transaction> getTransactions() {
    	return transactions;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
