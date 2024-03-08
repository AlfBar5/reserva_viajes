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


import init.model.Reserva;
import init.service.interfaces.ReservasService;
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
public class ReservasController {
	
	@Autowired
	ReservasService service;
	
	
	
	
	
	
	
	// Lista de reservas por cliente
	//URL: http://localhost:8502/reservas/client1
	//URL gateway: http://localhost:9000/sreservas/reservas/client1
	@GetMapping(value="reservas/{usuario}",produces="application/json")
	public @ResponseBody List<Reserva> listareservas(@PathVariable("usuario") String usuario){
		
		return service.listaReservas(usuario);
		
	}
	
	
	
	// Alta de reserva Segurizado mediante token oauth2
	//URL: http://localhost:8502/actualizarplazas/2/1
	//URL gateway: http://localhost:9000/sreservas/altareserva/2/1
	@PutMapping(value="altareserva/{reserva}/{plazas}",produces=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarplazas(@PathVariable("plazas") int plazas, @PathVariable("idvuelo") int idvuelo){

		service.altaReserva(plazas, idvuelo);

		
		
	}
	
	
	
	
	
	
	
	
	

}
