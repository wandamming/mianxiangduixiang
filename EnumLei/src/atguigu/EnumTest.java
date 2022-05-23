package atguigu;

/**
 * 使用enum关键字枚举类
 * 说明：定义的枚举类默认继承于class java.lang.Enum
 */

public class EnumTest {
    public static void main(String[] args) {
        Season1 spring1 = Season1.SPRING;

        //toString(),输出的接口主要看是否重写toString（），如果没有重写则输出名称，如：spring
        System.out.println(spring1.toString());   //Season1{seasonName='春天', seasonDesc='春暖花开'}
    //    System.out.println(Season1.class.getSuperclass());  //获取父类：class java.lang.Enum

        System.out.println("---------------------------------------------------");
        //values
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("----------------------------------");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        System.out.println("-------------------------------");
        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛出异常：
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);  //Season1{seasonName='冬天', seasonDesc='冰天雪地'}
        winter.show();  //冬天不下雪
    }
}

//使用enum关键字枚举类
enum Season1 implements Info{
    //1、提供当前枚举类的对象，多个对象之间用“,”隔开，末尾对象用“;”结束
    SPRING("春天","春暖花开"){
       //接口情况二：分开重写
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","夏日炎炎") {
        @Override
        public void show() {
            System.out.println("粉色的回忆");
        }
    },
    AUTUMN("秋天","秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地") {
        @Override
        public void show() {
            System.out.println("冬天不下雪");
        }
    };

    //2、声明season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3、私有化类的构造器私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }



    //其他述求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //其他述求2:提供toString()
    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    //接口情况一：实现接口：在enum类中实现抽象方法 例：总的重写show（）
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}

interface Info{
    void show();
}