package com.example.Orientation.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Orientation.entities.Metier;

public interface MetierRepository extends JpaRepository<Metier, Long> {
//	@Query("select p from Metier p where p.nmetier like :x ")
//	public Page<Metier> chercher(@Param("x")String m, Pageable pageable);
		
	@Query("From Metier m WHERE m.metier_id in (SELECT r.metier.metier_id from Riasecmetier r where r.riasec.riasec_id =:riasec_id)\r\n")
	public List<Metier> getMetierByRiasec(Long riasec_id);
	
	
	
}
