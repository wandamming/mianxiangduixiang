public class BreakContinue {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++ ){
            if(i % 5 == 0){
//                break;   //123
                continue;  //12346789 10
            }
            System.out.print(i + " "+"\n");
        }
        System.out.println("----------------------------------------");

label:  for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 10; j++){
                if(j % 5 == 0){
//                    break;   //默认跳出包裹此关键字的最近的一层循环
//                    continue;
//                    break label;  //结束指定标签的循环
                    continue label; //结束指定标识的一层循环结构当次循环

                }
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
