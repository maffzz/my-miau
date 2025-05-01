package com.example.mymiau.repository;

import com.example.mymiau.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreo(String correo);
    List<Usuario> findByFechaRegistro(LocalDate fechaRegistro);
    List<Usuario> findByNombre(String nombre);
}