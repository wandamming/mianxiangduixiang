package File;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流
 * 1、转换流属于字符流
 *    InputStreamReader：将一个字节的输入流转换为字符的输入流
 *    OutputStreamReader：将一个字符的输出流转换为字节的输出流
 *
 * 2、作用：提供字节流与字符流的转换
 *
 * 3、解码：字节、字节数组 ---> 字符数组、字符串
 *    编码：字符数组、字符串 ---> 字节、字节数组
 *
 *
 * 4、字符集
 */

public class InputStreamReaderTear {

    @Test
    public void test1(){
        InputStreamReader inputStreamReader = null;  //使用系统默认的
        try {
            FileInputStream fileInputStream = new FileInputStream("hello.txt");

//        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);  //使用系统默认的"UTF-8"
            //参数二指明了字符集,具体使用哪个字符集，取决于文件hello.txt保存是默认使用的字符集
            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");

            char[] charBuffer = new char[20];
            int len;

            while ((len = inputStreamReader.read(charBuffer)) != -1){
                String str = new String(charBuffer, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStreamReader != null)
                    inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 综合使用
     * 还是应该使用try-catch,此处不用是因为方便阅读代码
     */
    @Test
    public void test2() throws IOException {

        //1、造文件
        File file1 = new File("hello.txt");
        File file2 = new File("hello2.txt");

        //2、造流
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"GBK");

        //3、读写过程
        char[] chars = new char[5];
        int len;

        while ((len = inputStreamReader.read(chars)) != -1){
            outputStreamWriter.write(chars,0,len);
        }

        //4、关闭
        outputStreamWriter.close();
        inputStreamReader.close();


    }



}



























