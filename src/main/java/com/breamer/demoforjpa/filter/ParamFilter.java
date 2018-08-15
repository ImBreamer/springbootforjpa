package com.breamer.demoforjpa.filter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器配置
 * @author zhang.penghao
 * @date: 2018/7/11 11:38
 */
@Component
@WebFilter(filterName = "my2Filter" ,urlPatterns = "/*")
public class ParamFilter implements Filter {
    private final static Logger logger = Logger.getLogger(ParamFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


            if(false){
                throw new RuntimeException("test");
            }
            filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }
}
