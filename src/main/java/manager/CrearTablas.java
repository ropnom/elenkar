package manager;

import java.util.Date;

import modelo.Cliente;
import modelo.Hotel;
import modelo.Inmueble;
import modelo.Propietario;
import modelo.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CrearTablas {

	public static void main(String[] args) {
		System.out.println("ARRANCOOO\n\n\n\n\n***********\n\n\n\n\n***********\n\n\n\n\n***********");
		Arranque();
	}

	public static void Arranque() {

		// Creamos las tablas
		AnnotationConfiguration config = new AnnotationConfiguration();

		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Inmueble.class);
		config.addAnnotatedClass(Hotel.class);

		config.addAnnotatedClass(Propietario.class);
		config.addAnnotatedClass(Cliente.class);

		config.configure();

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session sesion = factory.getCurrentSession();

		LLenardatabase(sesion);

	}

	private static void LLenardatabase(Session sesion) {
		sesion.beginTransaction();

		User usr1 = new User("Administrador", "Administrador", "Admin", "admin@elenkar.es");
		User usr2 = new User("Rodrigo", "Rodrigo", "Rodrigo Sampedro Casis", "ropnom5291@gmail.es");
		User usr3 = new User("Ari", "Ari", "Ariadna Zafra Rubio", "ariadna@elenkar.es");
		User usr4 = new User("Ilia", "Ilia", "Ilia", "ilia@elenkar.es");
		User usr5 = new User("Elena", "Elena", "Elena Bondarenko", "elena@elenkar.es");

		sesion.save(usr1);
		sesion.save(usr2);
		sesion.save(usr3);
		sesion.save(usr4);
		sesion.save(usr5);

		Cliente cl1 = new Cliente("Servoy", "977456123", "632896742", "sergay@millonarios.es", 13000000, 1000000, true, true, false, "De alto estanding pero barato", "Tratar muy bien, muy exigente, racanea mucho", new Date(2014, 8, 15), new Date(2014, 9, 15));
		Cliente cl2 = new Cliente("Esquimal", "977676123", "632899742", "esquimal@millonarios.es", 1300000, 100000, true, true, false, "Palurdo completo, quiere compar no tiene dinero", "Darle largas hasta que no triga dinero pesado", new Date(2014, 9, 15), new Date(2014, 10, 15));
		Cliente cl3 = new Cliente("Finolis", "934455123", "645867742", "finolis@millonarios.es", 230000000, 1000000, true, true, false, "De alto estanding pero lejos de otros rusos", "Tratar muy bien,posiblmeente gay", new Date(2014, 10, 15), new Date(2014, 10, 25));

		sesion.save(cl1);
		sesion.save(cl2);
		sesion.save(cl3);

		Propietario prop1 = new Propietario("Pedro", "Garcia Lobos", "45795632", 0, "F", "977895632", "652898953", "pgarcia@telefonica.es", "Avn España la grande nº 23 2º derecha", "Racano no devulve fianzas y genera problemas de arreglos");
		Propietario prop2 = new Propietario("Pablo", "Pujades Tibias", "16569742", 0, "G", "941785632", "658989563", "puja@telefonica.es", "Avn La Rioja nº 3 bis", "Gestionar todo vivie en la Rioja no quiere problemas paga bien las gestiones");

		sesion.save(prop1);
		sesion.save(prop2);

		Inmueble in1 = new Inmueble(prop1.getNumero(), ConfigConts.getEstado_libre(), "Avn la paz", "Cunit", "Tarragona", "Playa", ConfigConts.getTipopiso_Atico(),
				ConfigConts.isVenta(), 120, 4, 2, true, 12, 25, 2, 0, ConfigConts.getPiscina_comunitaria(), ConfigConts.getCalefacion_gas(), true, ConfigConts.getSuelo_nodefinido(),
				ConfigConts.getCocina_conisla(), 10, 15, true, true, 1990, "Esta casa esta muy bien consevada dar palo al propietario", 800,true, 250000.0, 275000.0, "Preciosa Casa bonita preciosa bonita", "falta por traducir");
		Inmueble in2 = new Inmueble(prop2.getNumero(), ConfigConts.getEstado_libre(), "Avn Alemania", "Segur de Calafell", "Tarragona", "Playa", ConfigConts.getTipopiso_Atico(),
				ConfigConts.isVenta(), 120, 4, 2, true, 12, 25, 2, 0, ConfigConts.getPiscina_comunitaria(), ConfigConts.getCalefacion_gas(), true, ConfigConts.getSuelo_nodefinido(),
				ConfigConts.getCocina_conisla(), 10, 15, false, false, 1990, "Esta casa esta muy bien consevada dar palo al propietario", 2500,true, 220000.0, 255000.0, "Preciosa Casa bonita preciosa bonita2", "falta por traducir");
		Inmueble in3 = new Inmueble(prop1.getNumero(), ConfigConts.getEstado_libre(), "PAseo MAritimo", "Cunit", "Tarragona", "Playa", ConfigConts.getTipopiso_Duplex(),
				ConfigConts.isVenta(), 120, 4, 2, true, 12, 25, 2, 0, ConfigConts.getPiscina_comunitaria(), ConfigConts.getCalefacion_gas(), true, ConfigConts.getSuelo_nodefinido(),
				ConfigConts.getCocina_conisla(), 10, 15, true, true, 1990, "Esta casa esta muy bien consevada dar palo al propietario", 20,true, 280000.0, 295000.0, "Preciosa Casa bonita preciosa bonita3", "falta por traducir");
		
		sesion.save(in1);
		sesion.save(in2);
		sesion.save(in3);
		
		prop1.addInmueble(in1);
		prop1.addInmueble(in3);
		prop2.addInmueble(in2);
		
		sesion.update(prop1);
		sesion.update(prop2);

		sesion.getTransaction().commit();
		// sesion.close();
		System.out.println("/****************** FIN");

	}
}
