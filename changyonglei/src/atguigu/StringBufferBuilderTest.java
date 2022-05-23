package atguigu;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 */

public class StringBufferBuilderTest {
    /**
     * String、SStringBuffer、StringBuilder三者的异同？
     * String:不可变的字符序列;底层使用char[]存储
     * StringBuffer:可变的字符序列;线程安全的，效率低；底层使用char[]存储
     * StringBuilder:可变的字符序列;jdk5.0新增，线程不安全的，效率高；底层使用char[]存储\\
     *
     * 源码分析：
     * String str = new String();  //new char[0];
     * String str = new String("abc");  //new char[]{'a','b','c'}
     *
     * StringBuffer sb1 = new StringBuffer(); //new char[16];底层创建了一个长度是16的数组
     * sb1.append('a');  //value[0] = 'a';
     * sb1.append('b');  //value[1] = 'b';
     * StringBuffer sb2 = new StringBuffer("abc");  //char[] value = new char["abc".length() + 16]
     *
     * 问题一：sb2长度为多少？  3
     * 问题二：扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
     *          默认情况下，扩容为原来的2倍+2 ，同时将原有数组中的元素复制到新的数组中。
     *
     * 指导意义：开发中建议大家使用StringBuffer(int capacity)或 StringBuilder(int capacity)
     *
     */


    @Test
    public void  test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
        sb1.append('x');
        sb1.append('a');
        sb1.append("opq");
        System.out.println(sb1);   //mbcxaopq
        System.out.println("sb1.length() = " + sb1.length()); //8

        StringBuffer sb2 = new StringBuffer("abc");  //char[] value = new char["abc".length() + 16]
        System.out.println(sb2);
        System.out.println("sb2.length() = " + sb2.length()); //3


    }

    /**
     * StringBuffer常用方法
     */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);   //abc11

        s1.delete(2,4);   //ab1    删除（左闭右开）
        System.out.println(s1);

        s1.replace(1,2,"hello");  //替换
        System.out.println(s1);   //ahello1

        s1.insert(2,false);   //插入
        System.out.println(s1);  //ahfalseello1
        System.out.println(s1.length());  //12

        s1.reverse();   //反转
        System.out.println(s1);   //1olleeslafha

        System.out.println(s1.indexOf(""));   //返回索引
        System.out.println(s1.substring(2, 5));  //返回左闭右开区间的值

        System.out.println(s1.charAt(1)); //查询

        s1.setCharAt(1,'w');  //改
        System.out.println(s1);


    }





}
