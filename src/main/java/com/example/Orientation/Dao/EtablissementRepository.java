package com.example.Orientation.Dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Orientation.entities.Etablissement;


public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
	@Query("select p from Etablissement p where p.etablissement like %:x% ")
	public Page<Etablissement> chercherParEtab(@Param("x")String m, Pageable pageable);
	
	@Query("select p from Etablissement p where p.ville.nomville like %:x% ")
	public List<Etablissement> chercher(@Param("x")String mc);
	
	@Query("select p from Etablissement p where p.ville.nomville like %:x% ")
	public Page<Etablissement> chercherVille(@Param("x")String mc , Pageable page);
	
//	public List<Etablissement> findByEtablissement(String etablissement);
	
	//Les ecoles
	@Query("From Etablissement e where e.etablissement_id in (SELECT b.etablissement.etablissement_id from Brancheetablissement b where b.branche.branche_id =:branche_id )")
	public List<Etablissement>  getEtablissementparbranche(Long branche_id);
	

	

	
}
