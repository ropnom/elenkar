package Ropnom.elenkar;

import oauth.BasicAuthenticationSession;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketApplication extends AuthenticatedWebApplication {
	@Override
	protected void init() {
		// Aqui podemos personalizar la direccion de las paginas.
		mountPage("/Home/${order}", HomePage.class);
		mountPage("/login", SignInPage.class);
		super.init();
	}

	public Class<? extends WebPage> getHomePage() {
		// Lleva a la pagina de principal YA LOGUEADO
		return HomePage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		// Realiza la autenticacion
		return BasicAuthenticationSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		// Lleva a la pagina principal NO LOGUEADO
		return SignInPage.class;
		// return Register_Page.class;
	}
	

}
