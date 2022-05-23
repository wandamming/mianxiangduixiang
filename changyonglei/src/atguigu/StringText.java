package atguigu;

import org.junit.Test;

/**
 * String的使用
 */

public class StringText {

    /**
     * 1、String声明为final的，不可被继承
     * 2、String实现了Serializable接口：表示字符串是支持序列化的
     * 			实现了Comparable接口：表示String可以比较大小
     * 3、String内部定义了”final char[] value“用于储存字符串数据
     * 4、代表不可变的字符串序列。简称：不可变性。
     *      体现：1、当对字符串重新赋值是时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
     *           2、当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value.
     *           3、当调用String的replace（）方法修改指定字符或字符串时，也需要重新指定内存区域。
     * 5、通过字面量的方式（区别于new）给一个字符串赋值，此时的·字符串值声明在字符串常量池中
     * 6、常量池中不会存储相同内容的字符串。
     */

    @Test
    public void test1(){
        String s1 = "abc";   //字面量的定义方式
        String s2 = "abc";
//        s1 = "hello";

        System.out.println(s1 == s2);  //比较s1和s2的地址值  true
        System.out.println(s1);  //hello
        System.out.println(s2);  //abc

        System.out.println("*************************************");

        String s3 = "abc";

        System.out.println(s2 == s3); //true

        s3 += "def";
        System.out.println(s3); //abcdef
        System.out.println(s2 == s3);  //false

        System.out.println("*************************************");

        String s4 = "abc";
        String s5 = s4.replace('a','x');
        System.out.println("s4 = " + s4); //abc
        System.out.println("s5 = " + s5);  //xbc
        System.out.println(s4 == s5); // false

    }


    /**
     * String的实例化方式：
     * 方式一：通过字面量定义的方式
     * 方式二：通过new+构造器的方式
     */
    @Test
    public void test2(){

        //通过字面量的方式，此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";

        //通过new+构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //false
        System.out.println(s3 == s4); //false

        System.out.println("**************************************");
        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);

        System.out.println(p1.name.equals(p2.name));  //true
        System.out.println(p1.name == p2.name);  //true
        System.out.println(p1 == p2); //false

        p1.name = "jerry";
        System.out.println(p2.name);  //Tom

    }


    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";

        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        String s8 = (s1 + s2).intern();

        System.out.println(s3 == s4);  //true
        System.out.println(s3 == s5);  //false
        System.out.println(s3.equals(s5));//true
        System.out.println(s3 == s6);  //false
        System.out.println(s3 == s7);  //false
        System.out.println(s5 == s6);  //false
        System.out.println(s5 == s7);  //false
        System.out.println(s6 == s7);  //false
        System.out.println(s3 == s8);  //true
    }



    String str = new String("good");
    char[] ch = new char[]{'t','e','s','t'};
//    String str1 = "good";
    public void change(String str1,char ch[]){
        str1 = "test ok";

        /*
        String str2 = str1 = "test ok";
        System.out.println(str2);  //test ok
        */

        /*
        String str2 = str1.replace('g','d');
        System.out.println(str2);  //dood
        */

        ch[0] = 'b';
    }
    @Test
    public void test4(){

        this.change(str,ch);
        System.out.println(str);  //good
        System.out.println(ch);  //best

//        this.change(str1,ch);
//        System.out.println(str1);//good


    }

}
