package com.ding.spring.rediscache.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/1/11
 */
@Entity
@Table(name = "kurt_redis_test")
public class RedisTest {
    @Id
    @GenericGenerator(name = "generator",strategy ="uuid" )
    @GeneratedValue
    private String id;
    private String name;
    private Date createTime;
    private double money;

    @Override
    public String toString() {
        return "RedisTest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", money=" + money +
                '}';
    }
}
