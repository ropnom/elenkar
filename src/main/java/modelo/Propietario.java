package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import manager.Checkinfo;

@XmlRootElement
@Entity
@Table(name = "propietario")
@AssociationOverrides({ @AssociationOverride(name = "propietario.identificador", joinColumns = @JoinColumn(name = "numero"))})
public class Propietario implements Serializable {

	private static final long serialVersionUID = 1154561321L;
	
	// DATOS DE PRIPIETARIO
	private String nombre; // Nombre Propietario
	private String apellidos; // Apellidos de Propietario.

	private String numero; // numero de dni
	private int nacionalidad; // nacionalidad si es 0 es español, sino es otra
								// cosa.
	private String letra; // letra del dni.

	private String telefono; // telefono.
	private String movil; // telefono movil. DOMINANTE
	private String email;
	private String direccion; // de residencia
	private String observaciones;
	private Date lastupdate;
	
	

	//Dependencias hibernate
	private List<Inmueble> misinmuebles;
	private Set<Hotel> mishoteles;

	public Propietario() {
		this.lastupdate = new Date();
		this.misinmuebles = new ArrayList<Inmueble>();
		this.mishoteles = new HashSet<Hotel>();

	}

	public Propietario(String nombre, String apellidos, String numero, int nacionalidad, String letra) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numero = numero;
		this.nacionalidad = nacionalidad;
		this.letra = letra;
		this.lastupdate = new Date();
		this.misinmuebles = new ArrayList<Inmueble>();
		this.mishoteles = new HashSet<Hotel>();

	}

	public Propietario(String nombre, String apellidos, String numero, int nacionalidad, String letra, String telefono, String movil, String email, String direccion, String observaciones) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numero = numero;
		this.nacionalidad = nacionalidad;
		this.letra = letra;
		this.telefono = telefono;
		this.movil = movil;
		this.email = email;
		this.direccion = direccion;
		this.observaciones = observaciones;
		this.lastupdate = new Date();
		this.misinmuebles = new ArrayList<Inmueble>();
		this.mishoteles = new HashSet<Hotel>();

	}
	
	//Funciones
	public boolean CheckNacionality(){
		return Checkinfo.checknationality(this.nacionalidad, this.numero);
	}
	public boolean CheckLetra(){
		return Checkinfo.checkletter(this.nacionalidad, this.letra, this.numero);
	}
	public boolean Checktelefono(){
		return Checkinfo.check_fijophone(this.telefono);		
	}
	public boolean Checkmovil(){
		return Checkinfo.check_movil(movil);
	}
	public boolean Checkemail(){
		return Checkinfo.check_email(this.email);
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Id
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(int nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="inmueble")
	public List<Inmueble> getMisinmuebles() {
		return misinmuebles;
	}

	public void setMisinmuebles(List<Inmueble> misinmuebles) {
		this.misinmuebles = misinmuebles;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="hotel")
	public Set<Hotel> getMishoteles() {
		return mishoteles;
	}

	public void setMishoteles(Set<Hotel> mishoteles) {
		this.mishoteles = mishoteles;
	}
	
	public void addInmueble(Inmueble a){
		this.misinmuebles.add(a);
	}
	public void addHotel(Hotel a){
		this.mishoteles.add(a);
	}

}