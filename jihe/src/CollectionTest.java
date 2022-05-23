
/**
 * 1、集合数组都是对多个数据进行存储操作的结构，简称java容器
 *   说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt , .jpg , 数据库）
 *
 * 2.1、数组在存储多个数据方面的特点：
 *      •一旦初始化以后，其长度就确定了。
 *      •一旦定义好，其元素的类型就确定了，只能操作指定类型的数据，比如：String[] arr 。
 *
 * 2.2、数组在存储多个数据方面的缺点：
 *      •一旦初始化，其长度就不可修改
 *      •数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      •获取数组中实际元素的个数的需求，数组没有现成的数据或方法可用
 *      •数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 */


import ListTest.Person;
import org.junit.Test;

import java.util.*;

/**
 * Collection接口中的方法的使用
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals（）
 */

public class CollectionTest {

    @Test
    public void test1(){

        Collection coll = new ArrayList();

        //add(Object e):将元素e集合call中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);  //自动装箱
        coll.add(new Date());

        // size() : 获取添加的元素的个数
        System.out.println(coll.size());  //4

        // addAll() : 将call1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("cc");
        coll.addAll(coll1);

        System.out.println(coll.size());  //6
        System.out.println(coll);  //[AA, BB, 123, Tue Apr 19 16:50:54 CST 2022, 456, cc]

        // isEmpty() : 判断当前集合是否为空
        System.out.println(coll.isEmpty());  //false

        // clear() : 清空集合元素
        coll.clear();
        System.out.println(coll.isEmpty());  //true

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        coll.add(new Person("Jerry",20));

        coll.add(new Person("Jerry",20));

        //contains(Object obj) : 判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals().

        boolean contains = coll.contains(123);
        System.out.println(contains);  //true

        System.out.println(coll.contains(new String("Tom")));  //true ,说明contains判断的是内容（调用equals()），没有需要重写
        System.out.println(coll.contains(new Person("Jerry", 20)));  //true，重写了Person的equals()方法，否则返回false

        //containsAll(Collection coll1): 判断形参coll1中所有的元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));  //true

    }

    @Test
    public void test3(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //remove(Object obj)  ： 从当前集合中移除obj元素
        coll.remove(123);  //这是一个boolean类型数据
        System.out.println(coll);
        coll.remove(new Person("Jerry",20));  //还是需要重写Person类的equals(),否则不会移除
        System.out.println(coll);

        //removeAll(Collection coll1) : 从当前集合中移除coll1中所有的元素（其实就是共有的）
        Collection coll1 = Arrays.asList(123,456,890);
        coll.removeAll(coll1);
        System.out.println(coll);


    }

    @Test
    public void test4() {

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //coll.retainAll(Collection coll1) : 求交集获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);

        //equals(Object obj) :
        Collection coll2 = new ArrayList();

        //hashCode() : 返回当前对象的哈希值
        System.out.println(coll1.hashCode());

        System.out.println("------------------------------------------------------------");
        //集合 ---> 数组 ： toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 ---> 集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        // iterator() : 返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中


    }
}




























