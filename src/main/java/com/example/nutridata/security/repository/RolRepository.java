package com.example.nutridata.security.repository;

import com.example.nutridata.security.model.NameRol;
import com.example.nutridata.security.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    @Query("SELECT r FROM Rol r WHERE r.name = ?1")
    Optional<Rol> findByNombre(NameRol name);
}
