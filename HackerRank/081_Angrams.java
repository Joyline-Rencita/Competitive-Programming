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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        int length = s.length();

        // Check if the string length is odd
        if (length % 2 != 0) {
            return -1; // Cannot split into two equal parts
        }

        // Split the string into two halves
        String s1 = s.substring(0, length / 2);
        String s2 = s.substring(length / 2, length);

        // Create frequency maps for both halves
        int[] freq1 = new int[26]; // For the first half
        int[] freq2 = new int[26]; // For the second half

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++; // Count frequency of each character in the first half
        }
        for (char c : s2.toCharArray()) {
            freq2[c - 'a']++; // Count frequency of each character in the second half
        }

        // Calculate the number of changes needed
        int changes = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > freq2[i]) {
                changes += freq1[i] - freq2[i]; // Count excess characters
            }
        }

        return changes; // Minimum number of changes needed
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
