package com.example.Orientation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orientation.entities.Admin;

public interface LoginRepository extends JpaRepository<Admin, Long> {

}
