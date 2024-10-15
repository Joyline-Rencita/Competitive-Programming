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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        int n = topic.size();
        int m = topic.get(0).length();
        int maxTopics = 0;
        int maxTeams = 0;
        
        // Iterate through all pairs of attendees
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Perform bitwise OR for the two attendees' topics
                int knownTopics = 0;
                for (int k = 0; k < m; k++) {
                    if (topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1') {
                        knownTopics++;
                    }
                }
                // Check if this team knows more topics than the current max
                if (knownTopics > maxTopics) {
                    maxTopics = knownTopics;
                    maxTeams = 1;
                } else if (knownTopics == maxTopics) {
                    maxTeams++;
                }
            }
        }
        
        // Return the result as a list of two elements
        return Arrays.asList(maxTopics, maxTeams);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
