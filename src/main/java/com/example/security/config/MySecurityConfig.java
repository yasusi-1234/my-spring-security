package com.example.security.config;

import ch.qos.logback.core.joran.action.NOPAction;
import com.example.security.config.handler.LoginSuccessHandler;
import com.example.security.filter.AfterSampleOncePerRequestFilter;
import com.example.security.filter.BeforeSampleOncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AppUserDetailsService appUserDetailsService;

//    @Autowired
//    private SampleUsernamePasswordAuthenticationProvider sampleUsernamePasswordAuthenticationProvider;

    @Autowired
    @Qualifier("mySuccessHandler")
    private AuthenticationSuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/*", "/users").authenticated() // 認証が必要なPath
                .antMatchers("/cards/*").authenticated() // 認証が必要なPath
                .antMatchers("/hello").permitAll(); // 認証が必要ないPath

//        http.setSharedObject();

        http.addFilterBefore(new BeforeSampleOncePerRequestFilter(), UsernamePasswordAuthenticationFilter.class)
                        .addFilterAfter(new AfterSampleOncePerRequestFilter(), UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable(); // csrf無効化

        http.cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration corsConfig = new CorsConfiguration();
                corsConfig.setAllowCredentials(true);
                corsConfig.setAllowedOrigins(Collections.singletonList("http://127.0.0.1:5500"));
                corsConfig.setAllowedMethods(Collections.singletonList("*"));
                corsConfig.setAllowedHeaders(Collections.singletonList("*"));
                return corsConfig;
            }
        });

        http.formLogin().loginProcessingUrl("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new LoginSuccessHandler());
//        http.httpBasic(); // Basic認証

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

// none
//
//        WebAsyncManagerIntegrationFilter
//    SecurityContextPersistenceFilter
//            HeaderWriterFilter
//    CsrfFilter
//            LogoutFilter
//    RequestCacheAwareFilter
//            SecurityContextHolderAwareRequestFilter
//    AnonymousAuthenticationFilter
//            SessionManagementFilter
//    ExceptionTranslationFilter
//            FilterSecurityInterceptor

// login only
//
//    WebAsyncManagerIntegrationFilter
//            SecurityContextPersistenceFilter
//    HeaderWriterFilter
//            CsrfFilter
//    LogoutFilter
//            UsernamePasswordAuthenticationFilter
//    DefaultLoginPageGeneratingFilter
//            DefaultLogoutPageGeneratingFilter
//    RequestCacheAwareFilter
//            SecurityContextHolderAwareRequestFilter
//    AnonymousAuthenticationFilter
//            SessionManagementFilter
//    ExceptionTranslationFilter
//            FilterSecurityInterceptor


// basic only
//
//    WebAsyncManagerIntegrationFilter
//            SecurityContextPersistenceFilter
//    HeaderWriterFilter
//            CsrfFilter
//    LogoutFilter
//            BasicAuthenticationFilter
//    RequestCacheAwareFilter
//            SecurityContextHolderAwareRequestFilter
//    AnonymousAuthenticationFilter
//            SessionManagementFilter
//    ExceptionTranslationFilter
//            FilterSecurityInterceptor

// basic and login
//
//    WebAsyncManagerIntegrationFilter
//            SecurityContextPersistenceFilter
//    HeaderWriterFilter
//            CsrfFilter
//    LogoutFilter
//            UsernamePasswordAuthenticationFilter
//    DefaultLoginPageGeneratingFilter
//            DefaultLogoutPageGeneratingFilter
//    BasicAuthenticationFilter
//            RequestCacheAwareFilter
//    SecurityContextHolderAwareRequestFilter
//            AnonymousAuthenticationFilter
//    SessionManagementFilter
//            ExceptionTranslationFilter
//  FilterSecurityInterceptor