package com.example.demo2.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo2.Student;
import com.example.demo2.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cjq
 * @Date: 2018/9/27 09:58
 * @Description:
 * @version:V1.0
 */
@Service
@Slf4j
public class RabbitMQService {

    @Value("${mq.queue}")
    private String queues;
    @RabbitListener(queues = "queue")
    public void receive(Message payload, Channel channel,
                        @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("消费内容为：{}", new String(payload.getBody()));
        List<Map> maps = JSONArray.parseArray(new String(payload.getBody()), Map.class);
        for (Map map : maps) {
            System.out.println(map.get("one"));
            System.out.println(map.get("two"));
            Student student = JSON.parseObject(map.get("three").toString(), Student.class);
            System.out.println(student.toString());
        }
        RabbitMQUtils.askMessage(channel, tag, log);
    }

}
