package atguigu.java;

/**
 * 创建三个窗口买票
 * 线程不安全，待解决
 */
public class WindowsTestThread {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");


        w1.start();
        w2.start();
        w3.start();

    }
}

class Window extends Thread{
    private static int ticket = 1000;

    private static Object obj = new Object();

    @Override
    public void run() {
//        synchronized(obj) {
        synchronized(Window.class) {  //Class clazz = Window.class,只会加载一次
            while (true) {
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(getName() + ":卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}