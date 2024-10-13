import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Calculate the total cost of shared items
        int totalCost = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) { // Skip the item that Anna didn't eat
                totalCost += bill.get(i);
            }
        }

        // Calculate Anna's share
        int annaShare = totalCost / 2;

        // Determine if Brian charged Anna correctly
        if (annaShare == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - annaShare); // This will be the amount he owes her
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList()); // Ensure Collectors is imported

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        Result.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
