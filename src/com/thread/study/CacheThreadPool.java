package com.thread.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author Misaki
 * Create By 2018/5/26
 */
public class CacheThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
