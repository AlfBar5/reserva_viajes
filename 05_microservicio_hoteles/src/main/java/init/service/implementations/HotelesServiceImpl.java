package init.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.HotelesDao;
import init.model.Hotel;
import init.service.interfaces.HotelesService;



/*
  
Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Datos de hotel por identificador

// Lista de hoteles por localización
 
*/


//@Service para que SPRIM cree objetos de la clase ClientesServiceImpl (para que haga los new)
@Service
public class HotelesServiceImpl implements HotelesService {
	

	//inyectamos el dao ClientesDao
	@Autowired
	HotelesDao hotelesDao;

	
	@Override
	public Hotel buscarHotelPorId(int idHotel) {
		
		return hotelesDao.findByIdHotel(idHotel);
		
	}

	@Override
	public List<Hotel> buscarHotelesPorLocalizacion(String localizacion) {
		
		return hotelesDao.findByLocalizacion(localizacion);
		
	}

	@Override
	public List<String> listaDestinos() {

		//una forma cogiendo una lista de todos los campos, menos optimizado si la tabla tiene muchos campos
		/*
				return hotelesDao.findAll().stream()
						.map(l->l.getLocalizacion())
						.distinct()
						.toList();
		 */

		//usando una query con un distinct en LibrosDao, mucho más optimizado
		return hotelesDao.buscarDestino();
		
		
	}
	
	

	
}
