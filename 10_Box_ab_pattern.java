Problem Statement : 
Imagine you have a row of boxes. Each box can be either an "a" or a "b". To check if it's an ab pattern, you need to make sure that all the "a" boxes, if they exist, come before any "b" boxes, if they exist.
If this order is maintained, it's an ab pattern; otherwise, it's not. Display "YES" if it is maintained else "NO". 
Input Format
The first line contains a string s, deonting the row of boxes. 

Output Format
If the boxes are in ab pattern print "YES" else "NO". 

Constraints
1<= s.length <=106

Sample Testcase 0
Testcase Input
aaaaab
Testcase Output
YES
Explanation
In the given sequence of boxes:


All the boxes with 'a's are occuring before boxes with 'b's. 

So we print "YES".

Sample Testcase 1
Testcase Input
aaba
Testcase Output
NO
Explanation
In the given sequence of boxes:
The boxes with 'a' at index 3 is occuring after the box with 'b' so it doesn't follow the ab pattern.
So we print "NO".

SOLUTION :

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        boolean foundB = false;
        boolean isAbPattern = true;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                foundB = true;
            } else if (c == 'a' && foundB) {
                isAbPattern = false;
                break;
            }
        }

        if (isAbPattern) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
