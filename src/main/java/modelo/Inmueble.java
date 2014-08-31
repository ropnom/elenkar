package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import manager.Checkinfo;

@XmlRootElement
@Entity
@Table(name = "inmueble")
@AssociationOverrides({ @AssociationOverride(name = "inmueble", joinColumns = @JoinColumn(name = "identificador"))})
public class Inmueble implements Serializable {

	private static final long serialVersionUID = 1154563451321L;
	
	// REF.
	private int identificador;
	private String userid;
	private String pseudoref;
	private int estado;

	// DATOS LOCALIZACION
	private int mfachada;
	private String calle;
	private String Poblacion;
	private String Provincia;
	private String zona;

	// DATOS INMUEBLE

	// inmueble 1 Piso, 2 Duplex, 3 Unifamiliar-casa, 4 atico, 5
	// planta baja
	private int tipopiso;
	private boolean alquiler;
	private int superficie;
	private int habitaciones;
	private int baños;
	private boolean ascensor;
	private int terraza;
	private int jardin;
	private int parquing;
	private int trastero;
	private int piscina;// piscina 0 , 1 propia, 2 comunitaria.
	private int calefacion;
	// tipo de calefacion 0 no hay, 1 electrica, 2 gas, 3 gasoil,
	// 4 otros
	private boolean acondicionado;// aire acondicionado
	private int tiposuelo;// 0 inicializacion, 1 parque, 2 baldosa, 3 suelo
							// radiante

	private int tipococina;
	private int cocina;
	private int comedor;

	// amueblado
	private boolean amueblado;
	private boolean carpinteria;
	private int construccion;

	private String interno;

	private int distancia_playa;// metros a la playa -1 inicializacion.
	private boolean vistas_mar;

	// Precio de Venta.
	Double preciopropietario;
	Double preciofinal;

	// anotaciones de interes.
	String anotacionesES; // Cargas, problemas comentarios etc...
	String anotacionesRU;
	String folder = "No hay fotos";

	// DateTime date;
	public Date lastUpdate;
	public Date aviso;

	public Inmueble(String userid, int estado, String calle, String poblacion, String provincia, String zona, int tipopiso, boolean alquiler,
			int superficie, int habitaciones, int baños, boolean ascensor, int terraza, int jardin, int parquing, int trastero, int piscina,
			int calefacion, boolean acondicionado, int tiposuelo, int tipococina, int cocina, int comedor, boolean amueblado, boolean carpinteria,
			int construccion, String interno, int distancia_playa, boolean vistas_mar, Double preciopropietario, Double preciofinal,
			String anotacionesES, String anotacionesRU) {
		
		this.userid = userid;
		this.estado = estado;
		this.calle = calle;
		this.Poblacion = poblacion;
		this.Provincia = provincia;
		this.zona = zona;
		this.tipopiso = tipopiso;
		this.alquiler = alquiler;
		this.superficie = superficie;
		this.habitaciones = habitaciones;
		this.baños = baños;
		this.ascensor = ascensor;
		this.terraza = terraza;
		this.jardin = jardin;
		this.parquing = parquing;
		this.trastero = trastero;
		this.piscina = piscina;
		this.calefacion = calefacion;
		this.acondicionado = acondicionado;
		this.tiposuelo = tiposuelo;
		this.tipococina = tipococina;
		this.cocina = cocina;
		this.comedor = comedor;
		this.amueblado = amueblado;
		this.carpinteria = carpinteria;
		this.construccion = construccion;
		this.interno = interno;
		this.distancia_playa = distancia_playa;
		this.vistas_mar = vistas_mar;
		this.preciopropietario = preciopropietario;
		this.preciofinal = preciofinal;
		this.anotacionesES = anotacionesES;
		this.anotacionesRU = anotacionesRU;
		asignarpseudoref();

		this.lastUpdate = new Date();
	}

