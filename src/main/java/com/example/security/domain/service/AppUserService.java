package com.example.security.domain.service;

import com.example.security.domain.model.AppUser;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AppUserService {

    List<AppUser> findAllUsers();

    AppUser findById(@NonNull Long id);
}
