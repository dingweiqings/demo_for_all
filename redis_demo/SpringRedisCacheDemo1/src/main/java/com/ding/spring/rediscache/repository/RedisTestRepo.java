package com.ding.spring.rediscache.repository;

import com.ding.spring.rediscache.entity.RedisTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/1/11
 */
public interface RedisTestRepo extends JpaRepository<RedisTest,String> {
    List<RedisTest> findByName(String name);
}
