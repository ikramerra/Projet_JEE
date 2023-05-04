package com.example.Orientation.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Orientation.entities.Branche;

public interface BrancheRepository extends JpaRepository<Branche, Long> {
	
	@Query("FROM  Branche b WHERE b.formation.formation_id =:fomat_id")
	public List<Branche> getBranchrByFormation(Long fomat_id);
}
