import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        // Perform Insertion Sort
        for (int i = 1; i < n; i++) {
            int value = arr.get(i); // The element to be inserted
            int j = i - 1;

            // Shift elements to the right until the correct position for value is found
            while (j >= 0 && arr.get(j) > value) {
                arr.set(j + 1, arr.get(j)); // Shift right
                j--;
            }
            arr.set(j + 1, value); // Insert the value in the correct position
            
            // Print the array after each insertion, starting from the second element
            System.out.println(arrayToString(arr));
        }
    }

    // Helper method to convert List<Integer> to a space-separated string
    private static String arrayToString(List<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim(); // Remove the trailing space
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
