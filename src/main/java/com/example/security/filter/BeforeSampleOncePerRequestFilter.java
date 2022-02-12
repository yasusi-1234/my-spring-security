package com.example.security.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BeforeSampleOncePerRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("call class: " + this.getClass().getSimpleName());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null){
            System.out.println("auth is null.");
        }else{
            System.out.println("auth is exist. auth: " + auth.toString());
        }

        filterChain.doFilter(request, response);
    }
}
