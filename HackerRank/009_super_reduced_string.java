import java.io.*;
import java.util.*;

class Result {
    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String superReducedString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // If the stack is not empty and the top of the stack is the same as the current character
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // Remove the last character
            } else {
                stack.push(ch); // Add the current character to the stack
            }
        }

        // Construct the result from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Since we've constructed the string in reverse order, reverse it back
        result.reverse();

        // Return the result or "Empty String"
        return result.length() == 0 ? "Empty String" : result.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
