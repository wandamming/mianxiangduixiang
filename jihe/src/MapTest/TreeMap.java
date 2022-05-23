package MapTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TreeMap {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序，定制排序

    //自然排序
    @Test
    public void test1(){
        java.util.TreeMap map = new java.util.TreeMap();
        Person p1 = new Person("Tom",23);
        Person p2 = new Person("Jerry",32);
        Person p3 = new Person("Jack",20);
        Person p4 = new Person("Rose",18);
        map.put(p1,98);
        map.put(p2,89);
        map.put(p3,76);
        map.put(p4,100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }

    }

    //定制排序
    @Test
    public void test2(){
        java.util.TreeMap map = new java.util.TreeMap(new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });
        Person p1 = new Person("Tom",23);
        Person p2 = new Person("Jerry",32);
        Person p3 = new Person("Jack",20);
        Person p4 = new Person("Rose",18);
        map.put(p1,98);
        map.put(p2,89);
        map.put(p3,76);
        map.put(p4,100);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry);
        }

    }

}
