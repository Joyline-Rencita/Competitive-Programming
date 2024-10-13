import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Calculate the LCM of the first array
        int lcmA = lcm(a);
        
        // Calculate the GCD of the second array
        int gcdB = gcd(b);
        
        // Count the multiples of lcmA that are less than or equal to gcdB
        int count = 0;
        for (int i = lcmA; i <= gcdB; i += lcmA) {
            if (gcdB % i == 0) {
                count++;
            }
        }
        
        return count;
    }

    // Function to compute the GCD of an array
    private static int gcd(List<Integer> b) {
        int gcdResult = b.get(0);
        for (int i = 1; i < b.size(); i++) {
            gcdResult = gcd(gcdResult, b.get(i));
        }
        return gcdResult;
    }

    // Function to compute the LCM of an array
    private static int lcm(List<Integer> a) {
        int lcmResult = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            lcmResult = lcm(lcmResult, a.get(i));
        }
        return lcmResult;
    }

    // Helper function to compute the GCD of two numbers
    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    // Helper function to compute the LCM of two numbers
    private static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int total = Result.getTotalX(arr, brr);
        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
