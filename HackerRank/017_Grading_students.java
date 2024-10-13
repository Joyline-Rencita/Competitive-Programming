import java.io.*;
import java.util.*;
import java.util.stream.Collectors; // Import Collectors for toList and joining
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalGrades = new ArrayList<>();
        
        for (int grade : grades) {
            // If the grade is less than 38, it doesn't change
            if (grade < 38) {
                finalGrades.add(grade);
            } else {
                // Calculate the next multiple of 5
                int nextMultipleOf5 = ((grade / 5) + 1) * 5;
                // If the difference is less than 3, round up
                if (nextMultipleOf5 - grade < 3) {
                    finalGrades.add(nextMultipleOf5);
                } else {
                    finalGrades.add(grade);
                }
            }
        }
        
        return finalGrades;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());  // Collect the integers into a List

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"))  // Join the results with newlines
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
