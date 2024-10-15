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
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) {
        // Reverse the string
        String reversed = new StringBuilder(s).reverse().toString();
        
        // Initialize lists for absolute differences
        List<Integer> originalDifferences = new ArrayList<>();
        List<Integer> reversedDifferences = new ArrayList<>();
        
        // Calculate absolute differences for the original string
        for (int i = 1; i < s.length(); i++) {
            originalDifferences.add(Math.abs(s.charAt(i) - s.charAt(i - 1)));
        }
        
        // Calculate absolute differences for the reversed string
        for (int i = 1; i < reversed.length(); i++) {
            reversedDifferences.add(Math.abs(reversed.charAt(i) - reversed.charAt(i - 1)));
        }
        
        // Compare the two lists of differences
        return originalDifferences.equals(reversedDifferences) ? "Funny" : "Not Funny";
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

                String result = Result.funnyString(s);

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
