package GenericTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest1 {

    /**
     * 泛型在继承方面的体现
     */
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        Object[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2的类型不具有子父类关系，为并列关系
        //list1 = list2  //编译不通过

    }

    /**
     * 通配符的使用
     * 类A是类B的父类，G<A>和G<B>是没有关系的，二者的共同关系是：G<?>
     */

    @Test
    public void test2(){
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list2.add("aaa");
        list2.add("bbb");

        List<?> list = null;
        list = list1;
        list = list2;
        print(list1);
        print(list2);

        //
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;

        //添加：对于list<?>就不能向其内部添加数据，除了添加null
        // list.add("DD");  //编译错误
        list.add(null);

        //获取（读取）：
        Object o = list.get(3);
        System.out.println(o);

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 有限制条件的通配符的使用、
     *
     * ？ extends A
     * ？ super A
     */

    @Test
    public void test3(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list2 = list4;

        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list4;
        Person person = list1.get(0);
        Object object = list1.get(0);
//        Student s = list1.get(0);  //编译不通过

        list2 = list4;
        Object obj = list2.get(0);
//        Person p1 = list2.get(0);   //编译不通过

        //写入数据
//        list1.add(new Student());  //编译不通过

        //编译通过
        list2.add(new Person());
        list2.add(new Student());

    }

}















