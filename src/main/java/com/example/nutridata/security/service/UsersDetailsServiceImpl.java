package com.example.nutridata.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.nutridata.security.model.Users;
import com.example.nutridata.security.repository.UsersRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersDetailsServiceImpl implements UserDetailsService, UsersService {

    private final UsersRepository usersRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getName().name()))
                        .collect(Collectors.toSet()));
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return usersRepo.findByEmail(email);
    }
}
