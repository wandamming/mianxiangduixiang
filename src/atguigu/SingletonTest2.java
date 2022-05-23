package atguigu;

/**
 * 单例模式懒汉式
 */

public class SingletonTest2 {
    public static void main(String[] args) {

        Order1 order1 = Order1.getInstance();
        Order1 order2 = Order1.getInstance();
        System.out.println(order1 == order2);  //true
    }
}

class Order1{

    //1、私有化类的构造器
    private Order1(){ }
    //2、声明当前了对象，没有初始化,必须static
    private static Order1 instance = null;

    //3、声明public、static的返回类对象的方法
    public  static Order1 getInstance(){
        if(instance == null) {
            instance = new Order1();
        }
        return instance;
    }
}
