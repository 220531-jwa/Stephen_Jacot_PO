package dev.jacot.service;

import java.util.List;

import dev.jacot.controller.ClientController;
import dev.jacot.models.Client;
import dev.jacot.repo.ClientDAO;

/*
 * Class is used where we write methods to perform any business logic that
 * our application needs to function appropriate
 * 
 */

public class ClientService 
{
	private ClientDAO cd = new ClientDAO();
	
	private ClientController cc = new ClientController();
	// login an existing client
	
	public Client createClient(Client c)
	{
		return cd.createClient(c);
	}
	
	public List<Client> getAllClients()
	{
		return cd.getAllClients();
	}

	public Client getClientById(int id) throws Exception
	{
		
		Client c = cd.getClientByID(id);
		
		if(c == null)
		{
			throw new Exception("User not found");
		}
		
		return cd.getClientByID(id);
	}

	public boolean deleteClient(int id)
	{
		if(id >= 0)
		{
			return cd.deleteClient(id);
		}
		
		return false;
		
	}

	public boolean updateClient(Client cChange) 
	{
		if(cChange != null)
		{
			return cd.updateClient(cChange);
		}
		
		
		return false;	
	}
	
	// create a new client and check that client doesn't exist
	

}
