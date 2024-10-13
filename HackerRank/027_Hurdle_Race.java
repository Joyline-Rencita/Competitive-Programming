import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList; // Importing toList()

class Result {
    
    /*
     * Complete the 'hurdleRace' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY height
     */
    
    public static int hurdleRace(int k, List<Integer> height) {
        // Find the maximum height of the hurdles
        int maxHurdleHeight = Collections.max(height);
        
        // Calculate the number of doses needed
        int dosesNeeded = maxHurdleHeight - k;
        
        // If the character can already jump all hurdles, return 0
        return Math.max(0, dosesNeeded);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> height = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList()); // Correct usage of toList()

        int result = Result.hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
