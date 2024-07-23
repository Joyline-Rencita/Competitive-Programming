Problem Statement : 
We are given a string s consisting of only lowercase letters of english, and a character ch. Let the index of last occurence of ch be idx, reverse the string from idx.

Input Format
First line contains a string s.

Output Format
Return the transformed string

Constraints
1<=|s|<=100000

Sample Testcase 0
Testcase Input
abc c
Testcase Output
abc
Explanation
Last occurrence of c is the last character of the string, so reversing it won’t change the string.

Solution : 

  import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        
        // Reading the full line for the string input
        String s = scanner.nextLine();
        
        // Reading the next token for the character input
        char ch = scanner.next().charAt(0);
        
        scanner.close();

        // Find the index of the last occurrence of ch
        int idx = s.lastIndexOf(ch);
        
        // If ch is not found in the string, return the original string
        if (idx == -1) {
            System.out.println(s);
            return;
        }

        // Split the string into two parts
        String firstPart = s.substring(0, idx + 1);
        String secondPart = s.substring(idx + 1);

        // Reverse the second part
        String reversedSecondPart = new StringBuilder(secondPart).reverse().toString();

        // Concatenate the two parts
        String result = firstPart + reversedSecondPart;

        // Print the result
        System.out.println(result);
    }
}
