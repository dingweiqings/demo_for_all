package com.ding.spring.rediscache.service.impl;

import com.ding.spring.rediscache.bean.SearchBean;
import com.ding.spring.rediscache.entity.RedisTest;
import com.ding.spring.rediscache.repository.RedisTestRepo;
import com.ding.spring.rediscache.service.RedisTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/1/11
 */
@Service
public class RedisTestServiceImpl implements RedisTestService {
    private final static Logger LOGGER=LoggerFactory.getLogger(RedisTestServiceImpl.class);
    @Autowired
    RedisTestRepo redisTestRepo;
    @Override
    public List<RedisTest> findByName(String name) {
        LOGGER.info("find from db");
        List<RedisTest> list=redisTestRepo.findByName(name);

        return list;
    }

    @Override
    public List<RedisTest> findBySearchBean(SearchBean bean) {

        LOGGER.info("find from db");
        List<RedisTest> list=redisTestRepo.findByName(bean.getName());

        return list;
    }
}
