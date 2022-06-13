package dev.jacot.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jacot.models.Client;
import dev.jacot.utils.ConnectionUtil;

public class ClientDAO 
{
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	
	public List<Client> getAllClients()
	{
		// CREATE AN EMPTY ARRAY LIST THAT WILL HOLD ALL THE USERS RETURNED FROM THE DATABASE
		List<Client> clients = new ArrayList<>();
		
		// SQL STATEMENT TO EXECUTE
		String sql = "select * from clients";
		
		
		// try with resources - this will auto close any resources we need without a finally block
		
		try(Connection conn = cu.getConnection()) {
			
			// prepare our statement using the connection object
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			// Breaks down each record into a cursor
			// execute our statement and store the result set in a reference variable
			ResultSet rs = ps.executeQuery();
			
			// We need to iterate over a result set in order to take the value from each column to create an object.
			while(rs.next())
			{
				
				int id = rs.getInt("id");
				
				String firstName = rs.getString("first_name");
				
				String lastName = rs.getString("last_name");
				
				String username = rs.getString("username");
				
				
				Client c = new Client(id, firstName, lastName, username);
				
				clients.add(c);
			}
			
			return clients;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public Client getClientByID(int id)
	{
		String sql = "select * from clients where id = ?"; // This symbolizes an in parameter for our statement
		
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id); //Here we are setting the question mark to be the int Id that is set into this method as an argument
			
			ResultSet rs = ps.executeQuery();
			
			//if a result set has a row/record
			if(rs.next())
			{
				return new Client(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Client createClient(Client c)
	{
		String sql = "insert into clients values (default, ?, ?, ?) returning *";
		
		try (Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return new Client(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"));	
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public Client getUserByUsername(String username) 
	{
		return null;
	}
	
	public void updateClient(Client c)
	{
		String sql = "update clients set first_name = ?, last_name = ?, username = ?, where id = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getUsername());
			ps.setInt(4, c.getId());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Client deleteClient(int id)
	{
		String sql = "delete from clients where id = ?";
		
		try (Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.execute();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
