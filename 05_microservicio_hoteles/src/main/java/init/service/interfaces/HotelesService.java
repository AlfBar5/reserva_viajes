package init.service.interfaces;

import java.util.List;

import init.model.Hotel;

/*
  
Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Datos de hotel por identificador

// Lista de hoteles por localización
 
*/



public interface HotelesService {
	
	
	
	//Datos de hotel por identificador
	Hotel buscarHotelPorId(int idHotel);
	
	
	// Lista de hoteles por localización
	List<Hotel> buscarHotelesPorLocalizacion(String localizacion);
	
	
	//lista de destinos
	List<String> listaDestinos();
	

}
