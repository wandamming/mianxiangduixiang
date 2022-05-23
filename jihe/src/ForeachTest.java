import ListTest.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ForeachTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合中元素的类型 局部变量 ： 集合对象)  ,内部仍然调用了迭代器
        for (Object obj: coll) {
            System.out.println(obj);
        }
    }
}
