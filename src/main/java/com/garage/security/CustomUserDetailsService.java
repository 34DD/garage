package com.garage.security;

import com.garage.entity.User;
import com.garage.service.UserService;
import com.garage.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
                               .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable : " + username));
        return new CustomUserDetails(user);
    }
}

