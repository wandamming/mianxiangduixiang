public class shuzhu {
    public static void main(String[] args) {

        int[] ids = new int[]{1,2,3,4,45,32,12,35,21};  //静态初始化
        String[] names = new String[5];  //动态初始化
        int max = 0;
        for(int i = 0; i < ids.length; i++){
            if(max < ids[i]){
                max = ids[i];
            }
        }
        System.out.println(max);

        System.out.println("-------------------------------");

        int[][] arr1 = new int[][]{{1,2,3},{4,5},{6,7,8}};
        String[][] arr2 = new String[3][2];
        System.out.println(arr1.length);
        System.out.println(arr1[1].length);
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------------");

        int[][] arr3 = new int[4][3];
        System.out.println(arr3[0]);  //内层元素，地址值[I@135fbaa4
        System.out.println(arr3[0][0]);
        System.out.println(arr3);  //[[I@45ee12a7

        System.out.println("---------------------------");

        //杨辉三角
        int[][] arr4 = new int[10][];
        for(int i = 0; i < arr4.length; i++){
            arr4[i] = new int[i+1];
            arr4[i][0] = arr4[i][i] = 1;
            if(i > 1){
                for (int j = 1; j < arr4[i].length - 1; j++){
                    arr4[i][j] = arr4[i-1][j-1] + arr4[i-1][j];
                }
            }
        }
        for(int i = 0; i < arr4.length; i++){
            for (int j = 0; j < arr4[i].length; j++){
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

        //随机数组
        int[] arr5 = new int[30];
        for(int i = 0; i < arr5.length; i++){
            arr5[i] =(int) (Math.random() * 30) + 1;
            for(int j = 0; j < i; j++){
                if(arr5[i] == arr5[j]){
                    i--;
                    break;
                }
            }

        }
        for(int i = 0; i < arr5.length; i++){
            System.out.print(arr5[i] + " ");
        }


        System.out.println("\n"+"-----------------------------");

        //排序
        int[] arr6 = new int[]{5,6,4,2,8,9,3,10};
        int temp;
        //冒泡排序
        for(int i = 0; i < arr6.length; i++){
            for(int j = i; j < arr6.length; j++){
                if(arr6[i] > arr6[j]){
                    temp = arr6[i];
                    arr6[i] = arr6[j];
                    arr6[j] = temp;
                }
            }
        }
        for(int i = 0; i < 8; i++){
            System.out.print(arr6[i] + " ");
        }

        //数组遍历的方法
        System.out.println(java.util.Arrays.toString((arr6)));


    }
}
