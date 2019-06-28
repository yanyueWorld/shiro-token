package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.pojo.Permission;
import com.example.pojo.Role;
import com.example.pojo.User;
import com.example.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * RealmServiceImpl.
 *
 * @author yanyue, 2019/6/27
 * @version shiro v1.0
 */
public class RealmServiceImpl implements RealmService {
    @Autowired
    private UserDao userDao;

    private User getUser(String username) {
        if (username == null || username.length() == 0) {
            return null;
        }
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public String getPassword(String username) {
        String password = getUser(username).getPassword();
        if (password == null || password.length() == 0) {
            return null;
        }
        return password;
    }

    @Override
    public String getSalt(String username) {
        String salt = getUser(username).getPassword();
        if (salt == null || salt.length() == 0) {
            return null;
        }
        return salt;
    }

    @Override
    public List<Role> getRoles(String username) {
        List<Role> roles = getUser(username).getRoles();
        if (roles == null || roles.size() == 0) {
            return null;
        }
        return roles;
    }

    @Override
    public Set<Permission> getPermisions(String username) {
        if (username == null || username.length() == 0) {
            return null;
        }
        Set<Permission> permissions = new HashSet<>();
        for (Role role : getRoles(username)) {
            for (Permission permission : role.getPermissions()) {
                permissions.add(permission);
            }
        }
        if (permissions == null || permissions.size() == 0) {
            return null;
        }
        return permissions;
    }

    @Override
    public int getUserId(String username) {
        if (username==null||username.length()==0){
            return -1;
        }
        int userId=getUser(username).getId();
        return userId;
    }
}
