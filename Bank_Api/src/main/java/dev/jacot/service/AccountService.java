package dev.jacot.service;

import java.util.List;

import dev.jacot.models.Account;
import dev.jacot.models.ClientAccounts;
import dev.jacot.repo.AccountDAO;

public class AccountService 
{
	
	AccountDAO ad = new AccountDAO();
	
	public Account createAccount(Account a)
	{
		return ad.createAccount(a);
	}
	
	public List<ClientAccounts> getAllClientAccounts(int id)
	{
		return ad.getAllAccountsByUserId(id);
	}
	
	public ClientAccounts getAccountById(int clientIdentification, int accountNumber)
	{
		return ad.getAccountByID(clientIdentification, accountNumber);
	}
	
	public boolean accountUpdates(int clientIdentification, int accountNumber, float checkingAccountAmount, float savingsAccountAmount)
	{
		return ad.accountUpdates(clientIdentification, accountNumber, checkingAccountAmount, savingsAccountAmount);
	}

	public boolean deleteClientAccount(int clientId, int accountNumber) 
	{
		if(getAccountById(clientId, accountNumber) != null)
		{
			return ad.deleteClientAccount(clientId, accountNumber);
		}
		else 
		{
			return false;
		}
	}

}
