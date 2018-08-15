package com.breamer.demoforjpa.controller;

import com.breamer.demoforjpa.entity.secondary.Student;
import com.breamer.demoforjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author breamer
 * @Description:
 * @date 2018/7/25 14:49
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/add", method=RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> addUser(@ModelAttribute Student student) {
        boolean insertResult = studentService.addStudent(student).getId() > 0 ? true : false;

        Map<String, Object> result = new HashMap<>(16);
        result.put("status",insertResult);
        result.put("msg",insertResult ? "success" : "fail");
        if(false){
            throw new RuntimeException("hello rollback");
        }
        return result;
    }
}
