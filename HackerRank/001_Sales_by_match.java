import java.util.*;

public class Solution {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. List<Integer> ar
     */
    
    public static int sockMerchant(int n, List<Integer> ar) {
        // Map to store the count of each sock color
        Map<Integer, Integer> colorsCount = new HashMap<>();
        
        // Count occurrences of each color
        for (int i = 0; i < ar.size(); i++) {
            int color = ar.get(i);
            colorsCount.put(color, colorsCount.getOrDefault(color, 0) + 1);
        }
        
        // Calculate the number of pairs
        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : colorsCount.entrySet()) {
            pairs += entry.getValue() / 2;
        }
        
        return pairs;
    }

    // Main method to handle input/output
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> ar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ar.add(scanner.nextInt());
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
        scanner.close();
    }
}
