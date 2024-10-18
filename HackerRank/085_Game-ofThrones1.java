import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
        // Create a frequency array for characters 'a' to 'z'
        int[] freq = new int[26];

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Count how many characters have an odd frequency
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // If more than one character has an odd frequency, it's not possible
        if (oddCount > 1) {
            return "NO";
        }

        return "YES";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
