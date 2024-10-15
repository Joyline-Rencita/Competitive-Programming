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
     * Complete the 'misereNim' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY s as parameter.
     */

    public static String misereNim(int[] s) {
        int n = s.length;
        
        // If there is only one pile
        if (n == 1) {
            return s[0] > 1 ? "First" : "Second";
        }
        
        int total = s[0]; // Total number of stones
        int xor = s[0];   // XOR of all piles

        // Calculate the total stones and XOR for the piles
        for (int i = 1; i < n; i++) {
            total += s[i];
            xor ^= s[i];
        }
        
        // If all piles have only one stone
        if (total == n) {
            return (n % 2 == 0) ? "First" : "Second";
        }
        
        // If the XOR of all pile sizes is non-zero
        return xor > 0 ? "First" : "Second";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        // Loop over each test case
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                // Read the input as a List of Integers
                List<Integer> sList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

                // Convert List<Integer> to int[]
                int[] s = sList.stream().mapToInt(Integer::intValue).toArray();

                String result = Result.misereNim(s);

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
