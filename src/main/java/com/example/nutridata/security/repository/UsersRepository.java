package com.example.nutridata.security.repository;

import com.example.nutridata.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    // Optional<Users> findByName(String name);

    Optional<Users> findByEmail(String email);// Luego cambiar el parametro por "email"

    // Boolean existsByName(String name);

    Boolean existsByEmail(String email);
}