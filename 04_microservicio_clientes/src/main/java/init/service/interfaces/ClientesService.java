package init.service.interfaces;

import init.model.Cliente;

/*
  
Expondrá al menos los siguientes recursos:

//-Devolución de un Cliente a partir de la combinación usuario y contraseña

//-Registro de un Cliente a partir de los datos del mismo

//-Devolución de un Cliente a partir del usuario
 
*/



public interface ClientesService {
	
	//-Devolución de un Cliente a partir de la combinación usuario y contraseña
	Cliente autenticarCliente(String usuario, String password);

	//-Registro de un Cliente a partir de los datos del mismo
	boolean altaCliente(Cliente cliente);

	//-Devolución de un Cliente a partir del usuario
	Cliente buscarPorUser(String usuario);
	

}
