package com.example.Orientation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orientation.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
