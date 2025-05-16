package com.garage.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public String userProfile() {
        return "Bienvenue sur votre profil utilisateur sécurisé ! 🎉";
    }
}