import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    
    public static void staircase(int n) {
        // Loop over each row from 1 to n
        for (int i = 1; i <= n; i++) {
            // Print (n - i) spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print i '#' symbols
            for (int k = 1; k <= i; k++) {
                System.out.print("#");
            }
            // Move to the next line
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
