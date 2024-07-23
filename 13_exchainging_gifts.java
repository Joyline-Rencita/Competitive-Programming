Problem Statement : 
Each Christmas, the members of the royal family exchange gifts with each other. The family has n members numbered from 1 to n. However, not everyone in the family gives and receives the same number of gifts.
The youngest member receives a gift from everyone else in the family except himself but does not give any gifts to anyone else. This Christmas, there were a total of m gifts that were exchanged among the family 
members. You are provided with the data for all m gifts. Find the number that represents the youngest family member using the given data.

Input Format
The first line of the input contains two integers n and m – the number of family members and the number of gifts that were exchanged. The next m lines contain two integers each. In the ith line, two integers ai, 
bi represent that a gift was given by ai to bi.
Note: any ordered pair (ai, bi) will not occur more than once, i.e., a family member does not give more than one gift to the same member.
Output Format
Print a single integer, the number that represents the youngest member of the family.
If no such member is found, print “-1” instead.
Constraints
1 <= n <= 104
0 <= m <= 105
1 <= ai, bi, <= n
Sample Testcase 0
Testcase Input
2 1
1 2
Testcase Output
2
Explanation
Family member 1 gave a gift to family member 2. Now, we can see that 2 did not give any gift to anyone but received a gift from all other members (member 1). Hence, 2 is the youngest member.
Sample Testcase 1
Testcase Input
3 2
1 3
2 3
Testcase Output
3
Explanation
We can see that 3 received gifts from 1 and 2 but did not give any gifts to anyone. Therefore, 3 must be the youngest member.

SOLUTION:

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of family members and the number of gift exchanges
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        // Arrays to track gifts given and received
        int[] giftsGiven = new int[n + 1];
        int[] giftsReceived = new int[n + 1];
        
        // Read gift exchanges
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            giftsGiven[a]++;
            giftsReceived[b]++;
        }
        
        scanner.close();
        
        // Find the youngest member
        int youngest = -1;
        for (int i = 1; i <= n; i++) {
            if (giftsGiven[i] == 0 && giftsReceived[i] == n - 1) {
                youngest = i;
                break;
            }
        }
        
        // Output the result
        System.out.println(youngest);
    }
}
