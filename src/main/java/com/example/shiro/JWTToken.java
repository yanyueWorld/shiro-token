package com.example.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JWTToken.
 *
 * @author yanyue, 2019/6/27
 * @version shiro v1.0
 */
public class JWTToken implements AuthenticationToken {

    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
