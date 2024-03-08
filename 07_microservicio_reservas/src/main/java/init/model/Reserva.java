package init.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//colocamos antes de la clase lo que queremos que haga la librería LOMBOK
//Coloca el código durante la compilación del código
//@Data agrupa al setter y al getter y tiene más cosas

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="reservas")


public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idreserva")
	private int idReserva;
	
	private String usuario;
	
	
	//relacion tabla  MUCHOS A UNO (posibilidad de muchos hoteles para una reserva)
	//decimos el nombre de la Foreign Key.
	//name es la FK ((de la relación tabla reservas/hoteles), referencedColumnName es la PrimaryKey (tabla hoteles)
	@ManyToOne()
	@JoinColumn(name = "hotel",referencedColumnName = "idHotel")
	private Hotel hotel;
	
	
	//relacion tabla  MUCHOS A UNO (posibilidad de muchos vuelos para una reserva)
	//decimos el nombre de la Foreign Key.
	//name es la FK (de la relación tabla reservas/vuelos), referencedColumnName es la PrimaryKey (tabla vuelos)
	@ManyToOne()
	@JoinColumn(name = "vuelo",referencedColumnName = "idvuelo")
	private Vuelo vuelo;
		
	
	private double precio;	
	
}
