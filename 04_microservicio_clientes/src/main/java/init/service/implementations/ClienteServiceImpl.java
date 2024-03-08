package init.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.ClientesDao;
import init.model.Cliente;
import init.service.interfaces.ClientesService;



/*
  
Expondrá al menos los siguientes recursos:

//-Devolución de un Cliente a partir de la combinación usuario y contraseña

//-Registro de un Cliente a partir de los datos del mismo

//-Devolución de un Cliente a partir del usuario
 
*/


//@Service para que SPRIM cree objetos de la clase ClientesServiceImpl (para que haga los new)
@Service
public class ClienteServiceImpl implements ClientesService {
	

	//inyectamos el dao ClientesDao
	@Autowired
	ClientesDao clientesDao;
	
	
	@Override
	public Cliente autenticarCliente(String usuario, String password) {
		
		//si no lo encuentra devuelve un null
		return clientesDao.findByUsuarioAndPassword(usuario, password);
	}

	
	
	
	@Override
	public boolean altaCliente(Cliente cliente) {
		//para que no se repitan usuarios, compruebo si existe
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {
			clientesDao.save(cliente);
			return true;
		}
		return false;
	}

	
	
	@Override
	public Cliente buscarPorUser(String usuario) {

		return clientesDao.findByUsuario(usuario);
	}

	
}
