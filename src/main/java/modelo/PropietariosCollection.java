package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class PropietariosCollection {

	private List<Propietario> propietarios = new ArrayList<Propietario>();

	public void add(Propietario propietario) {
		propietarios.add(propietario);
	}
	
	public List<Propietario> getInmuebles() {
		return propietarios;
	}

	public void setPosts(List<Propietario> propietario) {
		
		this.propietarios = new ArrayList<Propietario>(propietario);
		
	}

}
