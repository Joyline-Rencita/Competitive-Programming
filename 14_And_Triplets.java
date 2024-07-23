Problem Statement
Given an integer array, arr. Display the count of AND triplets. An AND triplet is a set of three indices i, j, and k such that:
0 <= i<arr.length
0 <= j <arr.length
0 <= k <arr.length
arr[i] &arr[j] &arr[k] == 0, where & represents the bitwise-AND operator.
 
Input Format
The first line contains an integer n, the number of elements in the array. The following line contains n numbers, arr[i], the elements of the array.

Output Format
Print the number of AND triplets in the array.

Constraints
1<=n<=1000

0 <= arr[i] < 216

Sample Testcase 0
Testcase Input
2
1 2 
Testcase Output
6
Explanation
We can select the following i, j ,k triples:
(i = 0, j = 0, k = 1) : 1&1&2 = 0
(i = 0, j = 1, k = 1) : 1&2&2 = 0
(i = 1, j = 0, k = 1) : 2&1&2 = 0
(i = 1, j = 1, k = 0) : 2&2&1 = 0
(i = 0, j = 1, k = 0) : 1&2&1 = 0
(i = 1, j = 0, k = 0): 2&1&1 = 0

Sample Testcase 1
Testcase Input
3
2 1 3 
Testcase Output
12
Explanation
We could choose the following i, j, k triples:
(i=0, j=0, k=1) : 2 & 2 & 1
(i=0, j=1, k=0) : 2 & 1 & 2
(i=0, j=1, k=1) : 2 & 1 & 1
(i=0, j=1, k=2) : 2 & 1 & 3
(i=0, j=2, k=1) : 2 & 3 & 1
(i=1, j=0, k=0) : 1 & 2 & 2
(i=1, j=0, k=1) : 1 & 2 & 1
(i=1, j=0, k=2) : 1 & 2 & 3
(i=1, j=1, k=0) : 1 & 1 & 2
(i=1, j=2, k=0) : 1 & 3 & 2
(i=2, j=0, k=1) : 3 & 2 & 1
(i=2, j=1, k=0) : 3 & 1 & 2

SOLUTION : 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of elements in the array
        int n = scanner.nextInt();
        
        // Read the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        // Initialize the count of AND triplets
        int count = 0;
        
        // Iterate through all possible triplets (i, j, k)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((arr[i] & arr[j] & arr[k]) == 0) {
                        count++;
                    }
                }
            }
        }
        
        // Output the count of valid triplets
        System.out.println(count);
    }
}
