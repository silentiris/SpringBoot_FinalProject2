package com.tjut.util.jwtUtil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tjut.pojo.po.UserPo;

import java.util.Date;

public class JwtUtils {
    public static final long EXPIRE_TIME = (long) 1000*60*60*24*15;
    public static final String SECRET = "SECRET";

    public static String sign(UserPo userPo){
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return JWT.create()
                .withClaim("username",userPo.getUsername())
                .withClaim("password", userPo.getPassword())
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT decodedJWT  = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static String getUserNameByToken(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("username").asString();
    }

    public static UserPo getUserByToken(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        UserPo userPo = new UserPo();
        userPo.setUsername(decodedJWT.getClaim("username").asString());
        userPo.setPassword(decodedJWT.getClaim("password").asString());
        return userPo;
    }

}