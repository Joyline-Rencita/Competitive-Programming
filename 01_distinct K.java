Problem Statement : 
You wish to help Ashish, who possesses a collection of N strings, some of which may be duplicated, and has been assigned the task of finding the kth unique string.If the number of unique strings is less than k, 
he needs to display an empty string. Considering you are Ashish's best friend can you assist him with this challenge?

Input Format
The first line contains an integer N denoting the number of strings. The next N lines contain strings. The next line contains an integer k.

Output Format
The output contains the kth distinct string. If there are less than k unique string display an empty string.

Constraints
1<=N<=105
-10^8<=arr[i].length()<=10^8
Sample Testcase 0
Testcase Input
6
d
b
c
b
c
a
2
Testcase Output
a


SOLUTION : 

import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        // Read the number of strings
        int N = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        // Read the strings
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            strings.add(scanner.nextLine());
        }

        // Read the value of k
        int k = scanner.nextInt();

        // Find the k-th unique string
        String kthUniqueString = findKthUniqueString(strings, k);

        // Print the result
        System.out.println(kthUniqueString);
    }

    private static String findKthUniqueString(List<String> strings, int k) {
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();

        // Count the frequency of each string
        for (String s : strings) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        // Collect unique strings
        List<String> uniqueStrings = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueStrings.add(entry.getKey());
            }
        }

        // Return the k-th unique string or an empty string if there are fewer than k unique strings
        if (k <= uniqueStrings.size()) {
            return uniqueStrings.get(k - 1);
        } 
        else {
            return "";
        }
    }
}
