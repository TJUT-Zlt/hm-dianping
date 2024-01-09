package com.hmdp.utils;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * redis工具类
 */
@Data
public class RedisData {
    private LocalDateTime expireTime;
    private Object data;
}
