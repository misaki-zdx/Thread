package com.thread.study;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Author Misaki
 * Create By 2018/5/26
 */

//Runnable是执行工作的独立任务 但他没有任何返回值 希望任务在完成的时候有返回值可以实现 callable接口
//必须使用ExecutorService.submit()方法提交

public class TaskWithResult implements Callable<String> {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            result.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fu : result) {
            try {
                System.out.println(fu.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    //泛型的类型是此方法的返回类型
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
