package manager;

import java.util.Date;

import modelo.Cliente;
import modelo.ClienteCollection;
import modelo.Hotel;
import modelo.HotelCollection;
import modelo.Inmueble;
import modelo.InmueblesCollection;
import modelo.Propietario;
import modelo.PropietariosCollection;
import modelo.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ManagerImplement implements Manager {

	// Parametros de la implementacion
	private static final long serialVersionUID = 841947885220719469L;
	private AnnotationConfiguration config;
	private SessionFactory factory;

	// Singlenton
	private static ManagerImplement instance = null;

	public static ManagerImplement getInstance() {
		synchronized (ManagerImplement.class) {
			if (instance == null)
				instance = new ManagerImplement();
			return instance;
		}
	}

	// Inicializacion de hibernate
	private ManagerImplement() {
		// CrearTablas c = new CrearTablas();
		// c.Arranque();
		config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Inmueble.class);
		config.addAnnotatedClass(Hotel.class);

		config.addAnnotatedClass(Propietario.class);
		config.addAnnotatedClass(Cliente.class);
		config.configure();

		factory = config.buildSessionFactory();
	}
	
	
	// ** USER **

	public boolean addUser(String name, String username, String password, String correo, int rango) {

		boolean creado = false;
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		// Check de si el usuario ya existe
		Query q = sesion.createQuery("from user where username = '" + username + "'");
		User user = (User) q.uniqueResult();
		if (user == null) {

			// MD5Hash.generate()
			user = new User(username, password, name, correo);
			user.setRango(rango);
			sesion.save(user);
			sesion.getTransaction().commit();
			creado = true;

		}
		sesion.close();
		return (creado);
	}
	
	public User getUser(String username) {

		// Buscamos el usuario en la lista y lo devolvemos
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		User a = getuser(sesion, username);

		sesion.getTransaction().commit();
		sesion.close();
		a.setSegutitytoken(null);

		return a;
	}

	private User getuser(Session sesion, String username) {

		Query q = sesion.createQuery("from User where username = '" + username + "'");
		User a = (User) q.uniqueResult();
		return a;
	}

	public User getUserwithtoken(String username) {
		// Buscamos el usuario en la lista y lo devolvemos
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		User a = getuser(sesion, username);

		sesion.getTransaction().commit();
		sesion.close();

		return a;
	}

	public User editUser(User user) {
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		User a = getuser(sesion, user.getUsername());

		if (a != null) {
			a.EditUser(user);
			sesion.update(a);
		}

		sesion.getTransaction().commit();
		sesion.close();

		return a;
	}

	public boolean isAdmin(String username) {
		User a = getUser(username);
		if (a != null) {
			if (a.getRango() == ConfigConts.getAdmin())
				return true;
		}
		return false;
	}

	public boolean SignIn(String user, String password) {
		Session sesion = factory.openSession();
		sesion.beginTransaction();
		
		User a = getuser(sesion, user);
		System.out.println("El usuario lo tengo");
		System.out.println(a.getName());
		//MD5Hash.generate()
		boolean comparacion = a.getPassword().equals(password);
		if (comparacion) {
			a.genNewToken();
			sesion.update(a);
		}
		sesion.getTransaction().commit();
		sesion.close();
		return comparacion;
	}
	
	
	// ** PROPIETARIOS **

	public boolean addPropietario(String nombre, String apellidos, String numero, int nacionalidad, String letra, String telefono, String movil, String email, String direcion, String observaciones) {
		boolean creado = false;
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		// Check de si el usuario ya existe
		Query q = sesion.createQuery("from propietario where username = '" + numero + "'");
		Propietario propietario = (Propietario) q.uniqueResult();
		if (propietario == null) {

			// MD5Hash.generate()
			propietario = new Propietario(nombre, apellidos, numero, nacionalidad, letra, telefono, movil, email, direcion, observaciones);
			sesion.save(propietario);
			sesion.getTransaction().commit();
			creado = true;

		}
		sesion.close();
		return (creado);
	}
	
	public boolean editPropietario(Propietario propietario) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePropietario(String numero) {
		// TODO Auto-generated method stub
		return false;
	}

	public PropietariosCollection getPropietarios(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	public PropietariosCollection getPropietariosByNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public PropietariosCollection getPropietariosByNumero() {
		// TODO Auto-generated method stub
		return null;
	}

	public PropietariosCollection getPropietariosByApellidos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Propietario getPropietarioDeInmueble(int inmuebleid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Propietario getPropietarioDeHotel(int hotelid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// ** INMUEBLE **
	
	public boolean addInmueble(String userid, int estado, String calle, String poblacion, String provincia, String zona, int tipopiso, boolean alquiler, int superficie, int habitaciones, int baños, boolean ascensor, int terraza, int jardin, int parquing, int trastero, int piscina, int calefacion, boolean acondicionado, int tiposuelo, int tipococina, int cocina, int comedor, boolean amueblado, boolean carpinteria, int construccion, String interno, int distancia_playa, boolean vistas_mar, Double preciopropietario, Double preciofinal, String anotacionesES, String anotacionesRU) {

		boolean creado = false;
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		// Check de si el usuario ya existe
		Query q = sesion.createQuery("from propietario where numero = '" + userid + "'");
		Propietario propietario = (Propietario) q.uniqueResult();

		if (propietario != null) {

			// MD5Hash.generate()
			Inmueble inmueble = new Inmueble(userid, estado, calle, poblacion, provincia, zona, tipopiso, alquiler, superficie, habitaciones, baños, ascensor, terraza, jardin, parquing, trastero, piscina, calefacion, acondicionado, tiposuelo, tipococina, cocina, comedor, amueblado, carpinteria, construccion, interno, distancia_playa, vistas_mar, preciopropietario, preciofinal, anotacionesES, anotacionesRU);
			sesion.save(inmueble);
			sesion.getTransaction().commit();
			creado = true;

		}
		sesion.close();
		return (creado);
	}
	
	public boolean editInmueble(Inmueble inmueble) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteInmueble(int identificador) {
		// TODO Auto-generated method stub
		return false;
	}

	public InmueblesCollection getInmuebles(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	public InmueblesCollection getInmueblesByCalle() {
		// TODO Auto-generated method stub
		return null;
	}

	public InmueblesCollection getInmueblesByPrecio() {
		// TODO Auto-generated method stub
		return null;
	}

	public InmueblesCollection getInmueblesByidentificador() {
		// TODO Auto-generated method stub
		return null;
	}

	public InmueblesCollection getInmueblesfromPropietario(String orden, String numbero) {
		// TODO Auto-generated method stub
		return null;
	}

	// ** CLIENTE ***
	
	public boolean addCliente(String name, String telf, String movil, String mail, int precio_max, int precio_min, boolean hotel, boolean inmuebles, boolean alquiler, String observaciones, String directrices, Date fechapronto, Date fechatarde) {
		boolean creado = false;
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		// Check de si el usuario ya existe
		Query q = sesion.createQuery("from cliente where name = '" + name + "'");
		Cliente cliente = (Cliente) q.uniqueResult();
		if (cliente == null) {

			// MD5Hash.generate()
			cliente = new Cliente(name, telf, movil, mail, precio_max, precio_min, hotel, inmuebles, alquiler, observaciones, directrices, fechapronto, fechatarde);
			sesion.save(cliente);
			sesion.getTransaction().commit();
			creado = true;

		}
		sesion.close();
		return (creado);
	}
	
	public boolean editCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCliente(String identificador) {
		// TODO Auto-generated method stub
		return false;
	}

	public ClienteCollection getClientes(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteCollection getClientesByNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteCollection getClientesByidentificador() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteCollection getClientesByFechallegada() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteCollection getClientesInteresados(String orden) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ** HOTEL **

	public boolean addHotel(int userid, String nombre, int num_habitaciones, int estrellas, String zona, int dist_playa, int precio_owner, int precio_fin, boolean vistas_mar, String observacionesES, String observacionesRU, String interno) {
		boolean creado = false;
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		// Check de si el usuario ya existe
		Query q = sesion.createQuery("from propietario where numero = '" + userid + "'");
		Propietario propietario = (Propietario) q.uniqueResult();

		if (propietario != null) {

			Hotel hotel = new Hotel(userid, nombre, num_habitaciones, estrellas, zona, dist_playa, precio_owner, precio_fin, vistas_mar, observacionesES, observacionesRU, interno);
			sesion.save(hotel);
			sesion.getTransaction().commit();
			creado = true;

		}
		sesion.close();
		return (creado);

	}	

	public boolean editHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteHotel(int identificador) {
		// TODO Auto-generated method stub
		return false;
	}

	public HotelCollection getHoteles(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelCollection getHotelesByPrecio(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelCollection getHotelesByEstrellas(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
