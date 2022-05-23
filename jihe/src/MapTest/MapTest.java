package MapTest;

import org.junit.Test;

import java.util.*;

/**
 *Map中定义的方法：HashMap为例
 */
public class MapTest {

    @Test
    public void test1(){
        HashMap map = new HashMap();

        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //修改
        map.put("AA",87);

        System.out.println(map);  //{AA=87, BB=56, 45=123}

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);

        System.out.println(map);  //{AA=87, BB=56, CC=123, DD=123, 45=123}

        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);  //123
        System.out.println(map);  //{AA=87, BB=56, DD=123, 45=123}

        //clear()
        map.clear();  //与map = null不同
        System.out.println(map.size()); //0
        System.out.println(map); //{}

    }

    @Test
    public void testq(){
        String s1 = "aa";
        s1 = "bb";

        System.out.println(s1);
    }


    @Test
    public void test2() {
        HashMap map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        System.out.println(map.get(45));  //123

        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);  //true

        boolean isExist1 = map.containsValue(123);
        System.out.println(isExist1);  //true

        map.clear();
        System.out.println(map.isEmpty());  //true



    }


    @Test
    public void test3(){
        HashMap map = new HashMap();

        //添加
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);

        //遍历所有的key集，keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();
        //遍历所有的value集:values()
        Collection values = map.values();
        for (Object obj: values) {
            System.out.println(obj);
        }

        System.out.println();

        //遍历所有的key-value
        //方式一：entrySet();
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "------->" + entry.getValue());
        }

        System.out.println();

        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "====" + value);

        }


    }

}















