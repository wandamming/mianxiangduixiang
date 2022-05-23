package atguigu;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        new PassObject().printAreas(c,5);
        double radius = c.radius + 1.0;
        System.out.println("now radius is " + radius);
    }
}

class Circle{
    Scanner scanner = new Scanner(System.in);
    double radius; //半径
    public double findArea(){
        return Math.PI * radius * radius;
    }
}

class PassObject{
    public  void printAreas(Circle c, int time){
        Scanner scanner = new Scanner(System.in);
        time = scanner.nextInt();
        System.out.println("Radius\t\tArea");
        for (int i = 1; i <= time; i++){
            c.radius = i;
            System.out.println(c.radius + "\t\t" +c.findArea());
        }
    }
}
