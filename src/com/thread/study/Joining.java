package com.thread.study;

/**
 * Author Misaki
 * Create By 2018/5/26
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("one", 3000);
        sleeper.interrupt();
        Joiner joiner = new Joiner("JoinerOne", sleeper);
    }
}
