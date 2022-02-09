package com.example.security.controller;

import com.example.security.domain.model.AppUser;
import com.example.security.domain.repository.AppUserRepository;
import com.example.security.domain.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/users")
    public List<AppUser> getAllUsers() {
        return appUserService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public AppUser getUserId(@PathVariable("id") Long id){
        return appUserService.findById(id);
    }
}
