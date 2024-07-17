Problem Statement
You are given a series of queries of the form (a, b), where:
a represents the count of the number b.
For example, the query (3, 5) means the number 5 appears 3 times.

Your task is to compute the absolute difference between the numbers which has the highest and lowest frequencies (least number of times must be atleast once).
If there are multiple possible answers, you should return the maximum possible absolute difference.

Input Format
First line contains a single integer denoting the number of queries.
Second line onwards: two space separated integers denoting the queries
Output Format
Output the maximum possible absolute difference between the numbers which has the highest and lowest frequencies. If there are only two numbers with the same occurrence, the output should be 0.

Constraints
1<=q<=100000.
1<=a,b<=100000.
Sample Testcase 0
Testcase Input
1
2 1
Testcase Output
0
Explanation
As there is only one pair availabe so the difference will be 0.

Sample Testcase 1
Testcase Input
4
1 2
1 3
2 5
4 4
Testcase Output
2
Explanation
As per the question:

2 occurs 1 time
3 occurs 1 time
5 occurs 2 times
4 occurs 4 times

Therefore the we need to get the difference between the number occuring most number of times (4) and the number ocuring least number of times(2, 3). 
As we want maximum difference the answer is: 4-2 = 2.

SOLUTION :

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of queries
        int q = scanner.nextInt();

        // Map to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Read the queries and update the frequency map
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + a);
        }

        // If there is only one unique number, the difference is 0
        if (frequencyMap.size() == 1) {
            System.out.println(0);
            return;
        }

        // Find the maximum and minimum frequency values
        int minFrequency = Integer.MAX_VALUE;
        int maxFrequency = Integer.MIN_VALUE;

        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
            if (frequency < minFrequency) {
                minFrequency = frequency;
            }
        }

        // Find all numbers with the minimum and maximum frequencies
        List<Integer> minFrequencyNumbers = new ArrayList<>();
        List<Integer> maxFrequencyNumbers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == minFrequency) {
                minFrequencyNumbers.add(entry.getKey());
            }
            if (entry.getValue() == maxFrequency) {
                maxFrequencyNumbers.add(entry.getKey());
            }
        }

        // Find the maximum absolute difference
        int maxAbsoluteDifference = 0;
        for (int minNumber : minFrequencyNumbers) {
            for (int maxNumber : maxFrequencyNumbers) {
                int absoluteDifference = Math.abs(maxNumber - minNumber);
                if (absoluteDifference > maxAbsoluteDifference) {
                    maxAbsoluteDifference = absoluteDifference;
                }
            }
        }

        // Print the result
        System.out.println(maxAbsoluteDifference);
    }
}
