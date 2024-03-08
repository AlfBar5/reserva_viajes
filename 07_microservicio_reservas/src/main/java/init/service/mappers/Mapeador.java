package init.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import init.dto.HotelDto;
import init.dto.ReservaDto;
import init.dto.VueloDto;
import init.model.Hotel;
import init.model.Reserva;
import init.model.Vuelo;

import init.service.interfaces.ReservasService;


//modelo 12_libreria_spring relaciones

//Una reserva es un objeto que tiene dentro un objeto Hotel y un objeto Vuelo completos
//Cuando llamemos a una reserva en el front, tendremos todos los datos de la reserva, hotel y vuelo
//en el front, al hacer el alta tenemos que mandar los datos de la reserva, pero solo el idhotel y el idvuelo

//le decimos que es componente de sprim
@Component
public class Mapeador {
	
	
	
		
	/*	
	
	public HotelDto hotelEntityToDto(Hotel hotel) {
		
		return new HotelDto(
				hotel.getIdHotel(),
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.getDisponible(),
				hotel.getLocalizacion()
				);
	}
	
	
	public VueloDto vueloEntityToDto(Vuelo vuelo) {
		
		return new VueloDto(
				vuelo.getIdvuelo(),
				vuelo.getCompany(),
				vuelo.getFecha(),
				vuelo.getPrecio(),
				vuelo.getPlazas(),
				vuelo.getDestino()				
				);
				
	}
	
	
	public Hotel hotelDtoToEntity(HotelDto hotel) {
		
		return new Hotel(
				hotel.getIdHotel(),
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.getDisponible(),
				hotel.getLocalizacion()				
				);
		
	}
	
	
	public Vuelo vueloDtoToEntity(VueloDto vuelo) {
		
		return new Vuelo(
				vuelo.getIdvuelo(),
				vuelo.getCompany(),
				vuelo.getFecha(),
				vuelo.getPrecio(),
				vuelo.getPlazas(),
				vuelo.getDestino()	
				);
	}
	
	
	
	public ReservaDto reservaEntityToDto(Reserva reserva) {
			
			return new ReservaDto(
					
					reserva.getUsuario(),
					reserva.getHotel(),
					reserva.getVuelo(),
					reserva.getPrecio()	
					);
			
		}
		
	*/
	
	/*
	
	public Reserva reservaDtoToEntity(ReservaDto reserva) {
		return new Reserva(
				0,
				reserva.getUsuario(),
				reserva.getHotelDto(),
				reserva.getVueloDto(),
				reserva.getPrecio()
				);
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * @Component
public class Mapeador {

*/

	public HotelDto hotelToDto(Hotel hotel) {
		return new HotelDto(hotel.getIdHotel(),
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.isDisponible(),
				hotel.getLocalizacion());
	}
	public Hotel dtoToHotel(HotelDto hotel) {
		return new Hotel(hotel.getIdHotel(),
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.isDisponible(),
				hotel.getLocalizacion());
	}
	public VueloDto vueloToDto(Vuelo vuelo) {
		return new VueloDto(vuelo.getIdvuelo(),
				vuelo.getCompany(),
				vuelo.getFecha(),
				vuelo.getPrecio(),
				vuelo.getPlazas(),
				vuelo.getDestino());
	}
	
	public Vuelo dtoToVuelo(VueloDto vuelo) {
		return new Vuelo(vuelo.getIdvuelo(),
				vuelo.getCompany(),
				vuelo.getFecha(),
				vuelo.getPrecio(),
				vuelo.getPlazas(),
				vuelo.getDestino());
	}
	
	
	
	public ReservaDto reservaToDto(Reserva reserva) {
		return new ReservaDto(
				reserva.getIdReserva(),
				reserva.getUsuario(),
				vueloToDto(reserva.getVuelo()),
				hotelToDto(reserva.getHotel()),
				reserva.getPrecio()
				);
		
	}
	
	public Reserva dtoToReserva(ReservaDto reserva) {
		return new Reserva(
				reserva.getIdReserva(),
				reserva.getUsuario(),
				dtoToVuelo(reserva.getVueloDto()),
				dtoToHotel(reserva.getHotelDto()),
				reserva.getPrecio());
	}
} 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
