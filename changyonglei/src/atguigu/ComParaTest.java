package atguigu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1、说明：java中的对象正常情况下只能进行比较操作： == 或 ！= 。不能使>或<的，
 * 但是在开发场景中，我们需要对多个对象排序，就需要比较大小，如何实现？
 *      >自然排序：java.lang.Comparable
 *      >定制排序：java.util.Comparator
 *
 * 2、自然排序：java.lang.Comparable接口使用
 */

public class ComParaTest {

    /**
    *     自然排序：java.lang.Comparable接口使用实例
    *     1、像String、包装类等实现了Comparable接口，重写了compareTo（）方法，给出了比较两个对象大小的方法
    *     2、默认从小到大
    *     3、重写compareTo()的规则：见蓝字
    *     4、对于自定义来说需要排序，我么可以让自定义类实现ComParable接口，重写CompareTo()
    *        在compareTo（obj）方法中指明如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","cc","kk","MM","GG","JJ","DD"};
        Arrays.sort(arr);   //排序
        System.out.println(Arrays.toString(arr));  //[AA, DD, GG, JJ, MM, cc, kk]
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lianxiang",34);
        arr[1] = new Goods("daieradaf",43);
        arr[2] = new Goods("xiaomiasd",12);
        arr[3] = new Goods("huaweiasd",65);

        Arrays.sort(arr);   //需要重写重写CompareTo()，否则报错
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 定制排序：Comparator接口使用实例
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","cc","kk","MM","GG","JJ","DD"};
        Arrays.sort(arr,new Comparator(){
            //按照字符串从大到小排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lianxiang",34);
        arr[1] = new Goods("daieradaf",43);
        arr[2] = new Goods("xiaomiasd",12);
        arr[3] = new Goods("huaweiasd",65);

        Arrays.sort(arr, new Comparator() {
            //指明行啊按照产品名称从低到高排序，再按照商品按照价格从高到低的方式,
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return Double.compare(g1.getPrice(), g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }

                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

}















