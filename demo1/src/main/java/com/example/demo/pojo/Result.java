package com.example.demo.pojo;

import lombok.Data;

/**
 * * http请求做外层对象
 * @Auther: cjq
 * @Date: 2018/9/26 10:58
 * @Description:
 * @version:V1.0
 */
@Data
public class Result<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    //get和set省略


}
