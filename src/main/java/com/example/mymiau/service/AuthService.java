package com.example.mymiau.service;

import com.example.mymiau.domain.Usuario;
import com.example.mymiau.dto.AuthResponse;
import com.example.mymiau.dto.AuthRequest;
import com.example.mymiau.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(Usuario user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        AuthResponse response = new AuthResponse();
        response.setToken(jwt);
        return response;}

    public AuthResponse login(AuthRequest request) throws IllegalArgumentException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail());
        var jwt = jwtService.generateToken(user);
        AuthResponse response = new AuthResponse();
        response.setToken(jwt);
        return response;}}