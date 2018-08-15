package com.breamer.demoforjpa.entity.secondary;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 学生测试表
 * @author breamer
 * @date 2018/7/25 14:22
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "学生姓名", name = "studentName", required = true)
    @Column(name = "s_name")
    private String studentName;
    @ApiModelProperty(value = "学生年龄", name = "studentAge", required = true)
    @Column(name = "s_age")
    private Integer studentAge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }
}
