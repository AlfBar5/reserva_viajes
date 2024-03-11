package init.service.interfaces;

import java.util.List;

import init.dto.ReservaDto;
import init.model.Reserva;

/*
  
Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Alta de la misma con los datos de reserva. securizado mediante token JWT para que solo usuarios determinados puedan utilizarlo).

// Lista de reservas por cliente Microservicio de cliente
 
*/



public interface ReservasService {
	
	
	
	List<ReservaDto> reservasCliente(String usuario);
	
	void reservar(ReservaDto dto,int plazas);
	

}
