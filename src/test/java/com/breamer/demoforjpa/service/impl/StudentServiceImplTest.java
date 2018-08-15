package com.breamer.demoforjpa.service.impl;

import com.breamer.demoforjpa.dao.secondary.StudentDAO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author breamer
 * @date 2018/7/26 14:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    @Autowired
    private StudentDAO studentDao;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void put(){
        redisTemplate.opsForValue().set("breamer:test","1419",30 , TimeUnit.SECONDS);
    }

    @Test
    public void get(){
        System.out.println("************************************************");
        System.out.println(redisTemplate.opsForValue().get("breamer:test"));
    }
}