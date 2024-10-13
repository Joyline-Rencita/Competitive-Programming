import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Extract the period (AM/PM)
        String period = s.substring(s.length() - 2);
        // Extract the hour, minute, and second parts
        String time = s.substring(0, s.length() - 2);
        String[] timeParts = time.split(":");

        int hour = Integer.parseInt(timeParts[0]);
        String minutes = timeParts[1];
        String seconds = timeParts[2];

        // Convert the hour to 24-hour format based on AM/PM
        if (period.equals("AM")) {
            // If hour is 12 AM, convert it to 00
            if (hour == 12) {
                hour = 0;
            }
        } else if (period.equals("PM")) {
            // If hour is 12 PM, it remains 12, otherwise add 12
            if (hour != 12) {
                hour += 12;
            }
        }

        // Format the hour with leading zeros if necessary and return the result
        return String.format("%02d:%s:%s", hour, minutes, seconds);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
