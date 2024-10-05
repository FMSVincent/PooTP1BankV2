package fr.fms.bankjob;

import fr.fms.entities.BankAccount;
import fr.fms.entities.Customer;

public interface BankIJob {
	void addCustomerToBank(String lastname, String firstname, String email);
	void addAccountToCustomer( Customer customer, BankAccount bankAccount);
	Customer findCustomer(long customerId);
	void getListBankAccount();
	boolean makeDeposit(long bankAccountId, double amount);
	boolean makeTransfer(int amount, int fromAccountId, int toAccountId);
	boolean makeWithdrawal(double amountWithdrawal, int bankAccountId);
	void getListTransaction();
	void addTransaction(double amount, String accountType, BankAccount account);
	void getListTransactionByClient(long customerId);
}
