package atguigu;

/**
 * 代码块
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;

        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.age);
        System.out.println(p2.age);

        Person.info();

        System.out.println(desc);
    }
}

class Person{

    String name;
    int age;
    static String desc = "我是一个人";

    public Person(){

    }
    public Person(String name , int age){
        this.name = name;
        this.age = age;
    }

    //static代码块
    static {
        System.out.println("hello,static block111");
        desc = "我是一个爱学习的人";
    }

    static {
        System.out.println("hello,static block222");
    }

    //非static代码块
    {
        System.out.println("hello,block");
        age = 1;
    }


    public void eat(){
        System.out.println("吃饭");
    }

    @Override
    public String toString(){
        return  "Person [name =" + name +",age = " +age + "]";
    }

    public static void info(){
        System.out.println("我是一个快乐的人");
    }

}
