package com.springboot.learning.SpringBoot.Utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JWTutil {

    private final String SECRET = "g7h9@Kwz1FqL#8vD!eR0mNs3YpT2cU6x"; // should be 256-bit or more
    private final long EXPIRATION = 1000 * 60 * 60*10; // 10 hour
    private final Key secretKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token) // ✅ Use parseClaimsJws for signed tokens
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token); // ✅ Same here
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("⚠️ Token expired");
        } catch (UnsupportedJwtException e) {
            System.out.println("⚠️ Unsupported JWT");
        } catch (MalformedJwtException e) {
            System.out.println("⚠️ Malformed JWT");
        } catch (SecurityException e) {
            System.out.println("⚠️ Invalid signature");
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Token is null or empty");
        }

        return false;
    }
}

