package Ropnom.elenkar;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.string.Strings;

//Creamos un panel nuevo demoment sin propiedades especiales
public class HeaderPanel extends Panel {

	private static final long serialVersionUID = 29327161501311707L;
	private String usuario;
	private String password;

//	BasicAuthenticationSession session = (BasicAuthenticationSession) AuthenticatedWebSession.get().getAttribute("session");

	public HeaderPanel(String id) {
		super(id);
		Form<?> form = new Form<Object>("login") {

			private static final long serialVersionUID = 9048463199122915990L;

			// cuando se hace click en el boton login
			@Override
			protected void onSubmit() {
				
				System.out.println("EL boton se ejecuta");
				// check de si el username o passw esta vacio
				if (Strings.isEmpty(usuario) || Strings.isEmpty(password))
					return;
				System.out.println("Antes de loguear");
				// Si la autenticacion es correcta redirige a la pagina original
				if (AuthenticatedWebSession.get().signIn(usuario, password))
					continueToOriginalDestination();
			}
		};
		form.setDefaultModel(new CompoundPropertyModel<HeaderPanel>(this));
		form.add(new TextField<Object>("usuario"));
		form.add(new PasswordTextField("password"));
		add(form);
		
		add(new BookmarkablePageLink<Object>("reg", HomePage.class));
		add(new BookmarkablePageLink<Object>("que_es", HomePage.class));
		add(new BookmarkablePageLink<Object>("porque", HomePage.class));
		add(new BookmarkablePageLink<Object>("indice", SignInPage.class));
	}
}
