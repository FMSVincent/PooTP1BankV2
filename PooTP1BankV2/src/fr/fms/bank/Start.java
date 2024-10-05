package fr.fms.bank;

import fr.fms.bankjob.BankJobImpl;
import fr.fms.entities.BankAccount;
import fr.fms.entities.BankCasaDelPaPel;
import fr.fms.entities.CurrentAccount;
import fr.fms.entities.Customer;
import fr.fms.entities.SavingAccount;

public class Start {

	public static void main(String[] args) {
		// init job
		BankJobImpl job = new BankJobImpl();
		
		// init object customer
		Customer client1 = new Customer(1, "Tokyo", "oiveira", "tokyo.oliveira@mail.com");
		Customer client2 = new Customer(2, "El professor", "alvaro", "professor.alvaro@mail.com");
		
		// init account client 1
		CurrentAccount currentAccountClient1 = new CurrentAccount(1, 54514.00, client1.getCustomerId(), "20-08-2024", 500);
		client1.setListAccount(currentAccountClient1);

		
		// init account client 2
		SavingAccount savingAccountClient2 = new SavingAccount(3, 400, client2.getCustomerId(), "14-12-01", 5.5);
		client2.setListAccount(savingAccountClient2);
		
		// init bank customer
		BankCasaDelPaPel.setCustomers(client1);
		BankCasaDelPaPel.setCustomers(client2);
		
		// display balance client 1
		System.out.println("----------solde----------");
		for (BankAccount client1Account : client1.getListAccount()) {
			System.out.println("solde de " + client1.getFirstname()+" : " +client1Account.getBalance());
		}
		
		// display balance client 2
		for (BankAccount client2Account : client2.getListAccount()) {
			System.out.println("solde de " + client2.getFirstname()+" : " +client2Account.getBalance());
		}
		
		System.out.println();
		
		// test
		System.out.println("----------test----------");
		job.findCustomer(5);
		job.makeWithdrawal(100000, 1);
		job.makeTransfer(400, 1, 1); 
		
		System.out.println();
		
		// init saving account client 1
		SavingAccount savingAccountClient1 = new SavingAccount(2, 400, client1.getCustomerId(), "14-12-01", 5.5);
		client1.setListAccount(savingAccountClient1);
		
		// display accounts
		System.out.println("----------Liste des comptes de ma banque----------");
		job.getListBankAccount();
		
		System.out.println();
		
		// display account by id
		Customer customer =  job.findCustomer(1);
		System.out.println("----------Liste des comptes de " + customer.getFirstname() + " utilisateur----------");
		for (BankAccount customerAccount : customer.getListAccount()) {
			System.out.println(customerAccount);
		}
		
		System.out.println();
		
		// init transactions and display
		System.out.println("----------Liste des transactions de "+ client2.getFirstname() +"----------");
		job.makeDeposit(3, 400); // versement
		job.getListTransactionByClient(client2.getCustomerId());
		
		
	}
}
