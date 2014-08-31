package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class HotelCollection {

	private List<Hotel> hoteles = new ArrayList<Hotel>();

	public void add(Hotel hotel) {
		hoteles.add(hotel);
	}
	
	public List<Hotel> getInmuebles() {
		return hoteles;
	}

	public void setPosts(List<Hotel> hotelesa) {		
		this.hoteles = new ArrayList<Hotel>(hotelesa);		
	}

}
