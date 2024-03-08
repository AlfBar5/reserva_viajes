package init.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.VuelosDao;
import init.model.Vuelo;
import init.service.interfaces.VuelosService;



/*
  
Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Lista de vuelos a partir de un destino y número de plazas

// Actualización de plazas a partir de identificador de vuelo y plazas reservadas
  (securizado mediante token JWT oauth2 (para que solo usuarios determinados puedan utilizarlo)

// Datos de Vuelo por identificador
 
 
*/


//@Service para que SPRIM cree objetos de la clase ClientesServiceImpl (para que haga los new)
@Service
public class VuelosServiceImpl implements VuelosService {
	

	//inyectamos el dao ClientesDao
	@Autowired
	VuelosDao vuelosDao;

	
	@Override
	public Vuelo buscarVueloPorId(int idvuelo) {
		
		return vuelosDao.findByIdvuelo(idvuelo);
		
	}

	@Override
	public List<Vuelo> listaVuelos(String destino, int plazas) {
		
		return vuelosDao.buscarPorDestinoYPlazas(destino, plazas);
		
	}

	
	@Override
	public void actualizacionPlazas(int plazas, int idvuelo) {
 
		//comprobamos si el vuelo existe
		Vuelo vuel = vuelosDao.findByIdvuelo(idvuelo);
		
		if(vuel!=null) {
			
			//comprobamos que hay plazas disponibles
			if(vuel.getPlazas()>=plazas) {
				vuelosDao.actualizarVuelo(plazas, idvuelo);
			}
		
		}
		
		
		
	}
	
	

	
}
