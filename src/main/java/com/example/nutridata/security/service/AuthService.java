package com.example.nutridata.security.service;

import com.example.nutridata.security.dto.LoginResponse;
import com.example.nutridata.security.jwt.JwtUtils;
import com.example.nutridata.security.model.Rol;
import com.example.nutridata.security.model.Users;
import com.example.nutridata.security.repository.RolRepository;
import com.example.nutridata.security.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.stream.Collectors;

import static com.example.nutridata.security.model.NameRol.ROLE_USER;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsersRepository usersRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    // Registro: crea usuario con rol USER
    public void registrar(String name, String email, String password) {
        if (usersRepository.existsByEmail(email)) {
            throw new RuntimeException("El email ya está registrado"); // Puedes usar EmailAlreadyUsedException
        }

        Rol rolUser = rolRepository.findByNombre(ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Rol ROLE_USER no encontrado"));

        Users newUser = new Users();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setRoles(Collections.singleton(rolUser));

        usersRepository.save(newUser);
    }

    // Login: valida credenciales y genera LoginResponse con token
    public LoginResponse login(String email, String password) {
        Users users = usersRepository.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("Credenciales inválidas"));

        if (!passwordEncoder.matches(password, users.getPassword())) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        String token = jwtUtils.generateToken(email);
        String roles = users.getRoles().stream()
                .map(r -> r.getName().name()) // Convierte a texto (USER, ADMIN)
                .collect(Collectors.joining(","));

        return new LoginResponse(users.getName(), users.getEmail(), token, roles);
    }
}