package atguigu;

public class AbstractTest {
    public static void main(String[] args) {

        //一旦Person类抽象了，就不可实例化
//        Person3 p1 = new Person3();
//        p1.eat();

        //创建一匿名子类的对象：p
        Person3 p3 = new Person3() {
            @Override
            public void eat() {
                System.out.println("chidongxi");
            }
        };
        p3.eat();

    }

}

abstract class Person3{
    String name;
    int age;

    public Person3(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person3() {

    }

//    public void eat(){
//        System.out.println("人吃饭");
//    }

    //抽象方法
    public abstract void eat();

    public void walk(){
        System.out.println("人走路");
    }
}

class Student extends Person3{

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("学生多吃有意义的实物");
    }
}
