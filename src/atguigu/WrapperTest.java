package atguigu;

import org.junit.Test;

public class WrapperTest {

    @Test  //String --->基本数据类型、包装类：
    public  void test5(){
        String str1 = "123";
        int num1 = Integer.parseInt(str1);
        System.out.println(str1);
        System.out.println(num1);
    }

    @Test  //基本数据类型、包装类--->转String类型：
    public void test4(){
        int num1 = 10;
        //方式1：连接运算
        String str = num1 + "";
        //方式2：调用String的valueOf（Xxx xxx）
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);
        System.out.println(str2);//"12.3"
    }

    @Test
    public void test3(){
        int num1 = 10;
        method(num1);  //按理说num1是基本数据类型，而method不是，会报错，但是没报

        //自动装箱：
        int num2 = 10;
        Integer in1 = num2;

        //自动拆箱：
        System.out.println(in1.toString());
        int num3 = in1;
    }

    public  void method(Object obj){

    }

    @Test //包装类--->基本数据类型 ；调用包装类的xxxValue（）
    public void test2(){
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(in1+1);
        System.out.println(i1+1);
    }


    @Test  //基本数据类型--->包装类
    public void test1(){

        int num1 = 10;
        Integer in1 = new Integer(num1);
        System.out.println(in1.toString());

        Integer in2 = new Integer("123");
        System.out.println(in2.toString());

//        Integer in3 = new Integer("123abc"); //报错
//        System.out.println(in3.toString());

        //特别的
        Boolean b1 = new Boolean("true");
        System.out.println(b1);

        Boolean b2 = new Boolean("true123");  // 不报错，打印false
        System.out.println(b2);

        Order order = new Order();
        System.out.println(order.o1); //false
        System.out.println(order.o2); //null

    }

}

class Order{
    boolean o1;
    Boolean o2;
}