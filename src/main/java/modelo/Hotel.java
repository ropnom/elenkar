package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.wicket.extensions.wizard.PreviousButton;

@XmlRootElement
@Entity
@Table(name = "hotel")
@AssociationOverrides({ @AssociationOverride(name = "hotel", joinColumns = @JoinColumn(name = "identificador"))})
public class Hotel implements Serializable {

	
	private static final long serialVersionUID = 345231L;
	
	// REF.
	private int identificador;
	private int userid;
	private String pseudoref;
	
	private  Date last_update;
	
    private String nombre;   
	private int superficie_parce;
    private int superf_contruida;
    private int num_habitaciones;
    private int añoconstruccion;
    
    
    private int estrellas;        
    private String zona;
    private int dist_playa;

    private String direccion;
    private int precio_owner;
    private int precio_fin;
    private  boolean vistas_mar;
    private String observacionesES;
    private String observacionesRU;
    private String folder = "No hay fotos";
    private String interno;
    
    
    public Hotel(){
    	this.last_update = new Date();
    	
    }
    
    public Hotel(int userid, String nombre, int num_habitaciones, int estrellas, String zona, int dist_playa, int precio_owner, int precio_fin, boolean vistas_mar, String observacionesES, String observacionesRU, String interno){
    	
    	this.userid = userid;
    	this.num_habitaciones = num_habitaciones;
    	this.estrellas = estrellas;
    	this.zona = zona;
    	this.dist_playa = dist_playa;
    	this.precio_owner = precio_owner;
    	this.precio_fin = precio_fin;
    	this.vistas_mar = vistas_mar;
    	this.observacionesES = observacionesES;
    	this.observacionesRU = observacionesRU;
    	this.interno = interno;
    	asignarpseudoref();
    }
    
    private synchronized void asignarpseudoref() {

		this.pseudoref = "HT234SS"+ String.valueOf(this.precio_owner)+ "SS12475THJ";
	}
    
	@Id
    public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPseudoref() {
		return pseudoref;
	}
	public void setPseudoref(String pseudoref) {
		this.pseudoref = pseudoref;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSuperficie_parce() {
		return superficie_parce;
	}
	public void setSuperficie_parce(int superficie_parce) {
		this.superficie_parce = superficie_parce;
	}
	public int getSuperf_contruida() {
		return superf_contruida;
	}
	public void setSuperf_contruida(int superf_contruida) {
		this.superf_contruida = superf_contruida;
	}
	public int getNum_habitaciones() {
		return num_habitaciones;
	}
	public void setNum_habitaciones(int num_habitaciones) {
		this.num_habitaciones = num_habitaciones;
	}
	public int getAñoconstruccion() {
		return añoconstruccion;
	}
	public void setAñoconstruccion(int añoconstruccion) {
		this.añoconstruccion = añoconstruccion;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public int getDist_playa() {
		return dist_playa;
	}
	public void setDist_playa(int dist_playa) {
		this.dist_playa = dist_playa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getPrecio_owner() {
		return precio_owner;
	}
	public void setPrecio_owner(int precio_owner) {
		this.precio_owner = precio_owner;
	}
	public int getPrecio_fin() {
		return precio_fin;
	}
	public void setPrecio_fin(int precio_fin) {
		this.precio_fin = precio_fin;
	}
	public boolean isVistas_mar() {
		return vistas_mar;
	}
	public void setVistas_mar(boolean vistas_mar) {
		this.vistas_mar = vistas_mar;
	}
	public String getObservacionesES() {
		return observacionesES;
	}
	public void setObservacionesES(String observacionesES) {
		this.observacionesES = observacionesES;
	}
	public String getObservacionesRU() {
		return observacionesRU;
	}
	public void setObservacionesRU(String observacionesRU) {
		this.observacionesRU = observacionesRU;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getInterno() {
		return interno;
	}
	public void setInterno(String interno) {
		this.interno = interno;
	}
}
