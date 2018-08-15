package com.breamer.demoforjpa.controller;

import com.breamer.demoforjpa.entity.primary.User;
import com.breamer.demoforjpa.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author breamer
 * @Description:
 * @date 2018/7/25 14:49
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public Map<String, Object> userList(){
        List<User> users = userService.userList();
        //int i = 1/0;
        Map<String, Object> result = new HashMap<>(16);
        result.put("status",true);
        result.put("msg","success");
        result.put("data",users);

        return result;
    }
    @RequestMapping(value="/listById", method=RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", dataType = "Integer")
    public Map<String, Object> listById(Integer id){
        List<User> users = userService.listUserByID(id);
        //int i = 1/0;
        Map<String, Object> result = new HashMap<>(16);
        result.put("status",true);
        result.put("msg","success");
        result.put("data",users);

        return result;
    }
    @RequestMapping(value="/listByName", method=RequestMethod.GET)
    @ApiImplicitParam(name = "name", value = "用户名称", paramType = "query", dataType = "String")
    public Map<String, Object> listByName(String name){
        List<User> users = userService.listUserByName(name);
        //int i = 1/0;
        Map<String, Object> result = new HashMap<>(16);
        result.put("status",true);
        result.put("msg","success");
        result.put("data",users);

        return result;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> addUser(@ModelAttribute User user) {
        boolean insertResult = userService.addUser(user).getId() > 0 ? true : false;

        Map<String, Object> result = new HashMap<>(16);
        result.put("status",insertResult);
        result.put("msg",insertResult ? "success" : "fail");
        if(false){
            throw new RuntimeException("hello rollback");
        }
        return result;
    }
}
