package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Hotel;


/*

Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Datos de hotel por identificador

// Lista de hoteles por localización
 
*/

public interface HotelesDao extends JpaRepository<Hotel, Integer> {
	
	
	///métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
		
	//Datos de hotel por identificador
	Hotel findByIdHotel(int idHotel);
		
		
	// Lista de hoteles por localización
	List<Hotel> findByLocalizacion(String localizacion);
		
	//lista de destinos (localizaciones) sin repetir. Devuelve una lista de string
	@Query("select distinct l.localizacion from Hotel l")
	public List<String> buscarDestino();

}
