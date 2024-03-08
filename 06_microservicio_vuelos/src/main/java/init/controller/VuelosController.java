package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;


import init.model.Vuelo;
import init.service.interfaces.VuelosService;
import jakarta.servlet.http.HttpSession;



/*

Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Lista de vuelos a partir de un destino y número de plazas

// Actualización de plazas a partir de identificador de vuelo y plazas reservadas
  (securizado mediante token JWT oauth2 (para que solo usuarios determinados puedan utilizarlo)

// Datos de Vuelo por identificador
 
 
 
*/


@CrossOrigin("*") //permitir llamadas desde cualquier origen
@RestController
public class VuelosController {
	
	@Autowired
	VuelosService service;
	
	
	
	// Datos de Vuelo por identificador
	//URL: http://localhost:8502/buscarvuelo/12
	//URL gateway: http://localhost:9000/svuelos/buscarvuelo/12
	@GetMapping(value="buscarvuelo/{idvuelo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vuelo> buscarvuelo(@PathVariable("idvuelo") int idvuelo) {

		Vuelo vuelo=service.buscarVueloPorId(idvuelo);

		if(vuelo!=null) {
			return new ResponseEntity<>(vuelo,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	// Lista de vuelos a partir de un destino y número de plazas
	//URL: http://localhost:8502/listavuelos/Madrid/2
	//URL gateway: http://localhost:9000/svuelos/listavuelos/Madrid/2
	@GetMapping(value="listavuelos/{destino}/{plazas}",produces="application/json")
	public @ResponseBody List<Vuelo> listavuelos(@PathVariable("destino") String destino, @PathVariable("plazas") int plazas){
		
		return service.listaVuelos(destino, plazas);
		
	}
	
	
	
	// Actualización de plazas a partir de identificador de vuelo y plazas reservadas
	//URL: http://localhost:8502/actualizarplazas/2/1
	//URL gateway: http://localhost:9000/svuelos/actualizarplazas/2/1
	@PutMapping(value="actualizarplazas/{plazas}/{idvuelo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarplazas(@PathVariable("plazas") int plazas, @PathVariable("idvuelo") int idvuelo){

		service.actualizacionPlazas(plazas, idvuelo);

		
		
	}
	
	
	
	
	
	
	
	
	

}
