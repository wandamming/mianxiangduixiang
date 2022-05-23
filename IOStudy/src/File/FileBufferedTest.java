package File;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流
 * 1、作用：提高流的读取，写入速度
 *      原理：内部提供缓冲区flash（）
 * 2、处理流，“套接”在已有的流的基础上。
 */
public class FileBufferedTest {

    @Test
    public void BufferStreamTest()  {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //1、造文件
            File srcFile = new File("img.png");
            File destFile = new File("img3.png");

            //2、造流
            //2.1、造节点流
            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);

            //2.2、造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3、读取，写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、资源关闭。要求先关闭外层的流，在关闭内存的流
            try {
                if(bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //说明，关闭外层流的同时，内层流也会自动关闭，所以可省略
//        fileOutputStream.close();
//        fileInputStream.close();
        }

    }

}




























