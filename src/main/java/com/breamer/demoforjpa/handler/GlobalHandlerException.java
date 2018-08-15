package com.breamer.demoforjpa.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理
 * @author zhang.penghao
 * @date 2018/7/11 11:37
 */
@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Map<String, Object> handlerException(HttpServletRequest request, Exception e){
        Map<String, Object> result = new HashMap<>(16);
        result.put("status",false);
        result.put("msg",e.getMessage());
        return result;
    }
}
