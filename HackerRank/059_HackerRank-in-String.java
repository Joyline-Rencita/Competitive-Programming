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
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {
        String target = "hackerrank"; // Target subsequence
        int targetIndex = 0; // Pointer for target string

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            // Check if the current character matches the target character
            if (s.charAt(i) == target.charAt(targetIndex)) {
                targetIndex++; // Move to the next character in the target
            }
            // If we have matched all characters in the target
            if (targetIndex == target.length()) {
                return "YES"; // Found the subsequence
            }
        }
        return "NO"; // Did not find the subsequence
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

                String result = Result.hackerrankInString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
