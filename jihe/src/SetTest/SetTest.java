package SetTest;


import ListTest.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 一：Set：存储无序的、不可重复的数据
 * 以hashSet为例说明
 * 1、无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的
 *
 * 2、不可重复性：保证添加的元素按照equals()判断时，不能返回true，即：相同的元素只能添加一个
 *
 * 二、添加元素的过程：以HashSet为例：
 *      我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
 *      此时哈希值截止通过计算某种算法计算出HashSet底层数组中的存放位置（即：索引位置），判断
 *      数组在此位置上有没有其他元素：
 *           如果此位置上没有其他元素，则元素a添加成功； ---> 情况一
 *           如果此位置上有其他元素b（或一链表形式存在的多个元素），则比较元素a与元素b的hash值
 *                 如果hash值不相同，则a元素添加成功 ---> 情况二
 *                 如果hash值相同，进而需要调用元素a所在类的equals()方法：
 *                      equals()返回true，则元素添加失败
 *                      equals()返回false，则元素添加成功   --->  情况三
 *      对于添加成功的情况二和情况三而言：元素a与已经存在指定索引位置上数据以链表的方式储存。
 *      jdk7：元素a放到数组中指向原来的元素
 *      jdk8：原来的元素在数组中指向元素a
 */

public class SetTest {

    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(345);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        set.add(129);

        System.out.println(set); //[AA, CC, 129, 345, 123, Person{name='Tom', age=12}]
    }


    /**
     * LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
     * 对于频繁的遍历操作，LinkedHashSet效率高于HashSet
     */

    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(345);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        set.add(129);

        System.out.println(set); //[AA, CC, 129, Person{name='Tom', age=12}, 345, 123, Person{name='Tom', age=12}]



    }


}
