package atguigu;

public class Super{
    public static void main(String[] args){
        Vip v = new Vip("张三");
        v.shopping();
    }
}
class Customer {
    String name;
    public Customer(){}
    public Customer(String name){
        super();
        this.name = name;
    }

    public void doSome(){
        System.out.println(this.name + " do some!");
        System.out.println(name + " do some!");
        //错误: 找不到符号
        //System.out.println(super.name + " do some!");//Object类没有name属性
    }
}
class Vip extends Customer{

    // 假设子类也有一个同名属性
    // java中允许在子类中出现和父类一样的同名变量/同名属性。
    String name; // 实例变量

    public Vip(){
    }
    public Vip(String name){
        super(name);
        // this.name = null;
    }
    public void shopping(){
		/*
			java是怎么来区分子类和父类的同名属性的？
				this.name：当前对象的name属性
				super.name：当前对象的父类型特征中的name属性。
		*/
        System.out.println(this.name + "正在购物!"); // null 正在购物  子类的name
        System.out.println(super.name + "正在购物!"); // 张三正在购物   父类的name
        System.out.println(name + "正在购物!"); //null 正在购物   子类的name
    }
}
