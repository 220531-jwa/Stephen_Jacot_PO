package dev.jacot.models;

public class Account 
{
	
	private float clientCheckingBalance;
	private float clientSavingBalance;
	private int accountNumber;
	private int clientId;
	
	public Account()
	{
		super();
	}
	
	public Account(int accountNumber,int clientId, float checkingBalance, float savingBalance) {
		super();
		this.clientCheckingBalance = checkingBalance;
		this.accountNumber = accountNumber;
		this.clientSavingBalance = savingBalance;
		this.clientId = clientId;
	}

	public float getClientCheckingBalance() {
		return clientCheckingBalance;
	}

	public void setClientCheckingBalance(float clientCheckingBalance) {
		this.clientCheckingBalance = clientCheckingBalance;
	}

	public float getClientSavingBalance() {
		return clientSavingBalance;
	}

	public void setClientSavingBalance(float clientSavingBalance) {
		this.clientSavingBalance = clientSavingBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getClientId()
	{
		return clientId;
	}
	
	public void setClientId(int clientId)
	{
		this.clientId = clientId;
	}


	
	
	
	
	

}
