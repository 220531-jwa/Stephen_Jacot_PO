import java.nio.file.Path;
import java.util.List;

import dev.jacot.models.Client;
import dev.jacot.repo.MockClientDAO;
import dev.jacot.service.ClientService;
import static io.javalin.apibuilder.ApiBuilder.*;

import dev.jacot.controller.*;
import io.javalin.Javalin;

public class Bank_Demo {

	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Javalin app = Javalin.create();
		
		app.start(9400);
		
		app.routes(() -> {
			path("/clients", () -> {
			get(ClientController::getAllClients);
			post(ClientController::createNewClient);
			path("/{id}", () -> {
				get(ClientController::getClientById);
				delete(ClientController::deleteClient);
				put(ClientController::updateClient);
				path("/accounts", () -> {
					post(AccountController::createNewAccount);
					get(AccountController::getAllAccounts);
				path("/{account_number}", () -> {
					get(AccountController::getAccountByID);
					put(AccountController::accountUpdates);
					delete(AccountController::deleteClientAccount);
					
				});
				});
				});
			});
		});
		
		app.exception(Exception.class, (e,ctx) -> {
			ctx.status(404);
			
			ctx.result("not found");
			
			
		});
		
		//lambdas - introduced functional programming to Java
		
		//(parameter) -> { implementation}
		
	}

}
