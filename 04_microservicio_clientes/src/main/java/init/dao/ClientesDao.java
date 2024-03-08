package init.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Cliente;


/*

Expondrá al menos los siguientes recursos:

//-Devolución de un Cliente a partir de la combinación usuario y contraseña

//-Registro de un Cliente a partir de los datos del mismo

//-Devolución de un Cliente a partir del usuario
 
*/

public interface ClientesDao extends JpaRepository<Cliente, String> {
	
	
	///métodos que se necesitan pero los heredamos del JpaRepository 
	//no hace falta explicitarlos
		
	//save(Curso curso); //actualizar y alta
	
	//autentificar
	Cliente findByUsuarioAndPassword(String u, String p);
	
	//Comprobar si existe un usuario antes de darlo de alta
	Cliente findByUsuario(String usuario);
	

}
