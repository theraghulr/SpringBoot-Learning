package com.springboot.learning.SpringBoot.controller;

import com.springboot.learning.SpringBoot.Utils.JWTutil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;


@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTutil jwtutil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            try {
                if (jwtutil.validateJwtToken(token)) {
                    String email = jwtutil.extractEmail(token);
                    var authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
                    var auth = new UsernamePasswordAuthenticationToken(email, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    System.out.println("✅ User authenticated: " + email);
                } else {
                    System.out.println("❌ Token is invalid");
                }
            } catch (Exception e) {
                System.out.println("❌ Exception while validating token: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }


}



