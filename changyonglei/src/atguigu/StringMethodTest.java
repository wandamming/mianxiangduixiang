package atguigu;

import org.junit.Test;

import java.util.Locale;

public class StringMethodTest {

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());  //字符串长度
    //    System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(2));  //索引处的元素
        System.out.println(s1.isEmpty());  //是否为空字符串

        String s2 = s1.toLowerCase();  //使用默认语言环境，将String中的所有字符串转换为小写
        System.out.println(s1);   //s1不可变，仍为HelloWorld
        System.out.println(s2);   //s2为helloworld

        String s21 = s2.toUpperCase();  //使用默认语言环境，将String中的所有字符串转换为大写
        System.out.println(s21);

        String s3 = "  he  llo  world   ";
        String s4 = s3.trim();  //驱除字符串首尾的空格
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);

    }

    @Test
    public void test2(){
        String s1 = "HelloWord";
        String s2 = "helloword";
        System.out.println(s1.equals(s2));  //false
        System.out.println(s1.equalsIgnoreCase(s2));  //true  忽略大小写的比较

        String s3 = "abc";
        String s4 = s3.concat("def");  //字符串连接
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));  //比较两个字符串的大小，涉及到字符串排序

        String s7= "我的二十六岁女房客";
        String s8 = s7.substring(2);  //返回一个新字符串，从原字符串从beginIndex开始截取
        String s9 = s7.substring(2, 5);  //返回一个字符串，左闭右开“[二十六岁)”
        System.out.println(s7);
        System.out.println(s8);  //二十六岁女房客
        System.out.println(s9);  //二十六

    }

    @Test
    public void test3(){
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");   //测试此字符串是否以指定的后缀结束
        boolean b2 = str1.startsWith("he");  //测试此字符串是否以指定的后缀开始
        boolean b3 = str1.startsWith("ll",2); //测试此字符串从指定索引开始的子字符串是否一样

        System.out.println(b1);  //true
        System.out.println(b2);  //true
        System.out.println(b3);  //true

        String str2 = "wo";
        System.out.println(str1.contains(str2));  //true  ，判断是否包含，当且仅当此字符串包含指定的char值序列时，返回true

        System.out.println(str1.indexOf("lo")); //3，   返回指定字符串在此字符串中第一次出现处的索引，若没有则返回-1
        System.out.println(str1.indexOf("lo", 5)); //-1   ,从索引之后去找

        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));  //7    ,返回指定子字符串在此字符串中最右边出现的索引
        System.out.println(str3.lastIndexOf("o", 8));  //7,    返回指定字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索


    }

    @Test
    public void test4(){
        String s1 = "我的二十六岁女房客我的";
        String s2 = s1.replace("我的", "你是");  //替换字符串中的元素
        System.out.println(s1);  //我的二十六岁女房客我的
        System.out.println(s2);  //你是二十六岁女房客你是

        System.out.println("************************************************");

        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成“,”，如果结果中开头和结尾有","，的话去掉
        String string = str.replaceAll("\\d+",",").replaceAll("^,|,$","");  //"d"代表数字（正则表达式）
        System.out.println(string);  //hello,world,java,mysql

        str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);

        System.out.println("************************************************");
        str = "hello|world|java";
        String[] strs = str.split("\\|");  //切片
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }

    }


}






