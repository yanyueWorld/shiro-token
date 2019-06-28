package com.example.Util;

import io.jsonwebtoken.Jwt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

/**
 * JWTUtilTest.
 *
 * @author yanyue, 2019/6/28
 * @version shiro v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTUtilTest {

    @Test
    public void verify() {
        String token=JWTUtil.createToken(1,"123456","123");
        System.out.println(JWTUtil.verify(token,1,"123456","123"));
    }

    @Test
    public void getUserId() {
        String token=JWTUtil.createToken(1,"123456","123");
        System.out.println(JWTUtil.getUserId(token));
    }

    @Test
    public void createToken() {
        String token=JWTUtil.createToken(1,"123456","123");
        System.out.println(token);

    }

    @Test
    public void salt() {
        String salt=JWTUtil.salt();
        System.out.println(salt);
    }

}