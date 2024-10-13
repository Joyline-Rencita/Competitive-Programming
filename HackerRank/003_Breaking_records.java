import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */
    
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int minRecord = scores.get(0);  // The minimum record (least points)
        int maxRecord = scores.get(0);  // The maximum record (most points)
        int minBreaks = 0;              // Count of times the minimum record was broken
        int maxBreaks = 0;              // Count of times the maximum record was broken

        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            
            if (score > maxRecord) {
                maxRecord = score;      // Update the maximum record
                maxBreaks++;            // Increment the number of times the max record was broken
            }
            if (score < minRecord) {
                minRecord = score;      // Update the minimum record
                minBreaks++;            // Increment the number of times the min record was broken
            }
        }

        return Arrays.asList(maxBreaks, minBreaks);  // Return the counts as a list
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read the number of games
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // Read the scores for each game
        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        // Call the breakingRecords function
        List<Integer> result = Result.breakingRecords(scores);

        // Write the result to output
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
