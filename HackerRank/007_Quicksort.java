import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    
    public static List<Integer> quickSort(List<Integer> arr) {
        // Initialize lists to hold less than, equal to, and greater than pivot
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        // The pivot is the first element of the array
        int pivot = arr.get(0);
        
        // Iterate over the array and partition it based on the pivot
        for (int num : arr) {
            if (num < pivot) {
                left.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                right.add(num);
            }
        }
        
        // Combine the three lists: left, equal, and right
        List<Integer> result = new ArrayList<>();
        result.addAll(left);
        result.addAll(equal);
        result.addAll(right);
        
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read input size (not needed for logic but given in problem format)
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // Read the array
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        // Get the partitioned array using quickSort
        List<Integer> result = Result.quickSort(arr);

        // Write the result as a space-separated string
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
