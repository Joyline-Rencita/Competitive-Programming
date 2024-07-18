Problem Statement
In a lively car showroom, an array of cars awaits, each with its distinctive features. Picture yourself mixing and matching these cars in unique combinations to create dream blends which has a fscore equal to the
XOR value of the combination. Your mission: compute the blend score, which is the XOR of the fscore values for all these dreamy combinations.  Now, it's time to reveal the grand total!

Input Format
The first line of input consists of the integer n – representing the number of cars in the showroom.

The second line consists of n integers - representing the features of the car. 

Output Format
Print the sum of fscore obtained.

Constraints
1 <= n<= 10^4
0 <= fi <= 10^4.

Sample Testcase 0
Testcase Input
5
4 3 5 1 2
Testcase Output
3
Explanation
The xor of all the combinations possible is:

4 ^ (4^3) ^ (4^3^5) ^ (4^3^5^1) ^ (4^3^5^1^2) ^ (3) ^ (3^5) ^ (3^5^1) ^ (3^5^1^2) ^ (5) ^ (5^1) ^ (5^1^2) ^ (1) ^ (1^2) ^ 2 = 3

Sample Testcase 1
Testcase Input
4
1 4 5 2
Testcase Output
0
Explanation
The xor of all the combinations possible is:
1 ^ (1^4) ^ (1^4^5) ^ (1^4^5^2) ^ (4) ^ (4^5) ^ (4^5^2) ^ (5) ^ (5^2) ^ 2 = 0

SOLUTION : 

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] features = new int[n];
        
        for (int i = 0; i < n; i++) {
            features[i] = scanner.nextInt();
        }
        int result = 0;        // Initialize result to 0

        // Iterate over all 32 bits positions (because given constraints are up to 10^4 which is within 32-bit range)
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            
            // Count how many numbers have the current bit set
            for (int i = 0; i < n; i++) {
                if ((features[i] & (1 << bit)) != 0) {
                    count++;
                }
            }
            // If the count of numbers with the current bit set is odd,
            // it means the final combination will have this bit set
            if (count % 2 != 0) {
                result |= (1 << bit);
            }
        }
        System.out.println(result);
    }
}