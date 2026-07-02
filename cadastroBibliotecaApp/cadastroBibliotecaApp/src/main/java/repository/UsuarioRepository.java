package com.poo.bibliteca_cadastro_app.repository;

import com.poo.bibliteca_cadastro_app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}