package atguigu.java;

/**
 * 测试Thread中的常用方法
 * 1、start() ：启用当前线程；调用当前线程run
 * 2、run() ： 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3、currentThread() ： 静态方法，返回执行当前代码的线程
 * 4、getName()
 * 5、setName()
 * 6、yield():释放当前CPU的执行权
 * 7、join():在线程a中调用线程b的join（），此线程a就进入阻塞状态，知道b完全执行完后，线程a才结束阻塞状态
 * 8、stop():强制执行当前线程 ，此方法已过时
 * 9、sleep(long millitime:)
 */

public class ThreadMethodTest {
    public static void main(String[] args) {


        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        HelloThread h1 = new HelloThread("线程一");


        //设置线程优先级
        h1.setPriority(Thread.MAX_PRIORITY);

//        h1.setName("线程一");
        h1.start();

        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ "   :   " + i);
            }
//            if(i == 20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(h1.isAlive());

    }

}


class HelloThread extends Thread{
    public HelloThread(String name){   //利用构造器命名
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+ "   :   " + i);
            }
        }
    }
}