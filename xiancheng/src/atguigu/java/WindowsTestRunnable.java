package atguigu.java;

import static java.lang.Thread.sleep;

/**
 * 1、问题：买票过程中出现了重票，错票  -->出现了线程安全问题
 * 2、出现问题原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
 * 3、如何解决：当一个线程在操作共享数据的时候，其他线程不能参与景来，直到线程a操作完，其他
 *            线程才可以操作此共享数据，这种情况即使线程a出现了阻塞，也不能被改变。
 * 4、在java中，通过同步机制解决线程安全问题。
 *      方式一：同步代码块
 *      synchronized(同步监视器){
 *          //需要被同步的代码
 *      }
 *      说明: ①操作共享数据的代码，即为需要被同步的代码
 *           ②共享数据：多个线程共同操作的变量，比如：ticket
 *           ③同步监视器，俗称：锁。任何一个类的对象，都可以充当锁
 *              要求：多个线程必须要共用同一把锁
 *
 *            补充：在实现Runnable接口创建多线程方式中，可以考虑使用this充当同步监视器
 *                  在继承Thread类创建多线程的方式中，慎用this充当同步监视器，可以考虑当前类来充当同步监视器（Window.class）
 *      方式二：同步方法
 *          ①如果操作共享数据的代码完整的声明咋一个方法中，将此方法声明为同步的。
 *          ②非静态的同步方法，同步监视器是：this
 *            静态的同步方法，同步监视器是：当前类本身
 * 5、同步的方式，解决了线程安全问题。 --> 好处
 *    操作同步代码时只能有一个线程参与，其他线程等待：相当于是一个单线程过程，效率低。 ---> 局限性
 */
public class WindowsTestRunnable {
    public static void main(String[] args) {

        Windows2 windows2 = new Windows2();
//        Windows1 windows1 = new Windows1();

        Thread t1 = new Thread(windows2);
        Thread t2 = new Thread(windows2);
        Thread t3 = new Thread(windows2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}

//方式一：同步代码块
class Windows1 implements Runnable{

    private int ticket1 = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {
            synchronized (this) {  //此时的this：唯一的Windows1的对象
                if (ticket1 > 0) {
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket1);
                    ticket1--;
                } else {
                    break;
                }
            }
        }
    }
}

//方式二：同步方法
class Windows2 implements Runnable{

    private int ticket2 = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {   //同步监视器为this
        if (ticket2 > 0) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket2);
            ticket2--;
        }
    }
}