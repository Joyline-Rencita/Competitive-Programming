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
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        int turn = 0; // to track turns, even means Richard, odd means Louise

        while (n > 1) {
            if ((n & (n - 1)) == 0) {
                // If n is a power of 2, divide by 2
                n /= 2;
            } else {
                // Otherwise subtract the largest power of 2 less than n
                long highestPowerOf2 = Long.highestOneBit(n);
                n -= highestPowerOf2;
            }
            turn++; // Increment the turn after each move
        }

        // If turn is odd, Louise wins, otherwise Richard wins
        return (turn % 2 == 1) ? "Louise" : "Richard";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result.counterGame(n);

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
