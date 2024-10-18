import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'runningTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int runningTime(List<Integer> arr) {
        int shifts = 0;  // Initialize shift counter
        int n = arr.size();

        // Perform Insertion Sort
        for (int i = 1; i < n; i++) {
            int value = arr.get(i);
            int j = i - 1;

            // Shift elements that are greater than value to the right
            while (j >= 0 && arr.get(j) > value) {
                arr.set(j + 1, arr.get(j));  // Shift to the right
                shifts++;  // Increment shift count
                j--;
            }
            arr.set(j + 1, value);  // Insert the value in the correct position
        }

        return shifts;  // Return the total number of shifts
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

        int result = Result.runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
