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
     * Complete the 'decentNumber' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void decentNumber(int n) {
        int fives = n;

        // Find the largest number of 5's divisible by 3
        while (fives % 3 != 0) {
            fives -= 5; // Reduce by 5 to try making 3's divisible by 5
        }

        // If fives became negative, no decent number can be formed
        if (fives < 0) {
            System.out.println("-1");
        } else {
            StringBuilder result = new StringBuilder();
            
            // Append 'fives' number of 5's
            for (int i = 0; i < fives; i++) {
                result.append('5');
            }
            
            // Append the remaining number of 3's
            for (int i = 0; i < n - fives; i++) {
                result.append('3');
            }
            
            // Print the result
            System.out.println(result.toString());
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                Result.decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
