package com.breamer.demoforjpa.service;

import com.breamer.demoforjpa.entity.secondary.Student;

import java.util.List;

/**
 * @author breamer
 * @Description:
 * @date 2018/7/25 14:45
 */
public interface StudentService {
    List<Student> studentList();
    Student addStudent(Student student);

}
