package com.example.service;

import com.example.pojo.Permission;
import com.example.pojo.Role;

import java.util.List;
import java.util.Set;

/**
 * //TODO description end with .
 *
 * @author yanyue, 2019/6/27
 * @version Araf v1.0
 */
public interface RealmService {
    String getPassword(String username);

    String getSalt(String username);

    List<Role> getRoles(String username);

    Set<Permission> getPermisions(String username);

    int getUserId(String username);
}
