package dev.jacot.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jacot.models.Account;
import dev.jacot.models.ClientAccounts;
import dev.jacot.utils.ConnectionUtil;

public class AccountDAO 
{
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public List<ClientAccounts> getAllAccountsByUserId(int id)
	{
		
		List<ClientAccounts> accounts = new ArrayList<>();
		
		String sql = "select * from bankapp.clients c" + " left join bankapp.accounts a" + " on c.id = a.client_id" +  
		" where c.id = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				accounts.add(new ClientAccounts(
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("account_number"),
						rs.getInt("client_id"),
						rs.getFloat("checking_balance"),
						rs.getFloat("savings_balance")));
			} 
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
			
			return accounts;
			
		
	}
	
	public Account createAccount(Account a)
	{
		String sql = "insert into accounts values (default, ?, ?, ?) returning *";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, a.getClientId());
			ps.setFloat(2, a.getClientCheckingBalance());
			ps.setFloat(3, a.getClientSavingBalance());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				a.setAccountNumber(rs.getInt("account_number"));
				a.setClientId(rs.getInt("client_id"));
				a.setClientCheckingBalance(rs.getFloat("checking_balance"));
				a.setClientSavingBalance(rs.getFloat("savings_balance"));
			}
		
		 }catch (SQLException e)
		{
			 e.printStackTrace();
		}
		
		return a;
	}
	
	public ClientAccounts getAccountByID(int clientIdentification, int accountNumber)
	{
		String sql = "select * from clients as c" + " left join accounts as a" + " on c.id = a.client_id" +  
				" where c.id = ? and a.account_number = ?;";
		
		ClientAccounts accounts = null;
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, accountNumber);
			ps.setInt(2, clientIdentification);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				accounts = new ClientAccounts(
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("account_number"),
						rs.getInt("client_id"),
						rs.getFloat("checking_balance"),
						rs.getFloat("savings_balance"));
						
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	public boolean accountUpdates(int clientIdentification, int accountNumber, float checkingBalance, float savingBalance)
	{
		String sql = "update accounts set checking_balance " + 
				checkingBalance + 
				" , savings_balance" 
				+ " where " 
				+ " account_number = " 
				+ accountNumber +
				" and " 
				+ " client_id = " 
				+ clientIdentification + 
				";";
		
		try (Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int updateAccount = ps.executeUpdate();
			
			if(updateAccount == 0)
			{
				return false;
			} 
			
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean deleteClientAccount(int clientId, int accountNumber) 
	{
		String sql = "delete from bankapp.accounts" 
					+ " where" 
					+ " account_number = ?" 
					+ " and client_id = ?;";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, accountNumber);
			ps.setInt(2, clientId);
			
			if(ps.executeUpdate() == 0)
			{
				return false;
			} else {
				return true;
			}
			
			
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
}
