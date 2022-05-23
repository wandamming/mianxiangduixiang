package File;

import org.junit.Test;

import java.io.*;

/**
 * 字节流
 */

public class FileInputOutputStreamTest {

    @Test
    public void testFileInputStream() {
        FileInputStream fileInputStream = null;

        try {
            //1、造文件
            File file = new File("hello.txt");

            //2、造流
            fileInputStream = new FileInputStream(file);  //处理文本文件可能会出现乱码

            //3、读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while ((len = fileInputStream.read(buffer)) != -1){
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            try {
                if(fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //复制图片
    @Test
    public void test2() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File fileI = new File("img.png");
            File fileO = new File("img2.png");

            fileInputStream = new FileInputStream(fileI);
            fileOutputStream = new FileOutputStream(fileO);

            byte[] buffer = new byte[10];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 复制指定路径下的文件
     */
    public void copyFile(String inPutPath,String outPutPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File fileI = new File(inPutPath);
            File fileO = new File(outPutPath);

            fileInputStream = new FileInputStream(fileI);
            fileOutputStream = new FileOutputStream(fileO);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3(){
        long start = System.currentTimeMillis();

        String inPutPath = "C:\\Users\\九幽\\Desktop\\javaStudy\\第八章-枚举类与注解.assets\\image-20220419134905315.png";
        String outPutPath = "imgTest.png";
        copyFile(inPutPath,outPutPath);

        long end = System.currentTimeMillis();

        System.out.println("花费时间 = " + (end - start));
    }

}





























