import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // The last element to be inserted
        int valueToInsert = arr.get(n - 1);
        // Start from the second last element
        int i = n - 2;

        // Shift elements that are greater than valueToInsert
        while (i >= 0 && arr.get(i) > valueToInsert) {
            arr.set(i + 1, arr.get(i)); // Shift element to the right
            printArray(arr); // Print the current state of the array
            i--;
        }
        // Insert the value in its correct position
        arr.set(i + 1, valueToInsert);
        printArray(arr); // Print the final state of the array
    }

    // Helper method to print the array
    private static void printArray(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
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

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
