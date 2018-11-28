package com.example.demo.exception;

import com.example.demo.pojo.Result;
import com.example.demo.util.ResultUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: cjq
 * @Date: 2018/9/26 10:40
 * @Description:
 * @version:V1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalDefultExceptionHandler {

    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public <T> Result<?> defultExcepitonHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof BusinessException) {
            log.error("业务异常：" + e.getMessage(),e);
            BusinessException businessException = (BusinessException) e;
            return ResultUtil.error(businessException.getCode(), businessException.getMessage());
        }
        //未知错误
        return ResultUtil.error(-1, "系统异常：" + e);
    }

}
