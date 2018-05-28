package com.thread.study;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Author Misaki
 * Create By 2018/5/26
 */

//Runnable��ִ�й����Ķ������� ����û���κη���ֵ ϣ����������ɵ�ʱ���з���ֵ����ʵ�� callable�ӿ�
//����ʹ��ExecutorService.submit()�����ύ

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

    //���͵������Ǵ˷����ķ�������
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
