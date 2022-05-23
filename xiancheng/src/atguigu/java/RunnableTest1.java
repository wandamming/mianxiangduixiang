package atguigu.java;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1、创建一个实现了Runnable接口的类
 * 2、实现类去实现Runnable中的抽象方法：run（）
 * 3、创建实现类的对象
 * 4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5、通过Thread类的对象调用start（）
 */

public class RunnableTest1 {
    public static void main(String[] args) {

        //3、创建实现类的对象
        Runnable1 runnable1 = new Runnable1();
        //4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(runnable1) ;
        Thread t2 = new Thread(runnable1);

        //5、通过Thread类的对象调用start（）
        t1.start();
        t2.start();
    }
}

//1、创建一个实现了Runnable接口的类
class Runnable1 implements Runnable{

    @Override //2、实现类去实现Runnable中的抽象方法：run（）
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "  :  " +i);
            }
        }
    }
}
