package edu.escuelaing.arep.controller;

import static spark.Spark.*;
import org.eclipse.jetty.util.security.Password;
import edu.escuelaing.arep.services.UserService;
import com.google.gson.Gson;
import java.security.*;
import java.math.*;

import edu.escuelaing.arep.model.User;


/**
 * Hello world!
 *
 */
public class SecureWebApp 
{
    public static void main( String[] args )
    {
    	port(getPort());
    	staticFiles.location("/web");
    	//API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
    	//secure("target/test-classes/ecikeystore.p12", "vale2020", null, null); 
    	
    	get("/hello", (req, res) -> "Hello World"); 
    	
    	post("/signUp", (request, response) -> {
		    response.type("application/json");
		    User user = new Gson().fromJson(request.body(), User.class);
		    UserService.registry(user);
		 
		    return new Gson().toJson(
				      new StandardResponse(StatusResponse.SUCCESS));
		}); 
    	
    	get("/login/:username/:password", (request, response) -> {
		    response.type("application/json");
		    User user = new User(request.params(":password"), request.params(":username"));
		    return new Gson().toJson(
		      new StandardResponse(StatusResponse.SUCCESS
		    		  ,new Gson()
		        .toJsonTree(UserService.verifyUser(user))
		        ));
		});
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}

