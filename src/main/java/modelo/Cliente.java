package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import manager.Checkinfo;

@XmlRootElement
@Entity
public class Cliente implements Serializable {
	
	private static int count=10000000;

	private String id;
	private String name;
	private String telf;
	private String movil;
	private String mail;
	private int precio_max;
	private int precio_min;
	private boolean hotel;
	private boolean inmuebles;
	private boolean alquiler;
	private String observaciones;
	private String directrices;
	private Date fechapronto;
	private Date fechatarde;
	private Date lastupdate;
	private String folder = "No hay documentos";

	public Cliente() {
		this.lastupdate = new Date();
	}

	public Cliente(String name, String telf, String movil, String mail, int precio_max, int precio_min, boolean hotel, boolean inmuebles, boolean alquiler, String observaciones, String directrices, Date fechapronto, Date fechatarde) {

		this.name = name;
		this.telf = telf;
		this.movil = movil;
		this.mail = mail;
		this.precio_max = precio_max;
		this.precio_min = precio_min;
		this.hotel = hotel;
		this.inmuebles = inmuebles;
		this.alquiler = alquiler;
		this.observaciones = observaciones;
		this.directrices = directrices;
		this.fechapronto = fechapronto;
		this.fechatarde = fechatarde;
		asignarid();
		this.lastupdate = new Date();
	}
	
	private synchronized void asignarid(){
		
		this.id = this.count + String.valueOf(Checkinfo.get_NIFletter(String.valueOf(count)));
		this.count++;
	}

	// Funciones
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPrecio_max() {
		return precio_max;
	}

	public void setPrecio_max(int precio_max) {
		this.precio_max = precio_max;
	}

	public int getPrecio_min() {
		return precio_min;
	}

	public void setPrecio_min(int precio_min) {
		this.precio_min = precio_min;
	}

	public boolean isHotel() {
		return hotel;
	}

	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}

	public boolean isInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(boolean inmuebles) {
		this.inmuebles = inmuebles;
	}

	public boolean isAlquiler() {
		return alquiler;
	}

	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDirectrices() {
		return directrices;
	}

	public void setDirectrices(String directrices) {
		this.directrices = directrices;
	}

	public Date getFechapronto() {
		return fechapronto;
	}

	public void setFechapronto(Date fechapronto) {
		this.fechapronto = fechapronto;
	}

	public Date getFechatarde() {
		return fechatarde;
	}

	public void setFechatarde(Date fechatarde) {
		this.fechatarde = fechatarde;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public boolean Checktelefono() {
		return Checkinfo.check_fijophone(this.telf);
	}

	public boolean Checkmovil() {
		return Checkinfo.check_movil(movil);
	}

	public boolean Checkemail() {
		return Checkinfo.check_email(this.mail);
	}

}