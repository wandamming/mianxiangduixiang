package fanshe;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    //反射之前，对于Person的操作
    @Test
    public void test1(){

        //1、创建Person对象
        Person person = new Person("Tom", 12);

        //2、通过对象，调用其内部的属性，方法
        person.age = 10;
        System.out.println(person.toString());  //Person{name='Tom', age=10}

        //3、调用方法
        person.show();

        //在Person类外部，不能调用其内部私有结构（属性，方法，构造器）

    }
    @Test
    public void test2() throws Exception {

        Class clazz = Person.class;

        //1、通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());  //Person{name='Tom', age=12}

        //2、通过反射，调用对象指定的属性，方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p); //Person{name='Tom', age=10}

        //3、调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("******************************************************");

        //通过反射，可以调用Person类的私有结构（属性，方法，构造器）
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");  //Person{name='Jerry', age=0}
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"lubenwei");
        System.out.println(p1); //Person{name='lubenwei', age=0}

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");//相当于String nation = p1.showNation("中国")
        System.out.println(nation);

    }


    //获取Class的实例的方式(前三个需要掌握)
    //方式一：
    @Test
    public void test3() throws ClassNotFoundException {

        //方式一:调用运行时类的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName（String classPath）
        Class clazz3 = Class.forName("fanshe.Person");  //一定要主要路径写法
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);  //true
        System.out.println(clazz1 == clazz3);  //true

        //方式四：使用类的加载器：ClassLoader（了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("fanshe.Person");
        System.out.println(clazz4);

    }


}


























