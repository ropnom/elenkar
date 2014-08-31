package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class InmueblesCollection {

	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();

	public void add(Inmueble inmueble) {
		inmuebles.add(inmueble);
	}
	

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setPosts(List<Inmueble> inmueblesa) {
		
		this.inmuebles = new ArrayList<Inmueble>(inmueblesa);
		
	}

}
