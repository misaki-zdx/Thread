package com.thread.study;

/**
 * Author Misaki
 * Create By 2018/5/26
 */
public class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted." + "isInterrupted()" + interrupted());
            return;
        }
        System.out.println(getName() + "has awakened");
    }
}
