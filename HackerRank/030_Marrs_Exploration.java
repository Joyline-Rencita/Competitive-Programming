import java.io.*;

class Result {
    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int marsExploration(String s) {
        String originalMessage = "SOS"; // The original message
        int changedCount = 0; // Counter for changed characters

        // Loop through the received message
        for (int i = 0; i < s.length(); i++) {
            // Determine what the expected character is
            char expectedChar = originalMessage.charAt(i % 3);
            // If the character differs from the expected, increment the counter
            if (s.charAt(i) != expectedChar) {
                changedCount++;
            }
        }
        
        return changedCount; // Return the count of altered characters
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine(); // Read the input signal

        int result = Result.marsExploration(s); // Call the function

        bufferedWriter.write(String.valueOf(result)); // Write the result
        bufferedWriter.newLine();

        bufferedReader.close(); // Close the buffered reader
        bufferedWriter.close(); // Close the buffered writer
    }
}
