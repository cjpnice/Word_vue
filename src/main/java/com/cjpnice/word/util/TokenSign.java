package com.cjpnice.word.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenSign {

    /**
     * 过期时间60分钟
     */
    private static final long EXPIRE_TIME=60 * 60 *1000;

    /**
     * 私钥，使用它生成token，最好进行下加密
     */
    private static final String TOKEN_SECRET="Token";


    /**
     * 产生token
     * @param useName
     * @param userId
     * @return
     */
    public static String sign(String useName,String password){

        try{

            //设置15分钟失效
            Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            //私钥及加密算法
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header=new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //附带username和userid信息,存储到token中，生成签名
            return JWT.create()
                    .withHeader(header)
                    //存储自己想要留存给客户端浏览器的内容
                    .withClaim("userName",useName)
                    .withClaim("userId",password)
                    .withExpiresAt(date)
                    .sign(algorithm);



        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    /**
     * token校验是否正确
     * @param token
     * @return
     */

    public static boolean verify(String token){

        try {
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);

            JWTVerifier verifier =JWT.require(algorithm).build();
            //此方法若token验证失败会抛错的，所以直接return true没问题
            DecodedJWT decodedJWT =verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }


    /**
     * 获取token中信息 userName
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        } catch (JWTDecodeException e) {
            e.getStackTrace();
        }
        return null;
    }


    /**
     * 获取token中信息 userId
     * @param token
     * @return
     */
    public static String getPassword(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("password").asString();
        } catch (JWTDecodeException e) {
            e.getStackTrace();

        }
        return null;
    }


}

