package init.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import init.model.Vuelo;

public interface VueloDao extends JpaRepository<Vuelo, Integer>{

}
