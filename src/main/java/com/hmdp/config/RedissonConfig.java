package com.hmdp.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:RedissonConfig
 * Package:com.hmdp.config
 * Description:
 *
 * @Author abel
 * @Create 2023-12-05 17:10
 * @Version 1.0
 */
@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redissonClient(){
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.154.128:6379").setPassword("123456");
        // 创建RedissonClient对象
        return Redisson.create(config);
    }
}
