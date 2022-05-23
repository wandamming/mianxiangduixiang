package atguigu.myxiancheng;

public class MyThread {
    public static void main(String[] args) {

        Thread1 thread1 = new Thread1();
        thread1.setName("one");
        thread1.start();

        Thread1 thread2 = new Thread1();
        thread2.setName("two");
        thread2.start();

    }
}



class Thread1 extends Thread{
    @Override
    public void run() {
        for(int i = 100; i > 0; i--){
            System.out.println(getName() + " : " + i);
        }
    }
}