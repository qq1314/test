package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: cjq
 * @Date: 2018/9/26 17:15
 * @Description:
 * @version:V1.0
 */
public interface IRabbitMqTestService {


    public void send();
}

