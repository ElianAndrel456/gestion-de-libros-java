package com.libreria.libreria.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libreria.libreria.models.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, UUID> {

}
