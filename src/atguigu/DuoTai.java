package atguigu;

public class DuoTai {
    public static void main(String[] args) {
        A a=new A();
        a.show();
        A b=new B();
        b.show();
        A c=new C();
        c.show2();
    }
}
class A{
    public void show(){
        show2();
    }
    public void show2(){
        System.out.println("A");
    }
}
class B extends A{
    @Override
    public void show2() {
        System.out.println("B");
    }
}
class C extends B{
    public void show(){
        super.show();
    }
    public void show2(){
        System.out.println("C");
    }
}
