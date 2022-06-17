package dev.jacot.models;

public class ClientAccounts
{
	Client client = new Client();
	
	Account account = new Account();
	
	private String clientFirstName;
	private String clientLastName;
	private int accountId;
	private int clientId;
	private float checkingBalance;
	private float savingBalance;
	
//	public ClientAccounts()
//	{
//		this.clientFirstName = client.getFirstName();
//		this.clientLastName = client.getLastName();
//		this.accountId = account.getAccountNumber();
//		this.clientId = client.getId();
//		this.checkingBalance = account.getClientCheckingBalance();
//		this.savingBalance = account.getClientSavingBalance();
//	}
	
	public ClientAccounts(String clientFirstName, String clientLastName, int accountId, int clientId,
			float checkingBalance, float savingBalance) 
	{
		this.clientFirstName = clientFirstName;
		this.clientLastName = clientLastName;
		this.accountId = accountId;
		this.clientId = clientId;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public float getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(float checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public float getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(float savingBalance) {
		this.savingBalance = savingBalance;
	}

	@Override
	public String toString() {
		return "ClientAccounts [clientFirstName=" + clientFirstName + ", clientLastName=" + clientLastName
				+ ", accountId=" + accountId + ", clientId=" + clientId + ", checkingBalance=" + checkingBalance
				+ ", savingBalance=" + savingBalance + "]";
	}
	
	
	
	

}
