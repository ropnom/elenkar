package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import manager.ConfigConts;

@XmlRootElement
@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = -483960654662674020L;

	// **DATOS DE FUNCIONALIDAD DEL USUARIOS**
	private int identificador;
	private String username;
	private String password;

	// **DATOS COMPLEMENTARIOS **
	private String name;// nombre completo
	private String correo;// correo upc
	private Date last_Update;
	private int rango;

	// Seguridad
	private String segutitytoken;
	private Date validtime;

	public User() {

		this.rango = ConfigConts.getUser();
		this.last_Update = new Date();

	}

	public User(String username, String password) {

		this.username = username;
		this.password = password;
		this.last_Update = new Date();

	}

	public User(String username, String password, String name, String correo) {

		this.username = username;
		this.password = password;
		this.last_Update = new Date();
		this.name = name;
		this.correo = correo;

	}

	public void EditUser(User a) {

		this.username = a.getUsername();
		this.password = a.getPassword();
		this.last_Update = new Date();
		this.name = a.getName();
		this.correo = a.getCorreo();

	}

	public boolean IsAdmin() {

		return (this.rango == ConfigConts.getAdmin());

	}

	public void genNewToken() {

		// Generamos el nuevo token
		Calendar cal;
		String fromuser;

		cal = Calendar.getInstance();
		fromuser = String.valueOf(cal.getTimeInMillis()) + 13235658;
		this.segutitytoken = UUID.randomUUID().toString().toUpperCase() + "-" + Math.abs(fromuser.hashCode());

		// Creamos el tiempo util del token
		Date dt = new Date();
		this.validtime = new Date(dt.getTime() + ConfigConts.getHorastoken() * 3600 * 1000);

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Temporal(TemporalType.TIMESTAMP)  
    @Column(name = "last_Update", insertable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	public Date getLast_Update() {
		return last_Update;
	}

	public void setLast_Update(Date last_Update) {
		this.last_Update = last_Update;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public String getSegutitytoken() {
		return segutitytoken;
	}

	public void setSegutitytoken(String segutitytoken) {
		this.segutitytoken = segutitytoken;
	}

	public Date getValidtime() {
		return validtime;
	}

	public void setValidtime(Date validtime) {
		this.validtime = validtime;
	}

}
