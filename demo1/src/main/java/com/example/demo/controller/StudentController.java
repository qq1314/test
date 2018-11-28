package com.example.demo.controller;

import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResultEnum;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.Student;
import com.example.demo.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: cjq
 * @Date: 2018/7/18 19:24
 * @Description:
 * @version:V1.0
 */
@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    protected StudentMapper studentMapper;

    @RequestMapping("/list")
    public String listStudent(Model model) {
        try {
            List<Student> students = studentMapper.findAll();
            model.addAttribute("students", students);
            int a = 1/0;
        } catch (Exception e) {
            throw new BusinessException(ResultEnum.ERROR);
        }
        return "listStudent";
    }
    @ResponseBody
    @RequestMapping("/listR")
    public Result listStudentResponseBody(Model model) {
        try {
            List<Student> students = studentMapper.findAll();
            model.addAttribute("students", students);
            int a = 1/0;
            return ResultUtil.success(students);
        } catch (Exception e) {
//            log.error("查询学生列表出错",e);
            throw new BusinessException(-2,"查询学生列表出错！");
        }

    }
}
