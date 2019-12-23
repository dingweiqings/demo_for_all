package com.ding.spring.rediscache.service;

import com.ding.spring.rediscache.bean.SearchBean;
import com.ding.spring.rediscache.entity.RedisTest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/1/11
 */
public interface RedisTestService {

    //@Cacheable 注解，
    //value 是redis map的名称，key是map内部的key
    //前面两个是限定这个缓存的键
    @Cacheable(value = "kurttest",key = "#name")

    //意思是当name为test时清空这个key的缓存
    @CacheEvict(value = "kurttest",key = "'kurt'",condition = "#name=='test'")
    List<RedisTest> findByName(String name);

    @Cacheable(value = "searchbean",key = "#bean.toString()")
   // @CacheEvict(value = "searchbean",key = "#bean.toString()",condition = )
    List<RedisTest> findBySearchBean(SearchBean bean);
}
