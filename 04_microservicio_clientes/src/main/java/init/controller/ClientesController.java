package init.controller;

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

import init.model.Cliente;
import init.service.interfaces.ClientesService;



/*

Expondrá al menos los siguientes recursos:

//-Devolución de un Cliente a partir de la combinación usuario y contraseña

//-Registro de un Cliente a partir de los datos del mismo

//-Devolución de un Cliente a partir del usuario
 
*/


@CrossOrigin("*") //permitir llamadas desde cualquier origen
@RestController
public class ClientesController {
	
	@Autowired
	ClientesService service;
	
	
	//Devolución de un Cliente a partir de la combinación usuario y contraseña
	//URL: http://localhost:8500/autentication/client1/client1
	//URL gateway: http://localhost:9000/sclientes/autentication/client1/client1
	@GetMapping(value="autentication/{usuario}/{password}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> autenticar(@PathVariable("usuario") String usuario,@PathVariable("password") String password) {

		Cliente cliente=service.autenticarCliente(usuario, password);

		if(cliente!=null) {
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	//Devolución de un Cliente a partir del usuario 
	//URL: http://localhost:8500/buscarusuario/client1
	//URL gateway: http://localhost:9000/sclientes/client1
	@GetMapping(value="buscarusuario/{usuario}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscaruser(@PathVariable("usuario") String usuario) {

		Cliente cliente=service.buscarPorUser(usuario);

		if(cliente!=null) {
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	//Registro de un Cliente a partir de los datos del mismo
	//le pasamos un json de cliente. Ejemplo 39_microservicio_libreria_oauth_eureka_servidor_centralizado
	//URL POST : http://localhost:8500/alta
	//URL gateway: http://localhost:9000/sclientes/alta
	@PostMapping(value="alta", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody Cliente cliente){	

		if(service.altaCliente(cliente)) {

			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	
	
	
	
	

}
