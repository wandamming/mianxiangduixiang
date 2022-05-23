package atguigu.myxiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable {
    public static void main(String[] args) {
        Callable1 c1 = new Callable1();

        FutureTask futureTask1 = new FutureTask(c1);
        Thread t1 =  new Thread(futureTask1);
        t1.setName("one11");
        t1.start();

        FutureTask futureTask2 = new FutureTask(c1);
        new Thread(futureTask2).start();



    }
}


class Callable1 implements Callable {


    @Override
    public Object call() throws Exception {
        boolean flag = true;
        for(int i = 2; i <= 100; i++){
            for (int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }

            if (flag == true){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

            flag = true;
        }
        return 0;
    }
}