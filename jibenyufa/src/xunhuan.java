public class xunhuan {
    public static void main(String[] args) {
        //水仙花数
        for(int i = 100; i<1000; i++){
            if(((i/100)*(i/100)*(i/100) + (i%100/10)*(i%100/10)*(i%100/10) + (i%10)*(i%10)*(i%10)) == i){
                System.out.println(i);
            }
        }
        System.out.println("-----------------------------------------------");
        //九九乘法表
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + "*" + i + "=" + i*j + "\t");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------------");

        //质数  方法一：
        long start = System.currentTimeMillis();  //获取当前时间距离的毫秒数
        int count = 0;
        for(int i = 2; i <= 100; i++){
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    flag = false;
                    break;    //优化
                }
            }
            if (flag == true){
                System.out.println(i + " ");
                count++;
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("数量为：" + count);
        System.out.println("所花费的时间为：" + (end - start));

        System.out.println("-----------------------------------------------");

        //质数，方法二：
        long start1 = System.currentTimeMillis();  //获取当前时间距离的毫秒数
        int count1 = 0;
        label: for(int i = 2; i <= 10000; i++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    continue label;
                }
            }
            count1++;
        }
        long end1 = System.currentTimeMillis();
        System.out.println("数量为：" + count1);
        System.out.println("所花费的时间为：" + (end1 - start1));

        System.out.println("-----------------------------------------------");

        //完数  （6 = 1 + 2 + 3）
        for(int i = 1; i <= 1000; i++){
            int factor = 0;
            for (int j = 1; j <= i/2; j++){
                if (i % j == 0){
                    factor += j;
                }
            }
            if(i == factor){
                System.out.println(i);
            }

        }

    }



}
