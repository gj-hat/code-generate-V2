package com.jiaguo.codegenerategraduation.config.security.jwtManager;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jiaguo.codegenerategraduation.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/27 22:59
 * @description： jwt工具类
 * @modified By：
 * @version: 1.0
 */
public class JwtManager {


    /**
     * 生成jtw
     * @param claims token中要存放的数据（json格式）
     * @return
     */
    public static String builderToken(Map<String, Object> claims) {
        final Date now = new Date();
        return Jwts.builder()
                .setId(getUUID())
                .setIssuer(Constants.JWT_ISSUER)
                .setSubject(Constants.JWT_SUBJECT)
                .setAudience(Constants.JWT_AUDIENCE)
                .setNotBefore(now)
                .setExpiration(expirdateDate())
                .setIssuedAt(now)
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, Constants.JWT_KEY)
                .compact();
    }
    public static Date expirdateDate() {
        return new Date(System.currentTimeMillis() + Constants.JWT_TTL * 1000);
    }


    /**
     * 解析 token 内容体
     *
     * @param token
     * @return
     */
    public static Claims parse(String token) {
        return Jwts.parser()
                .setSigningKey(Constants.JWT_KEY)
                .parseClaimsJws(token)
                .getBody();
    }


    /**
     * 生成claims
     * @param userDetails
     * @param type
     * @return
     */
    public static Map<String, Object> builderClaims(UserDetails userDetails, String type) {
        // 如果type为空，则默认为web端登录
        if (StringUtils.isBlank(type)) {
            type = "";
        }
        JwtUser user = (JwtUser) userDetails;
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.JWT_KEY_ACCOUNT, userDetails.getUsername());
        claims.put(Constants.JWT_KEY_NICKNAME, user.getNickname());
        claims.put(Constants.JWT_KEY_USERID, user.getId());
        claims.put(Constants.JWT_KEY_TYPE, type);
        return claims;
    }






    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }



    public static void main(String[] args) throws Exception {
//        HashMap<String, Object> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("name", "JiaGuo");
//        stringStringHashMap.put("age", "18");
//
//        String jiaguo = builderToken(stringStringHashMap);
//
//        System.out.println("jiaguo = " + jiaguo);

        Claims claims = parse("eyJhbGciOiJIUzUxMiJ9.eyJuaWNrbmFtZSI6IumDreWwj-WCuyIsImlkIjoxLCJ0eXBlIjoiIiwiYWNjb3VudCI6ImFkbWluIn0.urVOqVmgiHADZ_uonHIAj6djmPRfVzxfaJmREKmvIOBAmA84joPm_INw0mxZoHhcxhG7rZqpM0enXhQrN09YZA");
        System.out.println(claims);

    }











}














