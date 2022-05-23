package atguigu.java;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1、创建一个继承于Thread类的子类
 * 2、重写Thread类的run（） -->将此线程执行的操作声明在run中
 * 3、创建Thread类的子类的对象
 * 4、通过自对象调用start（）
 */

public class ThreadTest {
    public static void main(String[] args) {

        //3、创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //4、通过此对象调用start（）
        t1.start();
//        t1.run();     //直接调用的话，根本没有启用线程，还是一个main线程
        //如下操作仍然在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ "   :   " + i + "*********main*********");
            }
        }
    }
}

//1、创建一个继承于Thread类的子类
class MyThread extends Thread{
    @Override //2、重写Thread类的run（） -->将此线程执行的操作声明在run中
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ "   :   " + i);
            }
        }
    }
}