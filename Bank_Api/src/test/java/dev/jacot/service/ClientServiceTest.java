package dev.jacot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.jacot.models.Client;
import dev.jacot.repo.ClientDAO;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest 
{
	@InjectMocks
	private static ClientService clientService;
	
	@Mock
	private static ClientDAO mockClientDAO;
	
	@BeforeAll
	public static void setUp()
	{
		clientService = new ClientService();
		mockClientDAO = mock(ClientDAO.class);
	}
	
	@Test
	public void should_ReturnAllClients()
	{
		//given
		List<Client> clients = new ArrayList<>();
		
		clients.add(new Client(1, "stephen", "jacot", "jacotste"));
		clients.add(new Client(2, "stephen", "jacot", "jacotste"));
		clients.add(new Client(3, "stephen", "jacot", "jacotste"));
		
		//when
		when(mockClientDAO.getAllClients()).thenReturn(clients);
		//then
		
		assertEquals(clients, clientService.getAllClients());
	}
	
	

}
