package manager;

public class ConfigConts {
	
	// Rangos de autoridad
	private static int user = 0;
	private static int admin = -1;
	
	
	//tiempo
	private static int horastoken = 8;
	
	
	//INMUEBLE
	private static int estado_vendido = 2;
	private static int estado_alquilado = 1;
	private static int estado_libre = 0;
	private static int estado_visible = 10;
	
	private static int tipopiso_Piso = 1;
	private static int tipopiso_Duplex = 2;
	private static int tipopiso_Unifamiliar = 3;
	private static int tipopiso_Atico = 4;
	private static int tipopiso_Plantabaja = 5;	
	private static boolean alquiler = true;
	private static boolean venta = false;	
	private static int piscina_propia = 1;
	private static int piscina_comunitaria = 2;
	private static int calefacion_notiene=0;
	private static int calefacion_electrica=1;
	private static int calefacion_gas=2;	
	private static int calefacion_gasoil=3;
	private static int calefacion_solar=4;
	private static int suelo_nodefinido = 0;
	private static int suelo_parque = 1;
	private static int suelo_baldosa = 2;
	private static int suelo_radiante = 3;
	private static int cocina_office = 0;
	private static int cocina_americana = 1;
	private static int cocina_pasaplatos = 2;
	private static int cocina_conisla = 3;
	
	
	public static int getCalefacion_solar() {
		return calefacion_solar;
	}
	public static int getSuelo_nodefinido() {
		return suelo_nodefinido;
	}
	public static int getSuelo_parque() {
		return suelo_parque;
	}
	public static int getSuelo_baldosa() {
		return suelo_baldosa;
	}
	public static int getSuelo_radiante() {
		return suelo_radiante;
	}
	public static int getCocina_office() {
		return cocina_office;
	}
	public static int getCocina_americana() {
		return cocina_americana;
	}
	public static int getCocina_pasaplatos() {
		return cocina_pasaplatos;
	}
	public static int getCocina_conisla() {
		return cocina_conisla;
	}
	public static int getCalefacion_notiene() {
		return calefacion_notiene;
	}
	public static int getCalefacion_electrica() {
		return calefacion_electrica;
	}
	public static int getCalefacion_gas() {
		return calefacion_gas;
	}
	public static int getCalefacion_gasoil() {
		return calefacion_gasoil;
	}
	public static int getEstado_vendido() {
		return estado_vendido;
	}
	public static int getEstado_alquilado() {
		return estado_alquilado;
	}
	public static int getEstado_libre() {
		return estado_libre;
	}
	public static int getEstado_visible() {
		return estado_visible;
	}
	public static int getTipopiso_Piso() {
		return tipopiso_Piso;
	}
	public static int getTipopiso_Duplex() {
		return tipopiso_Duplex;
	}
	public static int getTipopiso_Unifamiliar() {
		return tipopiso_Unifamiliar;
	}
	public static int getTipopiso_Atico() {
		return tipopiso_Atico;
	}
	public static int getTipopiso_Plantabaja() {
		return tipopiso_Plantabaja;
	}
	public static boolean isAlquiler() {
		return alquiler;
	}
	public static boolean isVenta() {
		return venta;
	}
	public static int getPiscina_propia() {
		return piscina_propia;
	}
	public static int getPiscina_comunitaria() {
		return piscina_comunitaria;
	}
	
	public static int getUser() {
		return user;
	}	
	public static int getHorastoken() {
		return horastoken;
	}
	public static int getAdmin() {
		return admin;
	}
	
	

}
