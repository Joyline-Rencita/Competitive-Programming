import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Step 1: Sort the array
        Collections.sort(arr);
        
        int minDiff = Integer.MAX_VALUE; // Initialize the minimum difference to a large value
        List<Integer> closestPairs = new ArrayList<>(); // List to store the pairs with the minimum difference
        
        // Step 2: Find the minimum difference between consecutive elements
        for (int i = 1; i < arr.size(); i++) {
            int diff = arr.get(i) - arr.get(i - 1);
            // If we find a new minimum difference
            if (diff < minDiff) {
                minDiff = diff;
                closestPairs.clear(); // Clear the list since we found a new min diff
                closestPairs.add(arr.get(i - 1)); // Add the first number of the pair
                closestPairs.add(arr.get(i)); // Add the second number of the pair
            } else if (diff == minDiff) {
                // If we find another pair with the same minimum difference, add it to the list
                closestPairs.add(arr.get(i - 1));
                closestPairs.add(arr.get(i));
            }
        }
        
        return closestPairs; // Return the list of pairs
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
