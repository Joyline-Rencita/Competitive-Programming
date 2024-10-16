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
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) {
        int totalLoaves = 0;
        int loavesDistributed = 0;

        // Calculate the total number of loaves
        for (int loaves : B) {
            totalLoaves += loaves;
        }

        // If the total is odd, it's impossible to make all even
        if (totalLoaves % 2 != 0) {
            return "NO";
        }

        // Distribute loaves to make all counts even
        for (int i = 0; i < B.size() - 1; i++) {
            if (B.get(i) % 2 != 0) {
                B.set(i, B.get(i) + 1);        // Give one loaf to current person
                B.set(i + 1, B.get(i + 1) + 1); // Give one loaf to next person
                loavesDistributed += 2;        // Count the loaves distributed
            }
        }

        return String.valueOf(loavesDistributed);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
