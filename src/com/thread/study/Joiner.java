package com.thread.study;

/**
 * Author Misaki
 * Create By 2018/5/26
 */
public class Joiner extends Thread {
    private Sleeper sleeper;

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("one", 2000);
        sleeper.interrupt();
        Joiner joiner = new Joiner("JoinerOne", sleeper);
    }

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join(2000);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        System.out.println(getName() + "join completed");
    }
}
