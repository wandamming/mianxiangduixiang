package SetTest;

import ListTest.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

    /**
     * 1、向TreeSet中添加的数据，要求是相同类的对象
     * 2、两种排序方式，自然排序和定制排序
     * 3、自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
     * 4、定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        /*  失败，不能添加不同类的对象
        set.add(123);
        set.add(345);
        set.add("AA");
        set.add(new Person("Tom",12));
        */

        /*方式一：
        set.add(34);
        set.add(-34);
        set.add(43);
        set.add(11);
        set.add(8);
        */


        //方式二
        set.add(new Person("Tom",12));
        set.add(new Person("Jerry",32));
        set.add(new Person("Jim",2));
        set.add(new Person("Mike",13));
        set.add(new Person("Jack",45));
        set.add(new Person("Jack",56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    int i = Integer.compare(p1.getAge(), p2.getAge());
                    if(i != 0){
                        return i;
                    }else {
                        return p1.getName().compareTo(p2.getName());
                    }
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet set = new TreeSet(com);

        set.add(new Person("Tom",12));
        set.add(new Person("Merry",32));
        set.add(new Person("Lim",2));
        set.add(new Person("Pike",13));
        set.add(new Person("Jack",32));
        set.add(new Person("Jack",56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
