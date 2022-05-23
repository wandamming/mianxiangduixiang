package atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方法四：使用线程池
 */

public class ThreadPool {
    public static void main(String[] args) {

        //1、提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;   //强转

        //设置线程池的属性
        service1.setCorePoolSize(15);


        //2、执行指定的线程的操作，需要提供实现Runnable接口或者Callable接口实现类的对象
        service.execute(new NumberThread());  //适用于Runnable
        service.execute(new NumberThread1());

//        service.submit();   //适用于Callable

        service.shutdown();  //3、关闭线程池



    }
}

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}










