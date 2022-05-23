package atguigu;

public class Goods implements Comparable{
    private String name;
    private double price;
    public Goods(){

    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" +name + '\'' +
                ", price=" + price +
                '}';
    }


    //指明商品按照价格从低到高的方式,再按照产品名称从低到高排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods)o;

            //方式一：自定义
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else {
                return this.name.compareTo(goods.name);
            //    return -this.name.compareTo(goods.name); //从高到低
            }

            //方式二：调用
         //   return Double.compare(this.price,goods.price);
        }

        throw new RuntimeException("传入的数据类型不一致");
    }
}
