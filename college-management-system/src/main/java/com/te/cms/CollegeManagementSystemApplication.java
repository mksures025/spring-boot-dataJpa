package com.te.cms;

import com.te.cms.entity.Admin;
import com.te.cms.entity.AppUser;
import com.te.cms.entity.Role;
import com.te.cms.repository.AdminRepository;
import com.te.cms.repository.AppUserRepository;
import com.te.cms.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@SpringBootApplication
public class CollegeManagementSystemApplication {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final AdminRepository adminRepository;

    public static void main(String[] args) {

        SpringApplication.run(CollegeManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner saveAdmin() {
        return args -> {

           Optional<Admin> optionalAdmin=adminRepository.findById("ADMIN01");

           if (!optionalAdmin.isPresent()) {

               Role roleStudent = Role.builder().roleName("ROLE_STUDENT").build();
               Role roleProfessor = Role.builder().roleName("ROLE_PROFESSOR").build();
               Role roleAdmin = Role.builder().appUsers(new ArrayList<>())
                       .roleName("ROLE_ADMIN").build();

               Admin admin = Admin.builder()
                       .adminName("Suresh").adminId("ADMIN01")
                       .email("mksuresh025@gmail.com").gender("male").build();

               AppUser appUser = AppUser.builder().UserName(admin.getAdminId())
                       .password(UUID.randomUUID().toString()).roles(new HashSet<>()).build();

               appUser.getRoles().add(roleAdmin);
               roleAdmin.getAppUsers().add(appUser);

               adminRepository.save(admin);
               roleRepository.save(roleStudent);
               roleRepository.save(roleProfessor);
               roleRepository.save(roleAdmin);
               appUserRepository.save(appUser);

           }

        };

    }


}
