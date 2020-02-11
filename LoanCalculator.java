/*
Author: Ruben Torrico
Date: 9/8/18
Program: Loan Calculator
Description: Calculating interest and principle after a payment 
*/
//package ch2;
import java.util.Scanner;

public class JavaHW2LoanCalculator {

    public static void main(String[] args) {
        //establishes variables that will be changed by user input
        double principleValue = 0.0;
        double interestRateValue = 0.0;
        int numberOfMonthsValue = 0;
        double monthlyPaymentValue = 0.0;
        double result = 0.0;
        
        
       //allows user to input information that will be calculated
        Scanner keyboardIn = new Scanner(System.in);
        System.out.print("Enter the Principle: ");
        principleValue = keyboardIn.nextDouble();
        System.out.print("Enter the Interest Rate: ");
        interestRateValue = keyboardIn.nextDouble();
        System.out.print("Enter the Number of Months: ");
        numberOfMonthsValue = keyboardIn.nextInt();
        System.out.print("Enter the Monthly Payments: ");
        monthlyPaymentValue = keyboardIn.nextInt();
        
        //calculations for interest and principle after payment for first month
        double irValue = principleValue * (interestRateValue / 100 / 12);
        double principleAfterPayment = (principleValue + irValue - monthlyPaymentValue);
        
        //calculates princple, interest, and principle after payment for the first month
        System.out.print("Month 1: Principle - $" + principleValue
        );
        System.out.print(", Interest: $" + irValue
        );
        System.out.println("");
        System.out.println("    Principle after Payment: $" + principleAfterPayment);
        
        //calculations for interest and principle after payment for second month
        double irValue2 = principleAfterPayment * (interestRateValue / 100 / 12);
        double principleAfterPayment2 = (principleAfterPayment + irValue2 - monthlyPaymentValue);
        
        //calculates princple, interest, and principle after payment for the second month
        System.out.print("Month 2: Principle - $" + principleAfterPayment);
        System.out.print(", Interest: $" + irValue2);
        System.out.println("");
        System.out.println("    Principle after Payment: $" + principleAfterPayment2);
            
                
        
         
    }
    
}
