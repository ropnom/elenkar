package Ropnom.elenkar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import oauth.BasicAuthenticationSession;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

public class SignInPage extends WebPage {

	private static final long serialVersionUID = 7186942627212111030L;

	public SignInPage(PageParameters parameters) {
		super(parameters);
		add(new HeaderPanel("barra"));
		//add(new BookmarkablePageLink<Object>("leermas", HeaderExplicacion.class));			
		
//		add(new FooterPanel("footer"));
	}

}