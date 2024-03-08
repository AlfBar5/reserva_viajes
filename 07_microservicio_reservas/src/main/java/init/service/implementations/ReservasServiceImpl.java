package init.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.ReservasDao;
import init.dto.ReservaDto;
import init.model.Reserva;
import init.service.interfaces.ReservasService;
import init.service.mappers.Mapeador;



/*
  
Expone al menos los siguientes recursos, todos ellos de acceso libre:


// Alta de la misma con los datos de reserva. securizado mediante token JWT para que solo usuarios determinados puedan utilizarlo).

// Lista de reservas por cliente Microservicio de cliente
 
 
*/


//@Service para que SPRIM cree objetos de la clase ClientesServiceImpl (para que haga los new)
@Service
public class ReservasServiceImpl implements ReservasService {
	

	//inyectamos el dao ClientesDao
	@Autowired
	ReservasDao reservasDao;

	
	
	@Override
	public List<ReservaDto> listaReservas(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	@Override
	public void altaReserva(ReservaDto reserva) {
		
		//reservasDao.save(Mapeador.reservaDtoToEntity(reserva));
		
		
	}

	
	
	
	

	
}
