package atguigu.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * ctrl + alt + T
 */
public class BankTest {
}

class Bank{
    private Bank(){}
    private static Bank instance = null;

    //方式一：
//    private static synchronized Bank getInstance(){
//        if (instance == null){
//            instance = new Bank();
//        }
//        return instance;
//    }

    private static Bank getInstance(){

        //方式二：效率较差
//        synchronized (Bank.class) {
//            if (instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式三:效率较高
        if(instance == null){
            synchronized (Bank.class) {
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}