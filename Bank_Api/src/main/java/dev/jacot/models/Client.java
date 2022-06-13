package dev.jacot.models;

public class Client 
{
	
	private String username;
	
	private String lastName;
	
	private String firstName;
	
	private int id;
	
	public Client()
	{
		
	}
	
	public Client(int id, String firstName, String lastName, String username)
	{
		this.id = id;
		
		this.username = username;
		
		this.firstName = firstName;
		
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() 
	{
		return "Client [username=" + username + ", lastName=" + lastName + ", firstName=" + firstName + ", id=" + id
				+ "]";
	}

	

}
