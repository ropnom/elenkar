package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ClienteCollection {

	private List<Cliente> clientes = new ArrayList<Cliente>();

	public void add(Cliente propietario) {
		clientes.add(propietario);
	}
	
	public List<Cliente> getInmuebles() {
		return clientes;
	}

	public void setPosts(List<Cliente> clientesa) {
		
		this.clientes = new ArrayList<Cliente>(clientesa);
		
	}

}
