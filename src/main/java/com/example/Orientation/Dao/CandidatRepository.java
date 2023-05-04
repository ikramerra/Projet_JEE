package com.example.Orientation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Orientation.entities.Candidat;
@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {

//	@Query("FROM Candidat r WHERE e.candidat_id  =:x")
//	public Candidat getByEmail(Long email);
	
	
}