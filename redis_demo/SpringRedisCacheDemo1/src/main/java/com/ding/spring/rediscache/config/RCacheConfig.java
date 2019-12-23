package com.ding.spring.rediscache.config;

import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/1/11
 */
@EnableCaching
@Configuration
public class RCacheConfig {

    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient) throws IOException {
        Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
//        config.put(CacheNames.PhoneAreacodeDetecRepository_findByPhone, new CacheConfig(3600 * 1000, 3600 * 1000));
//        config.put(CacheNames.ThirdPartyUserService_findById, new CacheConfig(3600 * 1000, 3600 * 1000));
//        config.put(CacheNames.OwnCloud_dirExist, new CacheConfig(1800 * 1000, 1800 * 1000));
        return new RedissonSpringCacheManager(redissonClient, config);
    }
}