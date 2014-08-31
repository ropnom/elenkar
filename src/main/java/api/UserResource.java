package api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import manager.ManagerImplement;
import modelo.User;

import com.google.gson.Gson;

@Path("/users")
public class UserResource  {

	// PArametros
	User userto;
	ManagerImplement man = ManagerImplement.getInstance();
	
	// URL y seguridad??
	@Context
	private UriInfo uriInfo;
	@Context
	private SecurityContext security;

}
