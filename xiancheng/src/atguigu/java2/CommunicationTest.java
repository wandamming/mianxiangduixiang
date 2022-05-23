package atguigu.java2;

/**
 * 线程通信的例子：使用两个线程打印1-100，线程1，线程2，交替打印
 *
 * 涉及到的三个方法：
 * wait(): 一旦执行此方法，当前线程就进入阻塞状态
 * notify():一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就会唤醒优先级高的那个
 * notifyAll():一旦执行此方法，唤醒所有被wait的所有线程
 *
 * 说明：
 * 1、wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中
 * 2、wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步代码块中的同步监视器，
 *    否则会出现异常：IllegalMonitorStateException
 * 3、wait()，notify()，notifyAll()三个方法定义在Object类中。
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{

    Object obj = new Object();

    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (obj) {

                obj.notify();

                if (number < 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                    number++;

                    try {
                        //使得调用如下方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }
    }
}