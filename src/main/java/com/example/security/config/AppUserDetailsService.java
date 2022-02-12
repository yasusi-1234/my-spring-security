package com.example.security.config;

import com.example.security.domain.model.AppUser;
import com.example.security.domain.repository.AppUserRepository;
import com.example.security.model.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("call class: " + this.getClass().getSimpleName());

        if(!StringUtils.hasText(username)){
            throw new UsernameNotFoundException("invalid username: " + username);
        }

        AppUser appUser = appUserRepository.findByMailAddress(username);

        if(appUser == null) {
            throw new UsernameNotFoundException("invalid username: " + username);
        }
        return new AppUserDetails(appUser);
    }
}
