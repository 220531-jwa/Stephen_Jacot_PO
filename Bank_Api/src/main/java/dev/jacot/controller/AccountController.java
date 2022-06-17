package dev.jacot.controller;

import java.util.List;

import dev.jacot.models.Account;
import dev.jacot.models.Client;
import dev.jacot.models.ClientAccounts;
import dev.jacot.repo.AccountDAO;
import dev.jacot.service.AccountService;
import dev.jacot.service.ClientService;
import io.javalin.http.Context;

public class AccountController 
{
	private static AccountService as = new AccountService();
	
	
	private static ClientService cs = new ClientService();
	public static void createNewAccount(Context ctx)
	{
		Account accountFromRequestBody = ctx.bodyAsClass(Account.class);
		Account a = as.createAccount(accountFromRequestBody);
		
		if(a != null)
		{
			ctx.status(201);
			
			ctx.json(a);	
		}
		else
		{
			ctx.status(404);
		}
	}
	
	public static void getAllAccounts(Context ctx)
	{
		int clientid = Integer.parseInt(ctx.pathParam("id"));
		
		Client client = null;
		
		try {
			client = cs.getClientById(clientid);
			
			if(client != null)
			{
				ctx.status(200);
				
				List<ClientAccounts> ca = as.getAllClientAccounts(clientid);
				
				ctx.json(ca);
			}
		} catch (Exception e) 
		{
			ctx.status(404);
			
			ctx.result("Account not found");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	public static void getAccountByID(Context ctx)
	{
		int clientId = Integer.parseInt(ctx.pathParam("id"));
		int accountNumber = Integer.parseInt(ctx.pathParam("account_number"));
		
		ClientAccounts accounts = null;
		
		try {
			accounts = as.getAccountById(clientId, accountNumber);
			
			if(accounts != null)
			{
				ctx.status(200);
				ctx.json(accounts);
			}
			else
			{
				ctx.status(404);
			}
			
		} catch(Exception e) 
		{
		  ctx.status(404);
		  ctx.result("Account id not found.");
		}
	}
	
	public static void accountUpdates(Context ctx)
	{
		AccountDAO ad = new AccountDAO();
		
		int accountNumber = Integer.parseInt(ctx.pathParam("account_number"));
		
		int clientId = Integer.parseInt(ctx.pathParam("id"));
		
		float checkBalance = ad.getAccountByID(accountNumber,clientId).getCheckingBalance();
		
		float savingsBalance = ad.getAccountByID(clientId, accountNumber).getSavingBalance();
		
		boolean updatedAccount = as.accountUpdates(clientId, accountNumber, checkBalance, savingsBalance);
		
		if(!updatedAccount)
		{
			ctx.status(404);
		}
		else
		{
			ctx.status(200);
		}
	}
	
	public static void deleteClientAccount(Context ctx) {
		int accountNumber = Integer.parseInt(ctx.pathParam("account_number"));
		int clientId = Integer.parseInt(ctx.pathParam("id"));
		boolean deletedAccount = as.deleteClientAccount(clientId, accountNumber);
		
		try { 
			if(as.deleteClientAccount(clientId, accountNumber))
			{
				ctx.status(205);
			}
			else
			{
				ctx.status(400);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
