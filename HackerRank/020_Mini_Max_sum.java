import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        // Calculate the total sum of the array elements
        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // Find the minimum and maximum element in the array
        int minElement = Collections.min(arr);
        int maxElement = Collections.max(arr);
        
        // The minimum sum is the total sum excluding the largest element
        long minSum = totalSum - maxElement;
        
        // The maximum sum is the total sum excluding the smallest element
        long maxSum = totalSum - minElement;
        
        // Print the result as space-separated integers
        System.out.println(minSum + " " + maxSum);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
