Problem Statement
You are a shopkeeper and bought n pairs of socks of several colours in bulk. The colour of each pair of socks is represented as a non-negative integer. The socks are sold as sets of 3 each. A set of socks consists
of 3 socks of the same colour. You want to find the number of different sets that can be made from the n pairs of socks you bought today. Note: order of indices of sock pairs in the set does not matter.

Input Format
The first line of the input contains a single integer n - the number of pairs of socks that you have. The second line of the input contains n space-separated integers a1, a2, …, an, where ai represents the colour of the ith pair.

Output Format
Print a single integer - the number of different sets of 3 socks each that can be made from the n pairs of socks.

Constraints
1 <= n <= 105

0 <= ai<= 1000

Sample Testcase 0
Testcase Input
6
1 3 3 1 1 3
Testcase Output
2
Explanation
We can form two sets of 3 pairs of:
1) 1 Set containing 1.
2) 1 set containing 3.

Sample Testcase 1
Testcase Input
7
1 3 3 1 1 3 3
Testcase Output
5
Explanation
We can form two sets of 3 pairs of:
1) 1 Set containing 1.
2) 4 possible set containing socks having color 3:

2nd, 3rd and 6th sock
2nd, 3rd and 7th sock
2nd, 6th and 7th sock
3rd, 6th and 7th sock

Solution:

