import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        // Create frequency arrays for both strings
        int[] freqS1 = new int[26]; // For characters 'a' to 'z'
        int[] freqS2 = new int[26];
        
        // Count frequency of each character in s1
        for (char c : s1.toCharArray()) {
            freqS1[c - 'a']++;
        }
        
        // Count frequency of each character in s2
        for (char c : s2.toCharArray()) {
            freqS2[c - 'a']++;
        }
        
        // Calculate the number of deletions required
        int deletions = 0;
        for (int i = 0; i < 26; i++) {
            deletions += Math.abs(freqS1[i] - freqS2[i]);
        }
        
        return deletions;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
