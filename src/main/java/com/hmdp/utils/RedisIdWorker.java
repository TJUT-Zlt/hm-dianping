package com.hmdp.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * ClassName:RedisWorker
 * Package:com.hmdp.utils
 * Description: 全局ID生成器
 *
 * @Author abel
 * @Create 2023-12-03 14:26
 * @Version 1.0
 */
@Component
public class RedisIdWorker {
    /**
     * 考试时间戳 2023年1月1号0时0分0秒
     */
    private static final long BEGIN_TIMESTAMP = 1672531200;
    /**
     * 序列号为位数
     */
    private static final int COUNT_BITS = 32;

    private  StringRedisTemplate stringRedisTemplate;

    public RedisIdWorker(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public long nextId(String keyPrefix){
        // 1.生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timestamp = nowSecond - BEGIN_TIMESTAMP;
        // 2. 生成序列号
        // 2.1.获取当前日期，精确到天
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        // 2.2.自增长
        long count = stringRedisTemplate.opsForValue().increment("icr:"+keyPrefix+":"+date);
        // 3.拼接并返回 位运算
        return timestamp << COUNT_BITS | count;
    }

//    public static void main(String[] args) {
//        LocalDateTime time = LocalDateTime.of(2023,1,1,0,0,0);
//        long second = time.toEpochSecond(ZoneOffset.UTC);
//        System.out.println(second);
//        LocalDateTime now = LocalDateTime.now();
//        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
//        System.out.println(date);
//    }
}
