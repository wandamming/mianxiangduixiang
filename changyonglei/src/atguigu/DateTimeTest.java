package atguigu;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK 8之前的日期和时间的API测试
 */
public class DateTimeTest {

    //一、System类中的currentTimeMillis()
    @Test
    public void  DateTimeTest(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之前以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }

    /**
     * 二、java.util.Date类
     *      |---java.sql.Date类
     * 1、两个构造器的使用
     *
     * 2、两个方法的使用
     *   >toString()：显示当前星期几，月，日，时间，时区，年
     *   >getTime()：获取当前Date对象对应的时间戳（毫秒数）
     *
     * 3、java.sql.Date类对应着数据库中的日期类型的变量。
     *   >如何实例化java.sql.Date date3 = new java.sql.Date(1650181685951L);
     *   >如何转换java.util.Date--->java.sql.date对象
     */

    @Test
    public void test2(){

        //构造器一：Data()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());  //Sun Apr 17 15:48:05 CST 2022
        System.out.println(date1.getTime());  //1650181685951

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1650181685951L);
        System.out.println(date2.toString());  //Sun Apr 17 15:48:05 CST 2022

        java.sql.Date date3 = new java.sql.Date(1650181685951L);
        System.out.println(date3.toString());   //2022-04-17

        //如何转换java.util.Date--->java.sql.date对象
//        //情况一：
//        Date date4 = new java.sql.Date(1650181685951L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 =  new java.sql.Date(date6.getTime());
    }


    /**
     *  三、SimpleDateFormat类的使用：SimpleDateFormat对日期Date类的格式化和解析
     *
     *  1、两个操作：
     *      ①格式化：日期--->字符串
     *      ②解析：格式化的逆过程，字符串--->日期
     *  2、SimDateFormat的实例化
     *
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {

        //实例化SimpleDateFormat,使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期--->字符串
        Date date = new Date();
        System.out.println("date = " + date);

        String format = sdf.format(date);
        System.out.println("format = " + format);

        //解析：格式化的逆过程，字符串--->日期
        String str = "22-4-17 下午7:02";
        Date date1 = sdf.parse(str);
        System.out.println("date1 = " + date1);

        //默认构造器，按照指定的方式格式化和解析
   //     SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd.GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //格式化
        String format1 = sdf1.format(date);
        System.out.println("format1 = " + format1);  //2022-04-17 07:16:21

        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现），否则会抛异常
        Date date2 = sdf1.parse("2022-04-17 07:16:21");
        System.out.println("date2 = " + date2);
    }




    /**
     * 四、Calender日历类的使用
     */

    @Test
    public void test4(){
        //实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()

        Calendar calendar = Calendar.getInstance();

    //    System.out.println(calendar.getClass());  //class java.util.GregorianCalendar

        //2、常用方法

        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("今天是这个月的" + days + "天");  //今天是这个月的17天
        System.out.println("今天今年的" + calendar.get(Calendar.DAY_OF_YEAR) + "天"); //今天今年的107天

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); //22

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); //25

        //getTime():日历类--->Date
        Date date = calendar.getTime();
        System.out.println(date);  //Mon Apr 25 20:02:46 CST 2022

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 17
    }


}









