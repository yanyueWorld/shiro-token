package com.example.shiro;

import com.example.Util.JWTUtil;
import com.example.service.RealmService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * JWTRealm.
 *
 * @author yanyue, 2019/6/27
 * @version Araf v1.0
 */
public class JWTRealm extends AuthorizingRealm {
    @Autowired
    private RealmService realmService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginToken= (String) token.getCredentials();
        int userId= JWTUtil.getUserId(loginToken);
        if(userId==-1){
            throw new AuthenticationException("invalid token");
        }


        return null;
    }
}
