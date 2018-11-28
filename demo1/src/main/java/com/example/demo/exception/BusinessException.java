package com.example.demo.exception;

import lombok.Data;

/**
 * @Auther: cjq
 * @Date: 2018/9/26 10:42
 * @Description:
 * @version:V1.0
 */
@Data
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Integer code;  //错误码

    private String message; //错误信息
    public BusinessException() {}

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

