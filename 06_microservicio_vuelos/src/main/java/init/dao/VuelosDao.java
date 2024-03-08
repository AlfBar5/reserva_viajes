package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import init.model.Vuelo;


/*

Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Lista de vuelos a partir de un destino y número de plazas

// Actualización de plazas a partir de identificador de vuelo y plazas reservadas
  (securizado mediante token JWT oauth2 (para que solo usuarios determinados puedan utilizarlo)

// Datos de Vuelo por identificador
 
*/

public interface VuelosDao extends JpaRepository<Vuelo, Integer> {
	
	
	///métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
		
	//Datos de Vuelo por identificador
	Vuelo findByIdvuelo(int idvuelo);
		
		
	// Lista de vuelos a partir de un destino y número de plazas
	@Query("Select v from Vuelo v Where v.destino=?1 and v.plazas>=?2")
	List<Vuelo> buscarPorDestinoYPlazas(String destino, int plazas);
	

	// Actualización de plazas a partir de identificador de vuelo y plazas reservadas
	//si es operación de acción hay que meterle estas dos anotaciones
	@Transactional
	@Modifying
	@Query("update Vuelo v set v.plazas=v.plazas-?1 where v.idvuelo=?2 and (v.plazas-?1)>=0")
	void actualizarVuelo(int plazas, int idvuelo);
	
}
