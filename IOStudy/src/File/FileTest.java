package File;

import org.junit.Test;

import java.io.File;

/**
 * File类的使用
 * 1、File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2、File类声明在java.io包下
 */

public class FileTest {

    /**
     * 1、如何创建File类的实例
     * File(String filePath)
     *
     * 2、   相对路径：
     *      绝对路径：
     */
    @Test
    public void test1(){

        //构造器一：
        File file1 = new File("hello.txt");  //相当于当前module
        File file2 = new File("C:\\Users\\九幽\\Desktop\\javaStudy\\io.txt");  //绝对路径
        System.out.println(file1);

        //构造器二：
        File file3 = new File("C:\\Users\\九幽\\Desktop", "javaStudy");
        System.out.println(file3);

        //构造器三：
        File file4 = new File(file3,"io.txt");
        System.out.println(file4);

    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\九幽\\Desktop\\javaStudy\\io.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }

    @Test
    public void test3(){
        File file = new File("C:\\Users\\九幽\\Desktop\\javaStudy");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    /**
     * public boolean renameTo(Fist dest):把文件重命名为指定的文件路径
     *
     * 1、需要file存在且file2不存在
     */

    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\九幽\\Desktop\\javaStudy\\io1.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

}









































