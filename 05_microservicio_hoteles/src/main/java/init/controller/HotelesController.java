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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;


import init.model.Hotel;
import init.service.interfaces.HotelesService;
import jakarta.servlet.http.HttpSession;



/*

Expone al menos los siguientes recursos, todos ellos de acceso libre:

// Datos de hotel por identificador

// Lista de hoteles por localización
 
*/


@CrossOrigin("*") //permitir llamadas desde cualquier origen
@RestController
public class HotelesController {
	
	@Autowired
	HotelesService service;
	
	
	
	// Datos de hotel por identificador, le damos idHotel y devuelve un hotel
	//URL: http://localhost:8501/buscarhotel/7
	//URL gateway: http://localhost:9000/shoteles/datoshotel/Madrid
	@GetMapping(value="buscarhotel/{idHotel}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> buscarhotel(@PathVariable("idHotel") int idHotel) {

		Hotel hotel=service.buscarHotelPorId(idHotel);

		if(hotel!=null) {
			return new ResponseEntity<>(hotel,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	// Lista de hoteles por localización, le damos localización y devuelve una lista de hoteles
	//URL: http://localhost:8501/listahoteles/Madrid
	//URL gateway: http://localhost:9000/shoteles/listahoteles/Madrid
	@GetMapping(value="listahoteles/{localizacion}",produces="application/json")
	public @ResponseBody List<Hotel> listahoteles(@PathVariable("localizacion") String localizacion){
		
		return service.buscarHotelesPorLocalizacion(localizacion);
		
	}
	
	
	// Lista de destinos
	//URL: http://localhost:8501/destinos
	//URL gateway: http://localhost:9000/shoteles/destinos
	@GetMapping(value="destinos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> destinos(){
		
		return new ResponseEntity<>(service.listaDestinos(),HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	

}
