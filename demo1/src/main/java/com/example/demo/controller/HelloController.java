package com.example.demo.controller;

import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/helloController")
public class HelloController {

    @Value("${name}")
    private String name ;

    @RequestMapping("/hello")
    public String hello(Model model) {
        try {
            this.name = "池佳齐";
            model.addAttribute("name",this.name);
            int a = 1/0;
        } catch (Exception e) {
//            log.error("业务异常！",e);
            throw new BusinessException(ResultEnum.ERROR);
        }
        return "hello";
    }
}
