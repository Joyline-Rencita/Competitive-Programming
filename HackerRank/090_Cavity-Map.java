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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        int n = grid.size(); // Number of rows (and columns, since it's square)
        List<StringBuilder> modifiedGrid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            modifiedGrid.add(new StringBuilder(grid.get(i))); // Create a mutable string for each row
        }

        // Check for cavities in the grid
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                char current = grid.get(i).charAt(j);
                // Check adjacent cells
                if (current > grid.get(i - 1).charAt(j) && // Up
                    current > grid.get(i + 1).charAt(j) && // Down
                    current > grid.get(i).charAt(j - 1) && // Left
                    current > grid.get(i).charAt(j + 1)) { // Right
                    modifiedGrid.get(i).setCharAt(j, 'X'); // Mark as cavity
                }
            }
        }

        // Convert StringBuilder back to String and return the result
        return modifiedGrid.stream()
                           .map(StringBuilder::toString)
                           .collect(Collectors.toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