	private synchronized void asignarpseudoref() {

		this.pseudoref = "HT234SS"+ String.valueOf(this.preciopropietario)+ "SS12475THJ";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPseudoref() {
		return pseudoref;
	}

	public void setPseudoref(String pseudoref) {
		this.pseudoref = pseudoref;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getMfachada() {
		return mfachada;
	}

	public void setMfachada(int mfachada) {
		this.mfachada = mfachada;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPoblacion() {
		return Poblacion;
	}

	public void setPoblacion(String poblacion) {
		Poblacion = poblacion;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public int getTipopiso() {
		return tipopiso;
	}

	public void setTipopiso(int tipopiso) {
		this.tipopiso = tipopiso;
	}

	public boolean isAlquiler() {
		return alquiler;
	}

	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public int getBaños() {
		return baños;
	}

	public void setBaños(int baños) {
		this.baños = baños;
	}

	public boolean isAscensor() {
		return ascensor;
	}

	public void setAscensor(boolean ascensor) {
		this.ascensor = ascensor;
	}

	public int getTerraza() {
		return terraza;
	}

	public void setTerraza(int terraza) {
		this.terraza = terraza;
	}

	public int getJardin() {
		return jardin;
	}

	public void setJardin(int jardin) {
		this.jardin = jardin;
	}

	public int getParquing() {
		return parquing;
	}

	public void setParquing(int parquing) {
		this.parquing = parquing;
	}

	public int getTrastero() {
		return trastero;
	}

	public void setTrastero(int trastero) {
		this.trastero = trastero;
	}

	public int getPiscina() {
		return piscina;
	}

	public void setPiscina(int piscina) {
		this.piscina = piscina;
	}

	public int getCalefacion() {
		return calefacion;
	}

	public void setCalefacion(int calefacion) {
		this.calefacion = calefacion;
	}

	public boolean isAcondicionado() {
		return acondicionado;
	}

	public void setAcondicionado(boolean acondicionado) {
		this.acondicionado = acondicionado;
	}

	public int getTiposuelo() {
		return tiposuelo;
	}

	public void setTiposuelo(int tiposuelo) {
		this.tiposuelo = tiposuelo;
	}

	public int getTipococina() {
		return tipococina;
	}

	public void setTipococina(int tipococina) {
		this.tipococina = tipococina;
	}

	public int getCocina() {
		return cocina;
	}

	public void setCocina(int cocina) {
		this.cocina = cocina;
	}

	public int getComedor() {
		return comedor;
	}

	public void setComedor(int comedor) {
		this.comedor = comedor;
	}

	public boolean isAmueblado() {
		return amueblado;
	}

	public void setAmueblado(boolean amueblado) {
		this.amueblado = amueblado;
	}

	public boolean isCarpinteria() {
		return carpinteria;
	}

	public void setCarpinteria(boolean carpinteria) {
		this.carpinteria = carpinteria;
	}

	public int getConstruccion() {
		return construccion;
	}

	public void setConstruccion(int construccion) {
		this.construccion = construccion;
	}

	public String getInterno() {
		return interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

	public int getDistancia_playa() {
		return distancia_playa;
	}

	public void setDistancia_playa(int distancia_playa) {
		this.distancia_playa = distancia_playa;
	}

	public boolean isVistas_mar() {
		return vistas_mar;
	}

	public void setVistas_mar(boolean vistas_mar) {
		this.vistas_mar = vistas_mar;
	}

	public Double getPreciopropietario() {
		return preciopropietario;
	}

	public void setPreciopropietario(Double preciopropietario) {
		this.preciopropietario = preciopropietario;
	}

	public Double getPreciofinal() {
		return preciofinal;
	}

	public void setPreciofinal(Double preciofinal) {
		this.preciofinal = preciofinal;
	}

	public String getAnotacionesES() {
		return anotacionesES;
	}

	public void setAnotacionesES(String anotacionesES) {
		this.anotacionesES = anotacionesES;
	}

	public String getAnotacionesRU() {
		return anotacionesRU;
	}

	public void setAnotacionesRU(String anotacionesRU) {
		this.anotacionesRU = anotacionesRU;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getAviso() {
		return aviso;
	}

	public void setAviso(Date aviso) {
		this.aviso = aviso;
	}

	public Inmueble() {
		this.lastUpdate = new Date();
	}

}
