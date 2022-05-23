package atguigu;

public class PersonTest {
    public static void main(String[] args) {
        //创建person类的对象,对象的实例化
        //创建类的对象：new +构造器（Person（））
        Person1 p1 = new Person1("Tom");
        p1.eat();
    }

}

class Person1{
    // 属性
    String name;
    int age;
    boolean isMale;

    //构造器
    public  Person1(){
        System.out.println("aaaaa");
        age = 18;
    }


    public Person1(String n){
        name = n;
    }

    //方法
    public void eat(){
        System.out.println("人可以吃饭");
    }

}
