package com.te.cms.utils.jwt;

import io.jsonwebtoken.*;


import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Jwtutils {


    private String secret = "some secret";

    //1. to generate the token
    public String genrationToken(String subject) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(subject);
        builder.setIssuer("suresh");
        builder.setIssuedAt(new Date(System.currentTimeMillis()));
        builder.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)));
        builder.signWith(SignatureAlgorithm.ES256, secret.getBytes());


        return builder.compact();
    }

    // method for reading claims
    public Claims readingClaims(String token) {
        JwtParser parser = Jwts.parser();
        parser.setSigningKey(secret.getBytes());
        Jws<Claims> claimsJws = parser.parseClaimsJws(token);
        return claimsJws.getBody();
    }

    //3.method to get expire date
    public Date getExpireDate(String token) {

        return readingClaims(token).getExpiration();
    }

    // 4. method to get username
    public String getUsername(String token) {

        return readingClaims(token).getSubject();
    }

    //5.check the token expired
    public boolean isTokenExpired(String token) {

        Date expireDate = getExpireDate(token);
        return expireDate.before(new Date(System.currentTimeMillis()));
    }

    //6 validate the token

    public boolean validateToken(String token, String userName) {

        String username = getUsername(userName);
        return username.equals(token) && !isTokenExpired(token);
    }

}
