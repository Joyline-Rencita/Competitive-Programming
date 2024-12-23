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
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();

        // Array to store the total number of balls in each container (row sums)
        int[] containerSum = new int[n];
        
        // Array to store the total number of each ball type across all containers (column sums)
        int[] ballTypeSum = new int[n];
        
        // Calculate row sums (total balls per container) and column sums (total balls per type)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                containerSum[i] += container.get(i).get(j);
                ballTypeSum[j] += container.get(i).get(j);
            }
        }
        
        // Sort both arrays
        Arrays.sort(containerSum);
        Arrays.sort(ballTypeSum);
        
        // If the sorted arrays are the same, it's possible to organize the containers
        if (Arrays.equals(containerSum, ballTypeSum)) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
