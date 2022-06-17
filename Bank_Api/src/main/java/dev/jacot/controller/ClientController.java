package dev.jacot.controller;

import java.util.List;

import dev.jacot.models.Client;
import dev.jacot.service.ClientService;
import io.javalin.http.Context;

public class ClientController 
{
	
	private static ClientService cs = new ClientService();
	
	
	public static void getAllClients(Context ctx)
	{
		ctx.status(200);
		
		List<Client> client = cs.getAllClients();
		
		ctx.json(client); // Marshalling
		
	}
	
	public static void createNewClient(Context ctx)
	{
		ctx.status(201);
		
		Client clientFromRequestBody = ctx.bodyAsClass(Client.class);
		Client c = cs.createClient(clientFromRequestBody);
		ctx.json(c);
	}
	
	public static void getClientById(Context ctx)
	{
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		Client c = null;
		
		try {
			c = cs.getClientById(id);
			
			ctx.status(200);
			
			ctx.json(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ctx.status(404);
			
			ctx.result("Client not found");
			
			//e.printStackTrace();
		}
		
		
	}
	
	public static void deleteClient(Context ctx)
	{
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		boolean succeeded = cs.deleteClient(id);
		
		if(!succeeded)
		{
			ctx.status(404);
		}
		else
		{
			ctx.status(205);
		}
		
		//ctx.json(c);
		
	}
	
	public static void updateClient(Context ctx)
	{
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		Client cChange = ctx.bodyAsClass(Client.class);//unmarshalling
		
		cChange.setId(id);
		
		boolean success = cs.updateClient(cChange);
		
		if(!success)
		{
			ctx.status(404);
		}
		else
		{
			ctx.status(205);
		}
	}

}
