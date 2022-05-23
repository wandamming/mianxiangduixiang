package File;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {

    /**
     * 硬盘中文件的读取
     */
    @Test
    public void testFileReader(){
        FileReader fr = null;
        //为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
        //读入的文件一定要存在，否则会报异常
        try {
            //1、实例化File对象，指明要操作的文件
            File file = new File("hello.txt");  //在Test中是相对于当前Module，在main中是相对于当前工程
            //2、提供具体的流
            fr = new FileReader(file);
            //3、数据的输入,read()：返回读入的一个字符，如果达到文件末尾，返回-1
            int data;
            while ((data = fr.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭操作
            try {
                if(fr != null)
                     fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 对read()操作升级，使用read的重载方法
     */
    @Test
    public void testFileReader1(){
        FileReader fr = null;

        try {
            //1、File类的实例化
            File file = new File("hello.txt");

            //2、FileReader流的实例化
            fr = new FileReader(file);

            //3、读入的操作
            //read(char[] charBuffer) :返回每次读入数组汇总的字符的个数，如果达到文件末尾，返回-1
            char[] charBuffer = new char[5];
            int len;
            while ((len = fr.read(charBuffer)) != -1){

                //方式一：
                /* 错误的写法
                for (int i = 0; i < charBuffer.length; i++) {
                    System.out.print(charBuffer[i]);   //HelloWorld123ld
                }
                */

//                for (int i = 0; i < len; i++) {
//                    System.out.print(charBuffer[i]);  //HelloWorld123
//                }

                //方式二：
                /*错误的写法
                String str = new String(charBuffer);
                System.out.println(str);  ////HelloWorld123ld
                */

                String str = new String(charBuffer, 0, len);
                System.out.print(str); //HelloWorld123
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、资源的关闭
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从内存中写出输出到文件里
     * 说明：
     * 1、输出操作，对应的File可以不存在
     * 2、     如果不存在:则会自动创建
     *        如果存在：如果流使用的构造器是：FileWriter(file,false) / FileWriter(file) :对有文件覆盖
     *                如果流使用的构造器是：FileWriter(file,true):对原有文件追加类容
     *
     */
    @Test
    public void testFileWriter(){

        FileWriter fw = null;
        try {
            //1、提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            //2、提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,true);

            //3、写出的操作
            fw.write("I have dream!\n");
            fw.write("you need to have a dream!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流资源的关闭
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Test
    public void testFileReaderFileWriter(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {

            //1、创建File类的对象，指明读入和写入的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello1.txt");

            /*不能用字符流处理图片数据，图片：错误的,因为图片是按字节储存的
            File srcFile = new File("img.png");
            File destFile = new File("img1.png");
            */

            //2、创建输入流和输出流的对象
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(destFile,true);

            //3、数据的读入和写入操作
            char[] charBuffer = new char[5];
            int len;  //记录每次读入到charBuffer数组中的字符的个数
            while ((len = fileReader.read(charBuffer)) != -1){
                //每次写出len个字符
                fileWriter.write(charBuffer,0,len);
            }
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4、关闭资源流
                if(fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                //4、关闭资源流
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}











































