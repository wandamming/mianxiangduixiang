package test1;

public class DanLi {
    private DanLi(){ }
    private static DanLi instance = null;
    public static DanLi getInstance(){
        if(instance == null){
            instance = new DanLi();
        }
        return instance;
    }

}

class Bank{
    private Bank(){}
    private static Bank instance = null;
    public static  Bank getInstance(){
        return instance;
    }
}