package com.example.dao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * //TODO description end with .
 *
 * @author yanyue, 2019/6/27
 * @version Araf v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class userDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void selectByPrimaryKey() {
        System.out.println(userDao.selectByPrimaryKey(1));
    }
}