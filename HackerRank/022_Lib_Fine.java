import java.io.*;

class Result {

    /*
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d1 - day returned
     *  2. INTEGER m1 - month returned
     *  3. INTEGER y1 - year returned
     *  4. INTEGER d2 - day due
     *  5. INTEGER m2 - month due
     *  6. INTEGER y2 - year due
     */
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // If the return year is later than the due year, fine is 10000
        if (y1 > y2) {
            return 10000;
        }
        // If the return year is the same but the month is later, fine is 500 per month late
        if (y1 == y2 && m1 > m2) {
            return 500 * (m1 - m2);
        }
        // If the return year and month are the same, but the day is later, fine is 15 per day late
        if (y1 == y2 && m1 == m2 && d1 > d2) {
            return 15 * (d1 - d2);
        }
        // If returned on or before the due date, no fine
        return 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int d1 = Integer.parseInt(firstMultipleInput[0]);
        int m1 = Integer.parseInt(firstMultipleInput[1]);
        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int d2 = Integer.parseInt(secondMultipleInput[0]);
        int m2 = Integer.parseInt(secondMultipleInput[1]);
        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
