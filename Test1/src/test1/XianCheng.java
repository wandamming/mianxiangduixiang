package test1;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class XianCheng {
    public static void main(String[] args) {
        Runnable1 runnable1 = new Runnable1();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);

        thread1.setName("yi");
        thread2.setName("er");

        thread1.start();
        thread2.start();

    }
}


//class Runnable1 implements Runnable{
//    private static int i = 0;
//    @Override
//    public void run() {
//        synchronized (Runnable1.class) {
//            for (int j = 0; j < 100; j++) {
//                try {
//                    System.out.println(Thread.currentThread().getName()+" : "+(i++));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}

class Runnable1 implements Runnable{
    private static int i = 0;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

                try {
                    lock.lock();
                    for (int j = 0; j < 50; j++) {
                    System.out.println(Thread.currentThread().getName()+" : "+(i++));}
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
    }
}