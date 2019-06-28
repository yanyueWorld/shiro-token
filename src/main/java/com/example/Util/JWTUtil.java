package com.example.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Random;

/**
 * JWTUtil.
 *
 * @author yanyue, 2019/6/27
 * @version shiro v1.0
 */
@Slf4j
public class JWTUtil {
    private static final long EXPIRE_TIME = 60 * 60 * 24;

    private static final String BASE = "abcdefghijklmnopqrstuvwxyz1234567890";

    public static boolean verify(String token, int userId, String password,String salt) {
        Algorithm algorithm = Algorithm.HMAC256(password+salt);
        JWTVerifier jwtVerifier = JWT.require(algorithm).withClaim("userId", userId).build();
        try {
            jwtVerifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("---- failed to verify token ----", e.getMessage());
            return false;
        }
    }

    public static int getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asInt();
        } catch (JWTDecodeException e) {
            return -1;
        }
    }

    public static String createToken(int userId, String password, String salt) {
   
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(password + salt);
        try {
            return JWT.create().withClaim("userId", userId).withExpiresAt(date).sign(algorithm);
        } catch (JWTCreationException e) {
            return null;
        }
    }

    public static String salt() {
        StringBuffer salt = new StringBuffer();
        Random random = new Random();
        for(int i=0;i<6;i++){
            salt.append(BASE.charAt(random.nextInt(35)));
        }
        return salt.toString();
    }
}
