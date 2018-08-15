package com.breamer.demoforjpa.service.impl;

import com.breamer.demoforjpa.dao.primary.UserDAO;
import com.breamer.demoforjpa.entity.primary.User;
import com.breamer.demoforjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author breamer
 * @date 2018/7/25 14:46
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;


    @Override
    public List<User> userList() {
        return userDao.findAll();
    }

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> listUserByID(Integer id) {
        return userDao.listUserByID(id);
    }

    @Override
    public List<User> listUserByName(String name) {
        return userDao.listUserByName(name);
    }
}
