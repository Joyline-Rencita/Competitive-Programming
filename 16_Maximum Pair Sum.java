Problem Statement : 
In a magical bag, there are "n" balls, each with a unique number. You are asked to figure out the the pair of balls where their difference and product combine to create the maximum sum among all possible 
combinations.  Display the maximum sum.

Input Format
The first line of input consists of the integer n – representing the number of balls

The second line consists of n integers – a1, a2, a3, . . . , an.

Output Format
Print the maximum sum obtained.

Constraints
2 <= n <= 100000

-100 <= ai <= 1000.

Sample Testcase 0
Testcase Input
4
2 4 5 1
Testcase Output
21
Explanation
Among the pair of balls possible, the pair of 2nd and 3rd ball gives the maximum sum:
((5-4)+(5*4))= (1+20) = 21

Sample Testcase 1
Testcase Input
6
8 1 5 3 4 2
Testcase Output
43
Explanation
For the given balls the pair with value 8 and 5 (1st and 3rd ball) gives the maximum sum among all pairs: (8-5)+(8*5)= 3+40 = 43

Solutions : 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of balls
        int n = scanner.nextInt();
        int[] balls = new int[n];
        
        // Read the ball values
        for (int i = 0; i < n; i++) {
            balls[i] = scanner.nextInt();
        }
        
        // Initialize the maximum and second maximum values
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        // Find the maximum and second maximum values
        for (int i = 0; i < n; i++) {
            if (balls[i] > max1) {
                max2 = max1;
                max1 = balls[i];
            } else if (balls[i] > max2) {
                max2 = balls[i];
            }
        }
        
        // Compute the maximum sum
        int maxSum = (max1 - max2) + (max1 * max2);
        
        // Output the result
        System.out.println(maxSum);
        
        scanner.close();
    }
}
