package com.breamer.demoforjpa.service.impl;

import com.breamer.demoforjpa.dao.secondary.StudentDAO;
import com.breamer.demoforjpa.entity.secondary.Student;
import com.breamer.demoforjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author breamer
 * @Description:
 * @date 2018/7/25 15:44
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDao;

    @Override
    public List<Student> studentList(){
        return studentDao.findAll();
    }

    @Override
    public Student addStudent(Student student){
        return studentDao.save(student);
    }


}
