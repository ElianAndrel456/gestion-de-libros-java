package com.libreria.libreria.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libreria.libreria.models.Libro;

public interface LibroDAO extends JpaRepository<Libro, UUID> {

}
