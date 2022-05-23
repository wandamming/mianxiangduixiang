package atguigu;

public class StaticTest {
    public static void main(String[] args) {
        Chinese c1 = new Chinese();
        c1.name = "姚明";
        c1.age = 41;

        Chinese c2 = new Chinese();
        c2.name = "马龙";
        c2.age = 30;

        c1.nation = "CHAIN";
        c2.nation = "ss";
        System.out.println(c1.nation);  //ss
        System.out.println(c2.nation);  //ss
        c1.show();
    }
}

class Chinese{
    String name;
    int age;
    static String nation;

    public static void show(){
        System.out.println("我是一个中国人");
    }
}
