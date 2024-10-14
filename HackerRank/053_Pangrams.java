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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        // Create a set to store unique letters
        HashSet<Character> letters = new HashSet<>();
        
        // Normalize the string to lowercase
        s = s.toLowerCase();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Check if the character is a letter
            if (c >= 'a' && c <= 'z') {
                letters.add(c); // Add it to the set
            }
        }

        // Check if the set contains all 26 letters
        if (letters.size() == 26) {
            return "pangram"; // It is a pangram
        } else {
            return "not pangram"; // It is not a pangram
        }
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
