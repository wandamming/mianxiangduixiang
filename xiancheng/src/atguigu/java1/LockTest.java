package atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方法三：Lock锁   ---JDK5.0新增
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}


class Window implements Runnable{

    private int ticket = 100;

    //1、实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();  //ctrl +p

    @Override
    public void run() {
        while(true){
            try {

                //调用lock
                lock.lock();

                if(ticket > 0){

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            } finally {
                //调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}