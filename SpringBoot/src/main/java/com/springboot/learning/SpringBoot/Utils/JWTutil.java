package com.springboot.learning.SpringBoot.Utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JWTutil {
    private final String Secret = "g7h9@Kwz1FqL#8vD!eR0mNs3YpT2cU6x";
    private final long EXPIRATION = 1000*60*60;
    private final Key secretKey = Keys.hmacShaKeyFor(Secret.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey, SignatureAlgorithm.HS256) // ✅ HMAC-SHA256
                .compact();
    }

    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String token){
        try{
            extractEmail(token);
            return true;
        } catch(JwtException e){
            return false;
        }
    }
}
