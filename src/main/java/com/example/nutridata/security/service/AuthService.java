package com.example.nutridata.security.service;

import com.example.nutridata.role.Role;
import com.example.nutridata.role.RoleNames;
import com.example.nutridata.role.RoleRepository;
import com.example.nutridata.security.dto.LoginRequest;
import com.example.nutridata.security.dto.LoginResponse;
import com.example.nutridata.security.dto.RegisterRequest;
import com.example.nutridata.security.jwt.JwtUtils;
import com.example.nutridata.user.User;
import com.example.nutridata.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    public void register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.email())) {
            throw new RuntimeException("El email ya está registrado");
        }

        Role foundRole = roleRepository
                .findByName(RoleNames.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role ROLE_USER no encontrado"));

        User newUser = new User();

        newUser.setName(registerRequest.name());
        newUser.setLastName(registerRequest.lastName());
        newUser.setEmail(registerRequest.email());
        newUser.setPhoneNumber(registerRequest.phoneNumber());
        newUser.setPassword(passwordEncoder.encode(registerRequest.password()));
        newUser.setOccupation(registerRequest.occupation());
        newUser.setRoles(Collections.singleton(foundRole));

        userRepository.save(newUser);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User foundUser = userRepository
                .findByEmail(loginRequest.email())
                .orElseThrow(() -> new BadCredentialsException("Credenciales inválidas"));

        if (!passwordEncoder.matches(loginRequest.password(), foundUser.getPassword())) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        String token = jwtUtils.generateToken(loginRequest.email());

        String roles = foundUser
                .getRoles()
                .stream()
                .map(foundRole -> foundRole.getName().name())
                .collect(Collectors.joining(","));

        return new LoginResponse(
                foundUser.getName(),
                foundUser.getEmail(),
                token,
                roles);
    }

}