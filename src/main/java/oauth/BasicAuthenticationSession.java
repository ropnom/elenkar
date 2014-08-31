package oauth;

import manager.ManagerImplement;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class BasicAuthenticationSession extends AuthenticatedWebSession {

	private static final long serialVersionUID = 7953549683123734608L;
	// Aqui guardamos los parametros en las sisiones
	private String username;
	private int requestedID;	
	ManagerImplement mi = ManagerImplement.getInstance();



	public int getRequestedID() {
		return requestedID;
	}

	public void setRequestedID(int requestedID) {
		this.requestedID = requestedID;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserid() {
		return userid;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	private int userid;
	private boolean isAdmin;

	public static BasicAuthenticationSession get() {
		return (BasicAuthenticationSession) Session.get();
	}

	public BasicAuthenticationSession(Request request) {
		super(request);
	}

	// realiza la funcionde autenticacion
	@Override
	public boolean authenticate(String username, String password) {
		boolean authResult = false;
		System.out.println("LLEGA A LODE AUTENTICAR in...");
		System.out.println(username);
		System.out.println(password);
		System.out.println("Esto es lo que tenemso ants de comprobar si el password es bueno");
		if (password != null) {
			authResult = mi.SignIn(username, password);
			System.out.println("Logging in...");
			if (authResult) {
				this.username = username;
				this.userid = mi.getUser(username).getIdentificador();
				this.isAdmin = mi.isAdmin(username);
				System.out.println(username + " (" + userid + ")");
				if (this.isAdmin)
					System.out.println("User is Admin.");
			}
		}
		
		
		return authResult;
	}

	// devuelve los roles ... ahora mismo ninguno
	@Override
	public Roles getRoles() {
		Roles resultRoles = new Roles();
		if (isAdmin) {
			resultRoles.add(Roles.ADMIN);
			resultRoles.add("SIGNED_IN");
		} else if (isSignedIn())
			resultRoles.add("SIGNED_IN");
		else
			resultRoles.add("NOT_LOGGED");
		return resultRoles;
	}

}
