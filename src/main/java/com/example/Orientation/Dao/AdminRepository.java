package com.example.Orientation.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Orientation.entities.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
	
	

}
