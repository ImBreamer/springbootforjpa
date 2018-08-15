package com.breamer.demoforjpa.entity.primary;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 用户测试表
 * @author breamer
 * @date 2018/7/25 14:16
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "姓名", name = "userName", required = true)
    @Column(name = "user_name")
    private String userName;
    @ApiModelProperty(value = "密码", name = "userPassword", required = true)
    @Column(name = "user_password")
    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
