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
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
        // Initialize the gemstone set with minerals from the first rock
        Set<Character> gemstoneSet = new HashSet<>();
        for (char c : arr.get(0).toCharArray()) {
            gemstoneSet.add(c);
        }
        
        // For each subsequent rock, find the intersection of minerals with gemstoneSet
        for (int i = 1; i < arr.size(); i++) {
            Set<Character> currentRockSet = new HashSet<>();
            for (char c : arr.get(i).toCharArray()) {
                currentRockSet.add(c);
            }
            // Retain only minerals that are in both gemstoneSet and currentRockSet
            gemstoneSet.retainAll(currentRockSet);
        }
        
        // The number of gemstones is the size of the final set
        return gemstoneSet.size();
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
