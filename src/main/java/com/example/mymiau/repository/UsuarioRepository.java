package com.example.mymiau.repository;

import com.example.mymiau.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    List<Usuario> findByFechaRegistro(LocalDate fechaRegistro);
    List<Usuario> findByNombre(String nombre);
    UserDetails findByEmail(String email);}