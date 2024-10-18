import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

   public static int maximumToys(List<Integer> prices, int k) {
        // Step 1: Sort the prices in ascending order
        Collections.sort(prices);
        
        int count = 0; // To count the number of toys bought
        // Step 2: Iterate through sorted prices
        for (int price : prices) {
            // Step 3: Check if the current price can be afforded
            if (price <= k) {
                count++; // Increment the count of toys
                k -= price; // Decrease the budget
            } else {
                break; // Exit loop if the budget is exceeded
            }
        }
        
        // Step 4: Return the total number of toys bought
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] pricesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesTemp[i]);
            prices.add(pricesItem);
        }

        int result = Result.maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
