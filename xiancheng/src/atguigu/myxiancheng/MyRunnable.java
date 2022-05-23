package atguigu.myxiancheng;

public class MyRunnable {
    public static void main(String[] args) {

        Runnable1 runnable1 = new Runnable1();

        Thread r1 = new Thread(runnable1);
        r1.setName("r1one");
        r1.start();

        Thread r2 = new Thread(runnable1);
        r2.setName("r1two");
        r2.start();



    }
}


class Runnable1 implements Runnable{

    @Override
    public void run() {

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
    }
}

