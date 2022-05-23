package atguigu;

import static javafx.application.Platform.exit;

//提供method,打印a = 100 ,b = 200
public class Test1 {
    public static void main(String[] args) {

        int a = 10;
        int b = 10;
        method(a,b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    //方法一：
    static void method(int a1, int b1){
        int a = a1*10;
        int b = b1*20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.exit(0);  //终止输出
    }

}

class Phone{
    void  play(){
        System.out.println("wanyoxui");
    }



    //方法二：重写
//    public static void method(int a,int b){
//
//    }

}
