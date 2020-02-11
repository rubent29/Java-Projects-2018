/*
Author: Ruben Torrico
Date: 9/24/18
Program: Phrase Analyzer
Description: Count the number of times the selected character is shown in the sentence.
 */

package ch4and5;
import java.util.Scanner;
public class JavaHW4 {

    public static void main(String[] args) {
        //create print statements that will store user inputs into the program
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a phrase to analyze: ");
        String word = in.nextLine();
        word = word.toLowerCase();
        word = word.replace(" ", "");
        System.out.print("Enter four characters to count in a phrase: ");
        String aCount = in.next();
        String bCount = in.next();
        String cCount = in.next();
        String dCount = in.next();
        
        //create length of words inputted and create counters 
        int len = word.length();
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
  
        //create loop that will count each desired letter
        for(int i = 0; i < len; i++)
        {
            char letter1 = aCount.charAt(0);
            char letter2 = bCount.charAt(0);
            char letter3 = cCount.charAt(0);
            char letter4 = dCount.charAt(0);
            char sentence = word.charAt(i);
            
            //if else statement to count each individual letter
            if (letter1 == sentence) 
            {
               counter1++;   
            }   
            else if (letter2 == sentence)
            {
                counter2++;
            }
             else if (letter3 == sentence)
            {
                counter3++;
            }
             else if (letter4 == sentence)
            {
                counter4++;
            }
        }
        
        //creates print statement format including letters and counters
        System.out.println("Counts the letter " + "'" + aCount + "': " + counter1 + ", ");
        System.out.println("Counts the letter " + "'" + bCount + "': " + counter2 + ", ");
        System.out.println("Counts the letter " + "'" + cCount + "': " + counter3 + ", ");
        System.out.println("Counts the letter " + "'" + dCount + "': " + counter4);
       
    }
    
}
