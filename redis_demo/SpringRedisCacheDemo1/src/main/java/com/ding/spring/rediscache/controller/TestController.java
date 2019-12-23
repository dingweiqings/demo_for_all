package com.ding.spring.rediscache.controller;

import com.ding.spring.rediscache.bean.SearchBean;
import com.ding.spring.rediscache.entity.RedisTest;
import com.ding.spring.rediscache.service.RedisTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/1/11
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    RedisTestService redisTestService;

    @GetMapping("/string")
    //当执行到这个方法的时候，aop有个root对象，能拿到当前方法名，
    //于是在执行这个方法的时候，先去判断是否有缓存
    public String getObject(HttpServletRequest request, @RequestParam String name) {
        List<RedisTest> list=redisTestService.findByName(name);
        LOGGER.info("List {}",list);
        return list.toString();
    }
    @GetMapping("/bean")
    public String getObjectBean(HttpServletRequest request, SearchBean bean) {
        List<RedisTest> list=redisTestService.findBySearchBean(bean);
        LOGGER.info("List {}",list);
        return list.toString();
    }
}
