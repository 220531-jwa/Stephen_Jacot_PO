package dev.jacot.repo;

/* DAO Design Pattern
 * 
 * 
 * DAO = Data Access Object
 * This class defines the methods to be used to
 * interact with the database
 * 
 */

import java.util.*;

import dev.jacot.models.Client;
import dev.jacot.utils.MockDB;



public class MockClientDAO 
{
	
	/*
	 * CRUD Methods
	 * 
	 * Create 
	 * 	- (used to register a new client)
	 * 
	 * Read
	 *  - search for existing clients, check credentials, list all clients
	 * 
	 * Update - update an existing record
	 * 		-i.e. user wants to change their password
	 * 
	 * Delete
	 * 
	 *  -i.e. user deletes their account
	 * 
	 */
	
	
	// Read
	
	//List all clients in DB
	
	public List<Client> getAllClients()
	{
		return MockDB.clients;
	}
	
	public Client getUserByID(int id)
	{
		for(Client c : MockDB.clients)
		{
			if(id == c.getId())
			{
				return c;
			} else 
			{
				System.out.println("Client not found");
				return null;
			}
		}
		
		Client c = MockDB.clients.get(id-1);
		
		return c;
	}
	
	public Client createClient(Client c)
	{
		MockDB.clients.add(c);
		
		return c;
	}

	public Client getUserByUsername(String username) 
	{
		for(Client c : MockDB.clients)
		{
			if(c.getUsername().equals(username))
			{
				return c;
			}
		}
		return null;
	}
	
	

}
