package atguigu;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk8中日期时间api的测试
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){

        //偏移量
        Date date1 = new Date(2020 - 1900, 10 - 1, 8);
        System.out.println(date1);   //Thu Oct 08 00:00:00 CST 2020
    }

    /**
     * LocalDate,LocalTime,LocalDateTime的使用
     *
     * 说明：
     * 1、LocalDateTime相较于LocalDate,LocalTime,使用频率高一些
     * 2、类似于Calender
     */

    @Test
    public  void test1(){

        //获取当前的日期、时间等
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);  //2022-04-18
        System.out.println(localTime);  //13:37:41.901
        System.out.println(localDateTime);  //2022-04-18T13:37:41.901

        //of():设置指定的年月日时分秒没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);  //2020-10-06T13:23:43

        //getXxx(),获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());;
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //withXxx(): 设置相关属性 ，体现不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);   //2022-04-18
        System.out.println(localDate1);  //2022-04-22

        //不可变性  加
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);  //2022-04-18T13:54:03.647
        System.out.println(localDateTime2);  //2022-07-18T13:54:03.647

        //减
        LocalDateTime localDateTime3 = localDateTime.minusDays(6);
        System.out.println(localDateTime);  //2022-04-18T13:56:03.280
        System.out.println(localDateTime3); //2022-04-12T13:56:03.280

    }

    /**
     * Instant使用
     * 类似于java.util.Date类
     */
    @Test
    public void test2(){

        //now():获取本初子午线对应的时间
        Instant instant = Instant.now();
        System.out.println(instant);  //2022-04-18T06:08:47.603Z

        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); //2022-04-18T14:11:19.610+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的对应毫秒数  --> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);  //1650262547832

        //ofEpochMilli() :通过给定的毫秒数，获取Instant实例 --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1650262547832L);
        System.out.println(instant1); //2022-04-18T06:15:47.832Z

    }

    /**
     * DateTimeFormatter:格式化或解析时间、日期，类似于SimpleDateFormat
     */

    @Test
    public void test3(){
        //方式一：预定义的表中格式
        //方式二：本地化相关格式

        //重点方式三:自定义的格式。如：ofPatten("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        //格式化
        String str = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(str);//2022-04-18 02:54:11

        //解析
        TemporalAccessor parse1 = dateTimeFormatter.parse("2022-04-18 02:54:11");
        System.out.println(parse1);  //{HourOfAmPm=2, MicroOfSecond=0, SecondOfMinute=11, MinuteOfHour=54, NanoOfSecond=0, MilliOfSecond=0},ISO resolved to 2022-04-18


    }



}
























