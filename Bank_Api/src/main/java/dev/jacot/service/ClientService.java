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

	public void deleteClient(int id) throws Exception
	{
		
		Client c = cd.getClientByID(id);
		
		if(c == null)
		{
			throw new Exception("User not found");
		}
		
		cd.deleteClient(id);
		
	}

	public void updateClient(Client cChange) 
	{
	
		cd.updateClient(cChange);		
		
	}
	
	// create a new client and check that client doesn't exist
	

}
