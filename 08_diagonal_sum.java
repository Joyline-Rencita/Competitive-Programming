Problem Statement
Chris is at the entrance of Adventureland, where there is a magic grid of size N x N, filled entirely with the number 1. To gain entry, he must correctly calculate the sum of the integers on both the main and 
secondary diagonals of the grid. The task is to help Chris quickly calculate this sum.
Note: As both diagonals are considered separately, the center element is counted only once when N is odd.

Input Format
The first line of input consists of integer N – representing the number of rows and columns of the matrix.

Output Format
Print a single line of output consisting of the sum of the diagonal integers

Constraints
1<= N <= 105

Sample Testcase 0
Testcase Input
2
Testcase Output
4
Explanation
The matrix is:
1 1
1 1
The total sum will be (1+ 1) + (1 + 1) = 4.

Sample Testcase 1
Testcase Input
4
Testcase Output
8
Explanation
We take the sum of that integers which is shown as bold in below matrix:
[1,1,1,1]
[1,1,1,1]
[1,1,1,1]
[1,1,1,1]
=> 8.

Sample Testcase 2
Testcase Input
3
Testcase Output
5
Explanation
The matrix is:
1 1 1
1 1 1
1 1 1
The total sum will be (1+ 1 + 1) + (1 + 1) = 5.

SOLUTION : 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the matrix
        int N = scanner.nextInt();
        
        // Calculate the sum of the main diagonal and secondary diagonal
        long sum = 0;
        
        // Sum of the main diagonal (i, i)
        for (int i = 0; i < N; i++) {
            sum += 1; // Since all elements are 1, we just add 1 N times
        }
        
        // Sum of the secondary diagonal (i, N-1-i)
        for (int i = 0; i < N; i++) {
            sum += 1; // Similarly, add 1 N times
        }
        
        // Adjust for the duplicate middle element if N is odd
        if (N % 2 == 1) {
            sum -= 1; // Subtract the duplicate middle element once
        }
        
        // Output the total sum
        System.out.println(sum);
        
        scanner.close();
    }
}
