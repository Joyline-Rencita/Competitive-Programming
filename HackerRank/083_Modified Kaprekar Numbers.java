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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        boolean found = false;
        
        for (int n = p; n <= q; n++) {
            long square = (long) n * n; // square the number
            String strSquare = String.valueOf(square); // convert the square to a string
            int d = String.valueOf(n).length(); // number of digits in the original number
            
            // Split the square into two parts
            String rightPart = strSquare.substring(Math.max(0, strSquare.length() - d)); // right part
            String leftPart = strSquare.substring(0, Math.max(0, strSquare.length() - d)); // left part
            
            // Convert the parts to integers (default to 0 if left part is empty)
            int leftNum = (leftPart.isEmpty()) ? 0 : Integer.parseInt(leftPart);
            int rightNum = (rightPart.isEmpty()) ? 0 : Integer.parseInt(rightPart);
            
            // Check if the sum of the parts equals the original number
            if (leftNum + rightNum == n) {
                found = true;
                System.out.print(n + " ");
            }
        }
        
        if (!found) {
            System.out.println("INVALID RANGE");
        } else {
            System.out.println(); // Move to the next line after printing all Kaprekar numbers
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
