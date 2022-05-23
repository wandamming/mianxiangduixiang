import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作Collection和Map的工具类
 *
 */

public class CollectionsTest {

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);  //[123, 43, 765, -97, 0]

        Collections.reverse(list);;
        System.out.println(list);  //[0, -97, 765, 43, 123]

        Collections.shuffle(list);
        System.out.println(list);  //[43, 123, -97, 0, 765]

        Collections.sort(list);
        System.out.println(list);  //[-97, 0, 43, 123, 765]

        Collections.swap(list,1,2);
        System.out.println(list);  //[-97, 43, 0, 123, 765]



    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list.size());
        /*报异常的写法：
        List dest = new ArrayList();
        Collections.copy(dest,list);    //异常： java.lang.IndexOutOfBoundsException: Source does not fit in dest
        */

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
    }


    /**
     * 解决集合线程安全问题
     */
    @Test
    public void test3(){
        List list = new ArrayList();

        //返回的list即为线程安全的list
        Collections.synchronizedList(list);
    }


}

















