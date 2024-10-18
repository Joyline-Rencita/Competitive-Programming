import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'strangeCounter' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER t as parameter.
     */

    public static long strangeCounter(long t) {
        long cycleStart = 1; // The start time of the current cycle
        long cycleLength = 3; // The length of the current cycle
        
        // Find the cycle containing the time t
        while (t > cycleStart + cycleLength - 1) {
            cycleStart += cycleLength; // Move to the start of the next cycle
            cycleLength *= 2; // Each cycle doubles in length
        }
        
        // At this point, cycleStart is the start of the cycle containing t
        long counterValue = cycleLength - (t - cycleStart); // Calculate the counter value
        return counterValue;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
