package com.cc.mutilthread.test;

import java.util.concurrent.*;

public class ExecuteServiceTest1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(new CalCallable(10));
        Future<Integer> future2 = executorService.submit(new CalCallable(100));
        Future<Integer> future3 = executorService.submit(new CalCallable(1000));
        Future<Integer> future4 = executorService.submit(new CalCallable(10000));
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        });
        try {
            System.out.println(future.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
            System.out.println(future4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("hello world");
        executorService.shutdown();
    }


}

class CalCallable implements Callable<Integer>{

    int num;
    public CalCallable(int num){
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=0;i<num;i++){
            sum += i;
        }
        return sum;
    }
}
