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
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

        public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Sort the sticks in non-decreasing order
        Collections.sort(sticks);
        int n = sticks.size();
        
        // Variable to keep track of the maximum perimeter
        List<Integer> bestTriangle = new ArrayList<>();
        
        // Iterate from the end of the sorted list to find the best triangle
        for (int i = n - 1; i >= 2; i--) {
            int a = sticks.get(i - 2);
            int b = sticks.get(i - 1);
            int c = sticks.get(i);
            
            // Check if these three can form a non-degenerate triangle
            if (a + b > c) {
                // If valid, store it as the best triangle
                bestTriangle.add(a);
                bestTriangle.add(b);
                bestTriangle.add(c);
                break; // We found the maximum perimeter triangle
            }
        }
        
        // Return the best triangle found or [-1] if none exists
        return bestTriangle.isEmpty() ? Collections.singletonList(-1) : bestTriangle;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
