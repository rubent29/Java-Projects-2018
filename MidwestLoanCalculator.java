/*
Authors: Ruben Torrico
Date: 10/28/18
Program: Midwest Loan
Description: Loan Calculator for employees to use to input
customer personal and loan information.
*/
package MidWestLoanHW5;
import java.util.*;
public class MidWestLoan {
 

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String custInfo[][] = new String[100][6];
        double custFinances[][] = new double[100][5];
        double monthlyBalance [][] = new double [100][5];
         
        boolean menuLoop = true; //remains true to continue loop everytime after action 
        int custCount = 0;
        int input = 0;
        int choice = 0;
        int counter = 1; //counts first entry as 1 and continues to count everytime a customer is added
        
        while(true){ //brings back main menu after every executed action
            
        System.out.println("------------------------------------------");
        System.out.println("\tMidWest Loan Menu Options: ");
        System.out.println("------------------------------------------");
        System.out.println("1.) Create a New Loan Customer");
        System.out.println("2.) Display Loan Amortization Table");
        System.out.println("3.) Display Report");
        System.out.println("4.) Quit");
        System.out.println("");
        System.out.print("Enter Your Menu Choice: ");
        
        choice = in.nextInt(); 
     
        switch (choice) {
        //calls method to create userID
        case 1: 
            //System.out.println(counter);
            counter++;
            System.out.print("Generated Customer ID: " + custCount);
            System.out.print("\n");
                  
            System.out.println("Input New Customer ID given above: ");
            String custId = Integer.toString(custCount);
            double loanId = Double.valueOf(custCount);
            
            System.out.print("Enter First Name: ");
            String fName = in.next();
            
            System.out.print("Enter Last Name: ");
            String lName = in.next();
            
            System.out.print("Enter Street Address: ");
            String addy = in.nextLine();
            addy = addy.replace("", " ");
            addy = in.nextLine();
            
            System.out.print("Enter Cell Phone Number(No Spaces!): ");
            String phoneNum = in.next();
            
            System.out.print("Enter Customer Age: ");
            String custAge = in.next();
            
            storeCustInfo(input, custId, fName, lName, addy, phoneNum , custAge, custInfo);              

            System.out.println(" ");

            
            System.out.println("-----------------------------");
            System.out.println("Enter Loan Information: ");
            System.out.println("-----------------------------");
            
            
            System.out.println("Enter Customer ID given above: ");
            loanId = in.nextDouble();
          
            System.out.println("Enter Loan Amount: ");
            double loanAmt = in.nextDouble();
            
            System.out.println("Enter Loan Interest Rate (decimal form): ");
            double loanYrRate = in.nextDouble();
            
            System.out.println("Enter Monthly Payment Amount: ");
            double loanPayment = in.nextDouble();

            System.out.println(" ");
            

            storeLoanInfo(custCount, loanId, loanAmt, loanYrRate, loanPayment, custFinances);
            input++;
            custCount++;

            System.out.println(" ");
            
            break;
            
        case 2:
            System.out.println(" ");
            System.out.print(" ");
            System.out.println("\n----------------------------------------------");
            System.out.print("\tID" + "\tFirst Name" + "\tLast Name");
            System.out.print("\n----------------------------------------------");
            for (int i = 0; i < custCount; i++){
            
            System.out.printf("\n\t%.0f", custFinances[i][0]);
            System.out.print("\t" + custInfo[i][1]);
            System.out.print("\t\t" + custInfo[i][2]);
            System.out.println("");
            System.out.println("");
            }
            
            System.out.print("\nEnter ID of Customer whom you would like to see: ");
            custCount = in.nextInt();

            for (int i = 0; i < custCount + 1; i++){
                
                for(int j = 0; j < custInfo[i].length; j++)
                if (custCount == 0);{
                    System.out.print("\n\t\t\tLoan Amortization Table");
                    System.out.print(" ");
                    double begBal = (custFinances[0][1]);
                    double yrInt = (custFinances[0][2]);
                    double payment = (custFinances[0][3]);
                    loanLength(begBal,yrInt,payment);  
                    monthlyBalance = makeMonthlyCost(monthlyBalance, begBal,yrInt,payment); 
                    
            } 
            }
            
            System.out.println("");

            break;
            
        case 3:
            //Couldnt figure out how to match up in the values in the array so the information would print on the reports
            //Couldnt match loan amounts with customer names
            System.out.println("Customer Report");
            System.out.println("Select which report you would like to display");
            System.out.println("(1)Customers and loan amounts");
            System.out.println("(2)Loan amount ranges");
            System.out.println("Enter your selection: ");
            int selection = in.nextInt();
            switch (selection){
                
            case 1: //loan amount descending
               int loops = custCount;
               double[][] loanInfoSort = new double[10][2];
               for (int i = 0; i < loops; i++){
                   
                   loanInfoSort[i][0] = custFinances[i][1];
                   for (int j = 0; j < 1; j++)
                   {
                       loanInfoSort[j][1] = (int)custFinances[i][0];
                   }
                   System.out.println();
               }
               double[] sortArray = new double[loanInfoSort.length];
               for (int i = 0; i < loops ; i++)
               {
                   sortArray[i] = loanInfoSort[i][0];
               }
               java.util.Arrays.sort(sortArray);
             
                System.out.println("-----------------------------------------");
                System.out.println("Customer " + "\t" + "Loan Amount");
                System.out.println("-----------------------------------------");
            for (int i = custCount -1; i >= 0; i--){ //pair the loan amount to the customerID and name
            
                for (int j = custCount - 1; j >= 0; j--){
                    if (sortArray[i] == loanInfoSort[j][1]){
                    
                System.out.print(sortArray[i] + "\t\t" + loanInfoSort[j][0] + " " + loanInfoSort[j][1]);  
                System.out.println("");
                }
            }
            } 
            System.out.println("");
            break;

            case 2:  
                  loanInfoSort = new double[custCount][2];
                  
                 
                  System.out.println("Customer loan amount from $0 - $2,500 ");
                  System.out.println("-------------------------------------------");
                  
                  for (int i = 0; i < custCount; i++)
                  {
                      if ((loanInfoSort[i][1] >= 0) && (loanInfoSort[i][1] < 2500))
                          System.out.println(loanInfoSort[i][1] + " " + loanInfoSort[i][2]);
                  }
                
                   System.out.println("\n");   
                   System.out.println("Customers loan amount from $2,5000 - $5,000 ");
                   System.out.println("-------------------------------------------");
                   
                   for (int i = 0; i < custCount; i++)
                   {
                      if ((loanInfoSort[i][1] >= 2500) && (loanInfoSort[i][1] < 5000))
                          System.out.println(loanInfoSort[i][1] + " " + loanInfoSort[i][2]);
                   }
                 
                    System.out.println("\n");
                    System.out.println("Customer loan amount from $5,000 - $10,000 ");
                    System.out.println("-------------------------------------------");
                    
                    for (int i = 0; i < custCount; i++)
                    {
                      if ((loanInfoSort[i][1] >= 5000) && (loanInfoSort[i][1] < 10000))
                          System.out.println(loanInfoSort[i][1] + " " + loanInfoSort[i][2]);
                    }
                  
                    System.out.println("\n");
                    System.out.println("Customer loan amount greater or equal to $10,000 ");
                    System.out.println("---------------------------------------------------------------");
                      
                    for (int i = 0; i < custCount; i++)
                    {
                      if (loanInfoSort[i][1] >= 10000)
                          System.out.println(loanInfoSort[i][1] + " " + loanInfoSort[i][2]);
                    } 
           
         
                  break;
                  default:
            }
        
  
        case 4:
            System.out.println(" ");
            System.out.println("Quit");
            System.out.println("");
            break;
        
        default:  
            
       }
        }
       }
        public static void storeCustInfo(int input, String custCount, String fName, String lName, String addy,
                String phoneNum , String custAge, String custArr [][])   
    {
            int countRow = input;
            int countCol = 0;
       
            custArr[countRow][countCol] = custCount;
            countCol++;
            
            custArr[countRow][countCol] = fName;
            countCol++;
            
            custArr[countRow][countCol] = lName;
            countCol++;
            
            custArr[countRow][countCol] = addy;
            countCol++;
            
            custArr[countRow][countCol] = phoneNum;
            countCol++;
            
            custArr[countRow][countCol] = custAge; 
            }
        
   
        public static void storeLoanInfo(int input, double loanId, double loanAmt,
                double loanYrRate, double loanPayment, double loanArr [][])
        {
            int countRow = input;
            int countCol = 0;
       
            loanArr[countRow][countCol] = loanId;
            countCol++;
            
            loanArr[countRow][countCol] = loanAmt;
            countCol++;
            
            loanArr[countRow][countCol] = loanYrRate;
            countCol++;
            
            loanArr[countRow][countCol] = loanPayment;

            }

       public static void loanLength(double begBal, double yrInt, double payment){
        yrInt = ((yrInt / 12.0)/100.0); 

            double month = 0; 
            while (begBal > 0){ //loop goes until the debt is paid off 
                month+=1;
                double interest = begBal * yrInt; 
                if (payment < interest){ 
                }
                if (begBal < payment) { 
                    payment = begBal + interest;
                }
                begBal = (interest + begBal) - payment; //formula for amount due per period
                if (begBal < 0) { 
                 begBal = 0.0;
                }

                System.out.println(); 
                }
            System.out.println();  
            System.out.print("The life of this loan is ");
            System.out.printf("%.0f", month);
            System.out.print(" Months.\n");

}
         public static double[][] makeMonthlyCost(double [][] monthlyBalance, double begBal, double yrInt, double payment){
            yrInt = ((yrInt / 12.0)/100.0); 
            System.out.println("\nPeriod \t \t Balance:  \t Interest:  \t Payment:  \t New Balance:"); 
            double month = 0;
            while (begBal > 0){ 
                month+=1; 
                double interest = begBal * yrInt; 
                if (payment < interest){ 
                }
                    System.out.printf("Month# %.0f ", month); 
                    System.out.printf(" \t $%.2f ",begBal); 
                 
                if (begBal < payment) { 
                    payment = begBal + interest;
                }
                    System.out.printf("  \t $%.2f ",interest); 
                    System.out.printf(" \t $%.2f ", payment); 
             
                begBal = (interest + begBal) - payment; 

                if (begBal < 0) { 
                 begBal = 0.0;
                 System.out.print(month);
                }
                 System.out.printf(" \t $%.2f ", begBal);
            
            System.out.println(); 
        }
            return monthlyBalance;
    }  
}
    
    
    

