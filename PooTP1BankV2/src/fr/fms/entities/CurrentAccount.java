package fr.fms.entities;

import java.util.List;

public class CurrentAccount extends BankAccount {
    private double overDraft; 

    public CurrentAccount(long bankAccountId, double balance, long customerId, String date, double overDraft, List<Transaction> transactions) {
        super(bankAccountId, "CurrentAccount", balance, customerId, date, transactions);
        this.overDraft = overDraft;
    }
    
    public CurrentAccount(long bankAccountId, double balance, long customerId, String date, double overDraft) {
        super(bankAccountId, "CurrentAccount", balance, customerId, date);
        this.overDraft = overDraft;
    }

    @Override
    public String toString() {
        return super.toString() + ", Overdraft= " + overDraft + "\n";
    }
    
    public List<Transaction> getTransactions() {
    	return transactions;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }
}
