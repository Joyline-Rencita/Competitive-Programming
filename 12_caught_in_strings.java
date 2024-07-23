Problem Statement
Ravi discovered that some strings read the same forwards and backwards, which are called palindromes.He noticed that every string he encountered has at least one palindromic substring. He wants to know how to find
the longest palindromic substring in a given string. Can you help him determine the length of this longest palindromic substring?

Input Format
The first line contains n the length of the string. The following line has s, the input string

Output Format
Print the length of the longest palindromic substring that is possible.
Constraints
1<=n<=1000
Sample Testcase 0
Testcase Input
5 
abacc
Testcase Output
3
Explanation
The given string is abacc The possible palindromic substrings present are ‘a’, ‘b,’ ‘c,’ ‘aba,’ ‘cc,’ and the longest substring is ‘aba’ of length 3.

Sample Testcase 1
Testcase Input
6
abcdef
Testcase Output
1
Explanation
The given string is abcdef The possible palindromic substrings are ‘a’, ‘b,’ ‘c,’ ‘’d, ‘e,’ ‘f.’ The length of the longest palindromic substring is 1

SOLUTION:

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the length of the string
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Read the input string
        String s = scanner.nextLine();
        
        // Edge case
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Initialize DP table
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }

        // Check substrings of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = length;
                }
            }
        }

        // Output the length of the longest palindromic substring
        System.out.println(maxLength);

        scanner.close();
    }
}
