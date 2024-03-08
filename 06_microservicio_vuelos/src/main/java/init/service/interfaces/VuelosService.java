package init.service.interfaces;

import java.util.List;

import init.model.Vuelo;

/*
  
Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Lista de vuelos a partir de un destino y número de plazas

// Actualización de plazas a partir de identificador de vuelo y plazas reservadas
  (securizado mediante token JWT oauth2 (para que solo usuarios determinados puedan utilizarlo)

// Datos de Vuelo por identificador
 
*/



public interface VuelosService {
	
	
	
	//Datos de Vuelo por identificador
	Vuelo buscarVueloPorId(int idvuelo);
	
	
	// Lista de vuelos a partir de un destino y número de plazas
	List<Vuelo> listaVuelos(String destino, int plazas);
	
	
	// Actualización de plazas a partir de identificador de vuelo y plazas reservadas
	void actualizacionPlazas(int plazas, int idvuelo);

}
