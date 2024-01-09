package com.hmdp.utils;

/**
 * ClassName:ILock
 * Package:com.hmdp.utils
 * Description:
 *
 * @Author abel
 * @Create 2023-12-03 21:01
 * @Version 1.0
 */
public interface ILock {
    /**
     * 尝试获取锁
     * @param timeoutSec 锁持有的超时时间，过期后自动释放
     * @return true代表获取锁成功; false代表获取锁失败
     */
    boolean tryLock(long timeoutSec);

    /**
     * 释放锁
     */
    void unLock();
}
