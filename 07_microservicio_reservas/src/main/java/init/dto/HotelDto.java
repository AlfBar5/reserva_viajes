package init.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class HotelDto {

	
	private int idHotel;
	private String nombre;
	private int categoria;
	private double precio;
	private String disponible;
	private String localizacion;
	
	public String isDisponible() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
