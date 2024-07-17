Problem Statement
One day jack finds a string of characters. He is very keen to arrange the characters in reverse order, i.e., first characters become the last characters, second characters become the second-last characters, 
and so on. Now he wants your help  to find the kth character from the new string formed after reverse the original string.

Note: String contain only lowercase Latin letters.

Input Format
The first line contains two integers n, k — the length of array and the value of k respectively.
The second line contains a string containing n characters.
Output Format
Print a single line containing the kth character of the string.

Constraints
1 ≤ k ≤ n≤ 10^6

Sample Testcase 0
Testcase Input
5 2
abdfa
Testcase Output
f
Explanation
The reversed string is:"afdba"

The 2nd character after the reversing the string is f.

SOLUTION : 

import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the length of the string and the value of k
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        // Read the string
        String inputString = scanner.nextLine();

        // Find the k-th character in the reversed string
        char kthChar = inputString.charAt(n - k);

        // Print the result
        System.out.println(kthChar);
    }
}
