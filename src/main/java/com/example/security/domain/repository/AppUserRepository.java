package com.example.security.domain.repository;

import com.example.security.domain.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByMailAddress(String mailAddress);
}