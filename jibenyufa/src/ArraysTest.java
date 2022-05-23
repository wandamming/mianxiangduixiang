import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4,21,34,56,77,11,23,35,46,98,16,57};

        //1、比较数组是否相等
        boolean isEquals = Arrays.equals(arr1,arr2);
        System.out.println(isEquals);

        //2、遍历
        System.out.println(Arrays.toString(arr1));

        //3、将指定值填充到数组中（替换，用于初始化等）
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));

        //4、排序
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        //5、查找
        int[] arr3 = new int[]{1,3,2,4,21,34,56,77,11,23,35,46,98,16,57};
        int index = Arrays.binarySearch(arr3,56);
        System.out.println(index);
    }
}
