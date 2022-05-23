package atguigu;

public class RecursionTest {
    public static void main(String[] args) {

        System.out.println(getSum1(3));

        System.out.println(f(10));
    }

    //阶乘
    static int getSum1(int n){
        if(n == 1){
            return 1;
        }else {
            return n * getSum1(n - 1);
        }
    }

    //数列 f(0) = 1,f(1) = 4,f(n+2) = 2*f(n+1) + f(n)
    static int f(int n){//求f(10)
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 4;
        }else {
            return 2*f(n-1) + f(n-2);
        }
    }
}


