package com.garage.security;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtUtil {

    // En haut de ta classe JwtUtil
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private long expiration;

    /* Méthode pour obtenir la clé secrète au format SecretKey à partir de la chaîne
    *  Génère la clé de signature HMAC à partir du secret.
    */
    private SecretKey getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
       /* if (keyBytes.length < 32) {
            throw new IllegalArgumentException("JWT secret must be at least 256 bits (32 bytes)");
        }*/
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public String generateToken(String username) {
            // Affiche la longueur de la clé en octets:
            logger.info("Key length in bytes: {}", secret.getBytes(StandardCharsets.UTF_8).length);
        String token=Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                //.signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
        return token;
    }

    public Boolean validateToken(String token, String username) {
        final String tokenUsername = getUsernameFromToken(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }
}
/*Explications
getSigningKey() convertit la chaîne secret en clé SecretKey compatible avec HS256.

La méthode signWith() utilise la bonne signature (clé + algo).

Pour parser le token, il faut utiliser Jwts.parserBuilder() (au lieu de Jwts.parser()) et passer la clé via setSigningKey(), puis appeler build().

L'utilisation de l'encodage UTF-8 pour la clé garantit qu'elle est correctement convertie en bytes.

Assure-toi que ta clé secrète est suffisamment longue (au moins 256 bits / 32 caractères) pour HS256.

 */