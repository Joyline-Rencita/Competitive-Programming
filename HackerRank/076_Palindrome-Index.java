import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Check if skipping left character makes it a palindrome
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                // Check if skipping right character makes it a palindrome
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                // If neither makes it a palindrome, return -1
                return -1;
            }
            left++;
            right--;
        }
        return -1;  // The string is already a palindrome
    }

    // Helper function to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());  // Number of queries

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();
            int result = Result.palindromeIndex(s);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
