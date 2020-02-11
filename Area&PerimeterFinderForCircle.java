package ch6;
import java.util.Scanner;

public class CircleRadiusMethod {

    public static void main(String[] args) {
        double radius = 0.0;
        double perimeter = 0.0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the radius of the Circle: ");
        radius = in.nextDouble();
        
        System.out.printf("The area of the circle is: " + "%.2f", getRadius(radius));
        System.out.println(" ");
        System.out.printf("The perimeter of the circle is: " + "%.2f", getPerimeter(radius));
        System.out.println(" ");
        
      

    }
    
    public static double getRadius(double radius){
        return (radius * radius * Math.PI);
    }
    
    public static double getPerimeter(double radius){
        return (2 * Math.PI * radius);
    }  
}
