package fr.fms.bankjob;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fr.fms.entities.BankAccount;
import fr.fms.entities.BankCasaDelPaPel;
import fr.fms.entities.CurrentAccount;
import fr.fms.entities.SavingAccount;
import fr.fms.entities.Transaction;
import fr.fms.entities.Customer;

public class BankJobImpl implements BankIJob {
	
	public void addCustomerToBank(String lastname, String firstname, String email) {
		long customerId = (long) (Math.random() * 100000)+1;
		Customer customer = new Customer(customerId, firstname, lastname, email, null);
		BankCasaDelPaPel.setCustomers(customer);
		System.out.println(BankCasaDelPaPel.getCustomers());
	}
	
	public void getListTransactionByClient(long customerId) {
			Customer customer = findCustomer(customerId);
			if(customer.getListAccount().size() > 0) {
				for (BankAccount account : customer.getListAccount()) {
					System.out.println(account.getTransactions());
			}
		}
	}
	
	public void getListTransaction() {
		if(BankCasaDelPaPel.getCustomers().size() < 1) {
			System.out.println("pas de client");
			return;
		} 
		for (Customer customer : BankCasaDelPaPel.getCustomers()) {
			if(customer.getListAccount().size() > 0) {
				for (BankAccount account : customer.getListAccount()) {
					System.out.println(account.getTransactions());
				}
			}
		}
	}

	public void addAccountToCustomer(Customer customer, BankAccount bankAccount) {
		    customer.setListAccount(bankAccount);
	}
	
	public boolean makeDeposit(long bankAccountId, double amount) {
		if (amount <= 0) {
			System.out.println("Le montant doit être supérieur à 0");
			return false;
		}
		List<Customer> customers = BankCasaDelPaPel.getCustomers();
		for(Customer customer : customers) {
			for(BankAccount account : customer.getListAccount()) {
				if(account.getBankAccountId() == bankAccountId) {
					account.setBalance(account.getBalance() + amount);
					//System.out.println("Le nouveau solde est : " + account.getBalance() + "€");

					addTransaction(amount, "Versement", account);
					
					return true;
				}
			}
		}
		System.out.println("Compte non trouvé pour l'ID :" + bankAccountId);
		return false;
	}
	 

	public boolean makeWithdrawal(double amountWithdrawal, int bankAccountId) {
		List<Customer> customers = BankCasaDelPaPel.getCustomers();
		for (Customer customer : customers) {
			for (BankAccount account : customer.getListAccount()) {

				if (account.getBankAccountId() == bankAccountId) {
					if (account instanceof CurrentAccount) {
						CurrentAccount currentAccount = (CurrentAccount) account;
						currentAccount.getOverDraft();
						if ((currentAccount.getBalance() + currentAccount.getOverDraft()) >= amountWithdrawal) {
							account.setBalance(account.getBalance() - amountWithdrawal);

							addTransaction(amountWithdrawal, "retrait", account);

							return true;
						} else {
							System.err.println("Vous avez dépassé vos capacités de retrait");
							return false;
						}

					} else if (account instanceof SavingAccount) {
						SavingAccount savingAccount = (SavingAccount) account;
						if (savingAccount.getBalance() >= amountWithdrawal) {
							savingAccount.setBalance(savingAccount.getBalance() - amountWithdrawal);
							return true;
						}
						else {
							System.err.println("Vous avez dépassé vos capacités de retrait");
							return false;
						}
					}
				}
			}
		}
		return false;
	}



	public boolean makeTransfer(int amount, int fromAccountId, int toAccountId) {
		if(fromAccountId == toAccountId) {
			System.err.println("vous ne pouvez retirer et verser sur le meme compte");
			return false;
		}
		List<Customer> customers = BankCasaDelPaPel.getCustomers();
		
		BankAccount fromAccount = null;
		BankAccount toAccount = null;
		
		for (Customer customer : customers) {
			for (BankAccount account : customer.getListAccount()) {
				if(account.getBankAccountId() == fromAccountId) {
					fromAccount = account;
				}
			}
		}
		
		for (Customer customer : customers) {
			for (BankAccount account : customer.getListAccount()) {
				if(account.getBankAccountId() == toAccountId) {
					toAccount = account;
				}
			}
		}
		
		if(fromAccount == null || toAccount == null) {
			System.err.println("Un ou les deux comptes n'existent pas.");
			return false;
		}
		if(fromAccount instanceof CurrentAccount) {
			CurrentAccount fromCurrentAccount = (CurrentAccount)fromAccount;
			fromCurrentAccount.getOverDraft();
			if(fromAccount.getBalance() + fromCurrentAccount.getOverDraft() >= amount) {
			
			fromAccount.setBalance(fromAccount.getBalance()  - amount);
			
			addTransaction(amount, "virement envoyé", fromAccount);
			
			toAccount.setBalance(toAccount.getBalance() + amount);
			
			addTransaction(amount, "virement reçu", toAccount);
			
			
			return true;
		}
		else {
			System.err.println("Fonds insuffisants sur le compte à débiter");
			return false;
		}
			
		}else {
			if(fromAccount.getBalance() >= amount) {
				
				fromAccount.setBalance(fromAccount.getBalance()  - amount);
				
				toAccount.setBalance(toAccount.getBalance() + amount);
				
				return true;
			}
			else {
				System.err.println("Fonds insuffisants sur le compte à débiter");
				return false;
			}
		}
		
	}
	
	public Customer findCustomer(long customerId) {
		List<Customer> customers = BankCasaDelPaPel.getCustomers();
		for (Customer customer : customers) {
			if (customer.getCustomerId() == customerId) return customer;
		}
		System.err.println("Compte inexistant !");
		return null;
	}
	
	public void getListBankAccount() {
		for (Customer customer : BankCasaDelPaPel.getCustomers()) {
			if(customer.getListAccount().size() > 0) {
				System.out.println(customer.getListAccount());
				System.out.println(customer);
			}
			else {
				System.out.println("Pas de compte");
			}
		}
	}
	public void addTransaction(double amount,String transactionType,BankAccount account) {
		Date today = new Date();

		String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(today);
		long transactionId = (long) (Math.random() * 100000)+1;

		Transaction transaction = new Transaction(transactionId, amount, formattedDate, transactionType, account.getBankAccountId());
		account.addTransaction(transaction);
	}
}
