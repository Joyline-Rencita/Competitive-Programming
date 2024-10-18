import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'largestPermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        int n = arr.size();
        // Create a map to store the index of each value for quick access
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            indexMap.put(arr.get(i), i);
        }
        
        for (int i = 0; i < n && k > 0; i++) {
            // The value that should be at index i for the largest permutation
            int expectedValue = n - i;
            // If the current value is not the expected largest value
            if (arr.get(i) != expectedValue) {
                // Get the index of the expected value
                int expectedValueIndex = indexMap.get(expectedValue);
                
                // Swap the values
                int temp = arr.get(i);
                arr.set(i, expectedValue);
                arr.set(expectedValueIndex, temp);
                
                // Update the indices in the map
                indexMap.put(temp, expectedValueIndex);
                indexMap.put(expectedValue, i);
                
                // Decrease the number of allowed swaps
                k--;
            }
        }
        
        return arr;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.largestPermutation(k, arr);

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
