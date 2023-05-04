package com.example.Orientation.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Orientation.entities.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {
	
	@Query("From Formation f WHERE f.formation_id in (SELECT m.formation.formation_id from Metierformation m where m.metier.metier_id =:metier_id)\r\n")
	public List<Formation> getFomationsBymetier(Long metier_id);
	
	
	
	
}