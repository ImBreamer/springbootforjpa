package com.breamer.demoforjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * APP主程序入口
 * @author zhang.penghao
 * @date 2018/7/25 14:52
 */
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan("com.breamer.demoforjpa.druid")
public class DemoforjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoforjpaApplication.class, args);
    }
}
