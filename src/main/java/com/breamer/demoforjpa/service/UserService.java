package com.breamer.demoforjpa.service;

import com.breamer.demoforjpa.entity.primary.User;
import com.breamer.demoforjpa.entity.secondary.Student;

import java.util.List;

/**
 * @author breamer
 * @Description:
 * @date 2018/7/25 14:45
 */
public interface UserService {
    List<User> userList();
    /**
     * 功能描述:
     * @author zhang.penghao
     * @date 2018/7/11 17:04
     * @param user 用户
     * @return int
     */
    User addUser(User user);

    List<User> listUserByID(Integer id);
    List<User> listUserByName(String name);
}
