package MapTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

    //Properties：常用来处理配置文件，key和value都是String类型
    public static void main(String[] args) throws Exception {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            //此时的文件默认在当前的项目下
            //读取配置文件的方式一：
//            fis = new FileInputStream("jdbc.properties");
//            pros.load(fis);  //加载流对应的文件

            //方式二：使用ClassLoader
            //配置文件默认在当前module的scr下
            ClassLoader classLoader = PropertiesTest.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
            pros.load(resourceAsStream);

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            fis.close();
        }
    }
}
