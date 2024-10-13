import java.io.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        int altitude = 0; // Starting at sea level
        int valleys = 0;
        boolean inValley = false;
        
        // Traverse through the path
        for (char step : path.toCharArray()) {
            // Step up
            if (step == 'U') {
                altitude++;
            }
            // Step down
            else if (step == 'D') {
                altitude--;
            }
            
            // Check if we are currently in a valley
            if (altitude < 0 && !inValley) {
                // We've just entered a valley
                inValley = true;
            }
            // Check if we have just exited a valley
            else if (altitude == 0 && inValley) {
                valleys++;
                inValley = false; // Reset valley state after exiting
            }
        }
        
        return valleys;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());
        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        System.out.println(result);

        bufferedReader.close();
    }
}
