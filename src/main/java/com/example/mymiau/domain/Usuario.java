package com.example.mymiau.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "duenio")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column(unique = true)
    private String email;

    private String password;

    private LocalDate fechaRegistro = LocalDate.now();

    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL)
    private List<Gatito> gatitos = new ArrayList<>();

    private final Boolean locked = false;
    private final Boolean enabled = true;
    private final Boolean credentialsExpired = false;
    private final Boolean expired = false;
    private final Boolean enable = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));}

    @Override
    public String getUsername() {
        return email;}

    @Override
    public boolean isAccountNonExpired() {
        return !expired;}

    @Override
    public boolean isAccountNonLocked() {
        return !locked;}

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;}

    @Override
    public boolean isEnabled() {
        return enable;}}