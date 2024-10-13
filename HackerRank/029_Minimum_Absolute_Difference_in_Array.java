import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList; // Importing toList()

class Result {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Sort the array
        Collections.sort(arr);
        
        int minDifference = Integer.MAX_VALUE; // Initialize to a large value
        
        // Calculate differences between consecutive elements
        for (int i = 0; i < arr.size() - 1; i++) {
            int difference = Math.abs(arr.get(i) - arr.get(i + 1));
            minDifference = Math.min(minDifference, difference); // Update minimum difference
        }
        
        return minDifference; // Return the minimum absolute difference
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
