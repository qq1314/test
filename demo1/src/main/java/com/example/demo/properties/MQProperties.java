package com.example.demo.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: cjq
 * @Date: 2018/9/27 09:15
 * @Description:
 * @version:V1.0
 */
@Data
@Component
public class MQProperties {
    @Value("}mq.defaultExchange}")
    private String defaultExchange;
    @Value("${mq.routeKey}")
    private String routeKey;
    @Value("${mq.queue}")
    private String queue;

}
