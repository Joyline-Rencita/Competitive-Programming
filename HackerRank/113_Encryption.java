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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Step 1: Remove spaces from the string
        s = s.replaceAll(" ", "");
        int L = s.length();
        
        // Step 2: Calculate number of rows and columns
        int rows = (int) Math.floor(Math.sqrt(L));
        int cols = (int) Math.ceil(Math.sqrt(L));
        
        if (rows * cols < L) {
            rows = cols;  // Adjust rows if needed
        }
        
        // Step 3: Build the grid and read column-wise
        StringBuilder encryptedMessage = new StringBuilder();
        
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < L; j += cols) {
                encryptedMessage.append(s.charAt(j));
            }
            if (i < cols - 1) {
                encryptedMessage.append(" ");
            }
        }
        
        return encryptedMessage.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
