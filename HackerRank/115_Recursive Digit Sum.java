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
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    private static int superDigitRecursive(long num) {
        // Base case: if the number is a single digit, return it
        if (num < 10) {
            return (int) num;
        }
        
        // Sum the digits of the number
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        // Recursively call superDigit on the sum of the digits
        return superDigitRecursive(sum);
    }

    public static int superDigit(String n, int k) {
        // Step 1: Calculate the sum of digits of n
        long sumOfDigits = 0;
        for (char digit : n.toCharArray()) {
            sumOfDigits += Character.getNumericValue(digit);
        }
        
        // Step 2: Multiply the sum by k
        long totalSum = sumOfDigits * k;
        
        // Step 3: Calculate the super digit of the total sum
        return superDigitRecursive(totalSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
