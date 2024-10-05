package fr.fms.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private long customerId;
	private String firstname;
	private String lastname;
	private String email;

	private List<BankAccount> listAccount = new ArrayList<BankAccount>();


	public Customer(long customerId2, String firstname, String lastname, String email, List<BankAccount> listAccount) {
		this.customerId = customerId2;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.listAccount = (listAccount!= null) ? listAccount : new ArrayList<BankAccount>();
	}
	
    public Customer(long customerId, String firstname, String lastname, String email) {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.listAccount = new ArrayList<>();
    }
    
	@Override
	public String toString() {
		return "Customer [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + " ID="+ customerId+ "] \n";
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<BankAccount> getListAccount() {
		return listAccount;
	}
	
	public void setListAccount( BankAccount bankAccount) {
		this.listAccount.add(bankAccount);
	}
	
}
