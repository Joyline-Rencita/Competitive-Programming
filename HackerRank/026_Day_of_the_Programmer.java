import java.io.*;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */
     
    public static String dayOfProgrammer(int year) {
        if (year < 1918) {
            // Julian calendar
            if (year % 4 == 0) {
                // Leap year
                return String.format("12.09.%d", year);
            } else {
                // Not a leap year
                return String.format("13.09.%d", year);
            }
        } else if (year == 1918) {
            // Transition year
            return "26.09.1918";
        } else {
            // Gregorian calendar
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                // Leap year
                return String.format("12.09.%d", year);
            } else {
                // Not a leap year
                return String.format("13.09.%d", year);
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
