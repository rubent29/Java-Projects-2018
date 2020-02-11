/*
Author: Ruben Torrico
Date: 9/8/18
Program: Student Grade Simulation
Description:  Simulating random grades for students 
and calculating averages for each student and homework assignment
*/
package ch4and5;
import java.util.*;

public class JavaHW3 {

    public static void main(String[] args) {
        //create variable of number of students
        int numOfStudents = 0;
        
        //allows user to input number of students 
        Scanner keyboardIn = new Scanner(System.in);
        System.out.print("Enter number of students to simulate: ");
        numOfStudents = keyboardIn.nextInt();
        
        //creates header for simulation
        System.out.print("Beginning Simulation: ");
        System.out.println("\n===================================== ");
        System.out.print("Name:\t\t HW1\t HW2\t HW3\t HW4\t HW5\t Average:");
       
        System.out.println("\n------------------------------------------------------------------ ");
        
        //creates column for number of students entered
        //int r = (int)Math.random() * 100 + 30;
        int rand = 0;
        double avg = 0.0;
        int sum = 0;
        double hw1 = 0.0;
        double hw2 = 0.0;
        double hw3 = 0.0;
        double hw4 = 0.0;
        double hw5 = 0.0;
        
       
        
        for (int i = 1; i <= numOfStudents; i++)     
        {
            System.out.print("Student #" + i + ": "); 
            
            for (int j = 0; j <= 4; j++)
            {
                rand = (int)(Math.random() * (100 - 30) + 30);
                System.out.printf("\t%d", rand);
                avg += rand;
                
                if (j < 1)
                {
                    hw1 += rand;
                }
                else if (j < 2)
                {
                    hw2 += rand;
                }
                else if (j < 3)
                {
                    hw3 += rand;
                }
                else if (j < 4)
                {
                    hw4 += rand;
                }
                else if (j < 5)
                {
                    hw5 += rand;
                }
                   
            }
            System.out.printf("\t%.2f", avg / 5 / i);
            System.out.println(" ");
        } 
        double hw1avg = hw1 /numOfStudents;
        double hw2avg = hw2 /numOfStudents;
        double hw3avg = hw3 /numOfStudents;
        double hw4avg = hw4 /numOfStudents;
        double hw5avg = hw5 /numOfStudents;
        
        System.out.println("------------------------------------------------------------------ "); 
        System.out.print("Averages: "); 
        System.out.printf("\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f", hw1avg, hw2avg, hw3avg, hw4avg, hw5avg);
        System.out.println("\n------------------------------------------------------------------ ");
        System.out.println("Simulation finished!");  
        
    } 
   
    
}
