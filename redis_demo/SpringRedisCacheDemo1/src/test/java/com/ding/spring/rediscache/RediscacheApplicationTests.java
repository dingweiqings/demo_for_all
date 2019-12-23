package com.ding.spring.rediscache;

import com.ding.spring.rediscache.entity.RedisTest;
import com.ding.spring.rediscache.repository.RedisTestRepo;
import com.ding.spring.rediscache.service.RedisTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

@RunWith(SpringRunner.class)
//指定springboot test的类型
@SpringBootTest(classes = RediscacheApplication.class)
//指定profiles,三者缺一不可
@ActiveProfiles("dev")
public class RediscacheApplicationTests {

    @Autowired
    RedisTestService redisTestService;
    @Test
    public void testGetCache() throws InterruptedException {
        System.out.println(redisTestService.findByName("kurt"));
        Thread.sleep(3000);
    }
}

