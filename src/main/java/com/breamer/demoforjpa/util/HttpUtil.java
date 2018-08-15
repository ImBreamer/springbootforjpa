package com.breamer.demoforjpa.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HTTP工具类
 * @author zhang.penghao
 * @date 2018/7/11 11:37
 */
public class HttpUtil {
    private final static Logger logger = Logger.getLogger(HttpUtil.class);
    public static void putResponseData(HttpServletResponse resp, String data){
        try {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.setHeader("Cache-Control", "no-store");
            resp.getWriter().write(data);
            resp.getWriter().close();
        } catch (IOException e) {
            logger.error("putResponseData failed...", e);
        }
    }
}
