import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int migratoryBirds(List<Integer> arr) {
        // Create a map to count the frequency of each bird type
        Map<Integer, Integer> birdCount = new HashMap<>();

        // Count each bird type
        for (int bird : arr) {
            birdCount.put(bird, birdCount.getOrDefault(bird, 0) + 1);
        }

        int maxCount = 0;
        int birdType = Integer.MAX_VALUE;

        // Determine the most frequently sighted bird type
        for (Map.Entry<Integer, Integer> entry : birdCount.entrySet()) {
            int type = entry.getKey();
            int count = entry.getValue();

            // Check for maximum frequency and the lowest type id in case of a tie
            if (count > maxCount || (count == maxCount && type < birdType)) {
                maxCount = count;
                birdType = type;
            }
        }

        return birdType;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
