package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import init.model.Reserva;


/*

Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Alta de la misma con los datos de reserva. securizado mediante token JWT para que solo usuarios determinados puedan utilizarlo).

// Lista de reservas por cliente Microservicio de cliente
 
*/

public interface ReservasDao extends JpaRepository<Reserva, Integer> {
	
	
	///métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
		
	//Lista de reservas por cliente
	List<Reserva> findByUsuario(String usuario);
		
	
	// Alta de la misma con los datos de reserva
	// securizado mediante token
	 // save(Reserva reserva);
	
}
