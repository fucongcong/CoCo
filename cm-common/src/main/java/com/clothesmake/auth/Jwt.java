package com.clothesmake.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Map;

public class Jwt {

    public static DecodedJWT parseToken(String token, String secret) {
        if (token == null) {
            return null;
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);

            return jwt;
        } catch (JWTVerificationException exception){
            return null;
        }
    }

    public static String createToken(String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception){
            return null;
        }
    }

    public static Claim getClaim(DecodedJWT jwt, String key) {
        Map<String, Claim> claims = jwt.getClaims();
        return claims.get(key);
    }
}
