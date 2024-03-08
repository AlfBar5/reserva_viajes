package init.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import init.model.Hotel;



public interface HotelDao extends JpaRepository<Hotel, Integer> {

}
