package GenericTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 * @param <T>
 */
public class Order<T> {
    String orderName;
    int orderTd;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order(){

    }

    public Order(String orderName, int orderTd, T orderT) {
        this.orderName = orderName;
        this.orderTd = orderTd;
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderTd=" + orderTd +
                ", orderT=" + orderT +
                '}';
    }

    public <E> List<E> copyFormArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}


