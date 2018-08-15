package com.breamer.demoforjpa.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @Description Druid的Servlet
 * @author zhang.penghao
 * @date 2018年5月7日
 * @version 1.0
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
initParams={
        //@WebInitParam(name="allow",value="127.0.0.1,192.168.7.1,192.168.15.32"),// IP白名单 (没有配置或者为空，则允许所有访问
        @WebInitParam(name="loginUsername",value="root"),// 用户名
        @WebInitParam(name="loginPassword",value="uboat!1214"),// 密码
        @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {

}
