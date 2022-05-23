package GenericTest;

import org.junit.Test;

import java.util.*;

/**
 * 泛型
 */

public class GenericTest {
    

    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        //问题一:类型不安全
//        list.add("Tom");

        for (Object score: list) {

            //问题二：强转时，可能出现异常java.lang.String cannot be cast to java.lang.Integer
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }


    //在集合中使用泛型的情况
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型检查
//        list.add("Tom");

        //遍历方式一：
        for (Integer score:list) {
            //避免了强转操作
            int stuScore = score;
            System.out.println(stuScore);
        }

        System.out.println("-------------------------------");
        //遍历方式二:
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "----" + value);
        }
    }


    @Test
    public void test4(){

        /**
         * 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
         * 要求:如果大家定义了类是泛型类，建议在实例化时要指明类的泛型。
         * 子类继承泛型父类时不用再指明泛型；
         */
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        Order<String> order1 = new Order<String>("orderAA",1001,"order:AA");
        order1.setOrderT("hello");

        System.out.println(order1);
    }

    //测试泛型方法
    @Test
    public void test5(){
        Order<Object> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};

        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFormArrayToList(arr);

        System.out.println(list);
    }

}





















