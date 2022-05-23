import ListTest.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 */


public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        /*
        方式一：
        System.out.println(iterator.next());  //123
        System.out.println(iterator.next());  //456
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        */

        /*
        //方式二:  不推荐
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }
        */

        //方式三：推荐
        while (iterator.hasNext()){ //判断是否还有下一个元素
            System.out.println(iterator.next());//①指针下移，②将下移以后集合位置上的元素返回
        }

    }

    //Iterator中的remove（）
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中的“Tom”
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }

        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
















