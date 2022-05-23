package atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口  ---jdk5.0新增
 *
 * 1、创建一个实现Callable接口的实现类
 * 2、实现call方法，将此线程需要执行的操作声明在call()中
 * 3、创建Callable接口实现类的对象
 * 4、将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
 * 5、将FutureTask的对象作为参数传递到Thread类中，创建Thread对象，并调用start()
 * 6、获取Callable中的call()中的返回值，此步骤可省略（看你是否需要返回值）
 *
 */

public class ThreadCallable {
    public static void main(String[] args) {

        //3、创建Callable接口实现类的对象
        Callable1 callable1 = new Callable1();

        //4、将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(callable1);

        //5、将FutureTask的对象作为参数传递到Thread类中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {

            //6、获取Callable中的call()中的返回值，此步骤可省略（看你是否需要返回值）
            //get()方法的返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//1、创建一个实现Callable接口的实现类
class Callable1 implements Callable {

    //2、实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}