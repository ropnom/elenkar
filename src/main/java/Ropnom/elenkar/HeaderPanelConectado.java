package Ropnom.elenkar;

import manager.ManagerImplement;
import oauth.BasicAuthenticationSession;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

//Creamos un panel nuevo demoment sin propiedades especiales
public class HeaderPanelConectado extends Panel {

	private static final long serialVersionUID = 29327161501311707L;

	public HeaderPanelConectado(String id) {
		super(id);
		
		//Introducimos los datos del usuario dentro de una label en el header.
		BasicAuthenticationSession session = (BasicAuthenticationSession) AuthenticatedWebSession.get().getAttribute("session");
		add(new Label("usuario", session.getUsername()));
		
		//??¿¿
		add(new BookmarkablePageLink<Object>("inicioViewer", HomePage.class));


		//Añadimos links a diferentes paginas desde el header
		
//		add(new Link<Object>("mejoresPosts") {
//			private static final long serialVersionUID = -4093775456613510984L;
//
//			@Override
//			public void onClick() {
//				PageParameters pageParameters = new PageParameters();
//				pageParameters.add("order", "mejores");
//				setResponsePage(HomePage.class, pageParameters);
//			}
//		});
//
//		add(new Link<Object>("peoresPosts") {
//			private static final long serialVersionUID = -4094778856613510984L;
//
//			@Override
//			public void onClick() {
//				PageParameters pageParameters = new PageParameters();
//				pageParameters.add("order", "peores");
//				setResponsePage(HomePage.class, pageParameters);
//			}
//
//		});
//
//		add(new Link<Object>("comentadosPosts") {
//			private static final long serialVersionUID = -4093778056613510984L;
//
//			@Override
//			public void onClick() {
//				PageParameters pageParameters = new PageParameters();
//				pageParameters.add("order", "mascomentados");
//				setResponsePage(HomePage.class, pageParameters);
//			}
//
//		});
//
//		add(new Link<Object>("salir") {
//			private static final long serialVersionUID = -4093778856613510984L;
//
//			@Override
//			public void onClick() {
//				getSession().invalidate();
//			}
//		});
//		
//		add(new Link<Object>("conectado") {
//			private static final long serialVersionUID = -46454513510984L;
//
//			@Override
//			public void onClick() {
//				setResponsePage(SalaConectadoPage.class);
//			}
//
//		});
//		add(new Link<Object>("listasalas") {
//			private static final long serialVersionUID = -4643454353510984L;
//
//			@Override
//			public void onClick() {
//				setResponsePage(SalaPage.class);
//			}
//
//		});
//		add(new Link<Object>("invitaciones") {
//			private static final long serialVersionUID = -423423413510984L;
//
//			@Override
//			public void onClick() {
//				setResponsePage(SalaPage.class);
//			}
//
//		});
//		add(new Link<Object>("missalas") {
//			private static final long serialVersionUID = -463452310984L;
//
//			@Override
//			public void onClick() {
//				setResponsePage(SalaPage.class);
//			}
//
//		});
//		add(new Link<Object>("perfil") {
//			private static final long serialVersionUID = -46344552310984L;
//
//			@Override
//			public void onClick() {
//				setResponsePage(PerfilPage.class);
//			}
//
//		});

	


	}
}
