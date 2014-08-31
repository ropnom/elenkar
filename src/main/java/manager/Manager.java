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

public interface Manager {
		
	// *** USUARIOS ***

	public boolean addUser(String name, String username, String password, String correo, int rango);
	
	public User getUser(String username);	
	
	public User getUserwithtoken(String username);
	
	public User editUser( User user);	
	
	//usar la funcion privada para no usar USER TO y no cerrar la sesion.
	//private User getuser(Session sesion, String username);

	public boolean isAdmin(String username);
	
	public boolean SignIn(String user, String password);
	
	
	// ** Inmuebles **
	
	public boolean addInmueble(String userid, int estado, String calle, String poblacion, String provincia, String zona, int tipopiso, boolean alquiler,
			int superficie, int habitaciones, int baños, boolean ascensor, int terraza, int jardin, int parquing, int trastero, int piscina,
			int calefacion, boolean acondicionado, int tiposuelo, int tipococina, int cocina, int comedor, boolean amueblado, boolean carpinteria,
			int construccion, String interno, int distancia_playa, boolean vistas_mar, Double preciopropietario, Double preciofinal,
			String anotacionesES, String anotacionesRU);
	
	public boolean editInmueble(Inmueble inmueble);
	
	public boolean deleteInmueble(int identificador);
	
	public InmueblesCollection getInmuebles(String orden);
	
	public InmueblesCollection getInmueblesByCalle();
	
	public InmueblesCollection getInmueblesByPrecio();
	
	public InmueblesCollection getInmueblesByidentificador();
	
	public InmueblesCollection getInmueblesfromPropietario(String orden, String numbero);
	
	
	
	// ** Propietario **
	
	public boolean addPropietario(String nombre, String apellidos, String numero, int nacionalidad, String letra, String telefono, String movil, String email, String direcion, String observaciones);
		
	public boolean editPropietario(Propietario propietario);
	
	public boolean deletePropietario(String numero);
	
	public PropietariosCollection getPropietarios(String orden);
	
	public PropietariosCollection getPropietariosByNombre();
	
	public PropietariosCollection getPropietariosByNumero();
	
	public PropietariosCollection getPropietariosByApellidos();
	
	public Propietario getPropietarioDeInmueble(int inmuebleid);
	
	public Propietario getPropietarioDeHotel(int hotelid);
	
	
	
	// ** Cliente **
	
	public boolean addCliente(String name, String telf, String movil, String mail, int precio_max, int precio_min, boolean hotel, boolean inmuebles, boolean alquiler, String observaciones, String directrices, Date fechapronto, Date fechatarde);

	public boolean editCliente(Cliente cliente);
	
	public boolean deleteCliente(String identificador);
	
	public ClienteCollection getClientes(String orden);
	
	public ClienteCollection getClientesByNombre();
	
	public ClienteCollection getClientesByidentificador();
	
	public ClienteCollection getClientesByFechallegada();
	
	public ClienteCollection getClientesInteresados(String orden);
	
	
	
	// ** Hotel **
	
	public boolean addHotel(int userid, String nombre, int num_habitaciones, int estrellas, String zona, int dist_playa, int precio_owner, int precio_fin, boolean vistas_mar, String observacionesES, String observacionesRU, String interno);
	
	public boolean editHotel(Hotel hotel);
	
	public boolean deleteHotel(int identificador);
	
	public HotelCollection getHoteles(String orden);
	
	public HotelCollection getHotelesByPrecio(String orden);
	
	public HotelCollection getHotelesByEstrellas(String orden);

	
	
}
