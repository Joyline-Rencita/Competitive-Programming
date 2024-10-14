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
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        // Flag to check if the number is beautiful
        boolean isBeautiful = false;
        
        // Try each possible length for the first number (1 to half of the string length)
        for (int length = 1; length <= s.length() / 2; length++) {
            // Get the first number
            String firstNumberStr = s.substring(0, length);
            long firstNumber = Long.parseLong(firstNumberStr);
            
            // Build the expected sequence starting from the first number
            StringBuilder sequence = new StringBuilder(firstNumberStr);
            long nextNumber = firstNumber + 1;
            
            // Keep appending next consecutive numbers until the sequence length matches the input length
            while (sequence.length() < s.length()) {
                sequence.append(nextNumber);
                nextNumber++;
            }
            
            // Check if the generated sequence matches the input string
            if (sequence.toString().equals(s)) {
                System.out.println("YES " + firstNumber);
                isBeautiful = true;
                break;
            }
        }
        
        // If no valid sequence was found, print NO
        if (!isBeautiful) {
            System.out.println("NO");
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
