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
     * Complete the 'toys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY w as parameter.
     */

    public static int toys(List<Integer> w) {
        // Sort the weights
        Collections.sort(w);
        
        int containers = 0; // To count the number of containers
        int i = 0; // Index to iterate through the weights
        
        while (i < w.size()) {
            // Start a new container with the current item as the minimum
            int minWeight = w.get(i);
            int maxWeightLimit = minWeight + 4; // The maximum weight that can be included in this container
            
            // Move to the next item until we find an item that exceeds the limit
            while (i < w.size() && w.get(i) <= maxWeightLimit) {
                i++; // Include this item in the current container
            }
            
            containers++; // We have filled one container
        }
        
        return containers; // Return the total number of containers
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> w = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.toys(w);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
