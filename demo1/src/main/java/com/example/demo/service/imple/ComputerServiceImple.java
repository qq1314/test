package com.example.demo.service.imple;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.service.ComputeService;

/**
 * @Auther: cjq
 * @Date: 2018/7/26 19:37
 * @Description:
 * @version:V1.0
 */

@Service(version = "1.0.0")
public class ComputerServiceImple implements ComputeService {

    @Override
    public String add(String str) {

        return "dubboTest:"+str;
    }
}
