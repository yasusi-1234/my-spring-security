package com.example.security.config;

import ch.qos.logback.core.joran.action.NOPAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AppUserDetailsService appUserDetailsService;

//    @Autowired
//    private SampleUsernamePasswordAuthenticationProvider sampleUsernamePasswordAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/*", "/users").authenticated()
                .antMatchers("/cards/*").authenticated()
                .antMatchers("/hello").permitAll();

//        http.formLogin();
        http.httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(sampleUsernamePasswordAuthenticationProvider);
//        auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
