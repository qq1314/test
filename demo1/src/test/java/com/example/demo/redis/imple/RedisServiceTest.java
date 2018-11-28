package com.example.demo.redis.imple;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Student;
import javafx.application.Application;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @Auther: cjq
 * @Date: 2018/8/23 20:08
 * @Description:
 * @version:V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    protected StudentMapper studentMapper;

    private static final String key = "springboot1219";

    @Test
    public void set() {
        //如果缓存存在
        boolean hasKey = redisService.exists(key.concat("123"));
        if (hasKey) {
            //获取缓存
            Object object = redisService.get(key.concat("123"));
            log.info("从缓存获取的数据" + object);

        } else {
            //从DB中获取信息
            log.info("从数据库中获取数据");
            Student student = studentMapper.selectByPrimaryKey(1);//根据ID查询，因为是测试，就直接写了id为1011
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisService.set(key.concat(student.getStudentId()), student, 10L, TimeUnit.MINUTES);
            log.info("数据插入缓存" + student.toString());
        }

    }

    @Test
    public void remove() {
    }

    @Test
    public void zSetAdd() {

        redisService.zAdd("test1", "a", 1);
        redisService.zAdd("test1", "b", 2);
        redisService.zAdd("test1", "c", 3);
        redisService.zAdd("test1", "d", 4);

    }

    @Test
    public void zSetGet() {
        Long aLong = redisService.ZsetRemove("test1", "b");
        System.out.println("从zSet中删除："+aLong);
        Set<Object> test1 = redisService.rangeByScore("test1", 1, 4);
        System.out.println("zSet获取：" + test1);

    }
    @Test
    public void zSetDelete() {
        redisService.remove("test1");
    }
    @Test
    public void hash() {
        redisService.hmSet("testHash","a","1");
        redisService.hmSet("testHash","b","1");
        redisService.hmSet("testHash","c","1");

    }
}