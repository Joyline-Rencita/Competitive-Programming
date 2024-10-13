import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        // Initialize scores for Alice and Bob
        int aliceScore = 0;
        int bobScore = 0;
        
        // Compare each corresponding element
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;  // Alice gets a point
            } else if (a.get(i) < b.get(i)) {
                bobScore++;    // Bob gets a point
            }
            // No need to do anything if a[i] == b[i], no points awarded
        }
        
        // Return the result as a list of two integers
        return Arrays.asList(aliceScore, bobScore);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read Alice's ratings
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        // Read Bob's ratings
        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        // Get the result
        List<Integer> result = Result.compareTriplets(a, b);

        // Write the result to output
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "))
            + "\n"
        );

        // Close the resources
        bufferedReader.close();
        bufferedWriter.close();
    }
}
