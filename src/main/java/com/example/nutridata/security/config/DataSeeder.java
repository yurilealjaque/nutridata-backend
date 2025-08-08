package com.example.nutridata.security.config;

import com.example.nutridata.security.model.NameRol;
import com.example.nutridata.security.model.Rol;
import com.example.nutridata.security.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RolRepository rolRepository;

    @Override
    public void run(String... args) {
        inicializarRoles();
    }

    private void inicializarRoles() {
        crearRolSiNoExiste(NameRol.ROLE_USER);
        crearRolSiNoExiste(NameRol.ROLE_ADMIN);

        System.out.println("✅ Roles iniciales verificados/creados.");
    }


    private void crearRolSiNoExiste(NameRol nameRol) {
        rolRepository.findByNombre(nameRol).orElseGet(() ->
                rolRepository.save(new Rol(null, nameRol))
        );
    }
}