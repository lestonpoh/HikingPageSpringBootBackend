package com.example.hikes.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {
    @Value("${security.jwt.secret-key}")
    private String secretKey;


//    private long validityInMilliseconds = 3600000; // 1 hour

    public String createToken(String userId) {
        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
//                .setExpiration(validity)
                .signWith(getSignInKey())
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()  // Replaces deprecated parser()
                .setSigningKey(getSignInKey())  // Set the signing key as bytes
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

//    public boolean isTokenExpired(String token) {
//        return getClaims(token).getExpiration().before(new Date());
//    }

    public String getUserId(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token, String userId) {
        return userId.equals(getUserId(token));
    }

    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}