package com.example.nutridata.security.config;

import com.example.nutridata.role.Role;
import com.example.nutridata.role.RoleNames;
import com.example.nutridata.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        initializeRoles();
    }

    private void initializeRoles() {
        createRoleIfNotExists(RoleNames.ROLE_USER);
        createRoleIfNotExists(RoleNames.ROLE_ADMIN);

        System.out.println("Roles iniciales verificados/creados.");
    }

    private void createRoleIfNotExists(RoleNames roleName) {
        roleRepository
                .findByName(roleName)
                .orElseGet(() -> roleRepository.save(new Role(null, roleName)));
    }

}