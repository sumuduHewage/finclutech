package org.finclutech.dashboard.init;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.finclutech.dashboard.repository.UserRepository;
import org.finclutech.dashboard.model.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        if (!userRepository.findByUsername("admin").isPresent()) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setRole("USER");
            userRepository.save(user);
        }
    }
}
