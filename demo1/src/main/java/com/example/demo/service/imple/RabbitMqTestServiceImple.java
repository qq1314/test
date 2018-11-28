package com.example.demo.service.imple;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.pojo.Student;
import com.example.demo.properties.MQProperties;
import com.example.demo.service.IRabbitMqTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cjq
 * @Date: 2018/9/26 17:15
 * @Description:
 * @version:V1.0
 */
@Component
@Slf4j
public class RabbitMqTestServiceImple implements IRabbitMqTestService {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MQProperties mqProperties;
    @Override
    public void send() {
        List<Map<String,Object>> msg = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("one",1);
        map.put("two","two");
        map.put("three",new Student("3","three"));
        for (int i = 0; i < 10; i++) {
            msg.add(map);
        }
        String o = JSONArray.toJSONString(msg);
        rabbitTemplate.convertAndSend(mqProperties.getDefaultExchange(),
                mqProperties.getRouteKey(), o);
        log.info("消费内容为：{}", o);
    }
}
