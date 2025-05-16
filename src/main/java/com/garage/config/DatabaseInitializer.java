/*package com.garage.repository;

@Component
@Profile("dev") // Ne sera exécuté qu’en mode dev
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Créer des rôles
        Role adminRole = new Role(null, "ADMIN");
        Role userRole = new Role(null, "USER");

        roleRepository.saveAll(List.of(adminRole, userRole));

        // Créer un utilisateur
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setEnabled(true);
        admin.setRoles(Set.of(adminRole, userRole));

        userRepository.save(admin);
    }
}
*/