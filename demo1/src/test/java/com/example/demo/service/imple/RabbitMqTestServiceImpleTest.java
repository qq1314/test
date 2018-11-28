package com.example.demo.service.imple;

import com.example.demo.service.IRabbitMqTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: cjq
 * @Date: 2018/9/26 17:35
 * @Description:
 * @version:V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RabbitMqTestServiceImpleTest {

    @Autowired
    private IRabbitMqTestService rabbitMqTestServiceImple;
    @Test
    public void TestRabbitMQ () {

        rabbitMqTestServiceImple.send();

    }

}