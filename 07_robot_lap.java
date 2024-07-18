Problem Statement
In a magical land, there is a young explorer named Raju who embarks on a thrilling adventure with his enchanted vehicle. This magical vehicle can only move in four directions: right (R), left (L), up (U), and 
down (D). Raju starts his journey at the heart of the mystical forest, located at coordinates (0, 0). As Raju follows a sequence of mysterious symbols etched on ancient stones, he maneuvers his magical vehicle 
accordingly. 'R' guides him to the right, 'L' to the left, 'U' upwards, and 'D' downwards. The direction he faces does not matter; the symbols' magic ensures his vehicle moves in the intended direction. Your 
mission is to help Raju determine whether he will return to the enchanted forest's center (0,0) after completing all his moves. If he successfully navigates back to the starting point, the forest's magic 
will protect him, and he will be able to continue his adventure. If not, he might be lost in the mystical realm forever. Can you assist Raju in deciphering his fate? If he ends up back at the starting point, 
please say YES; otherwise, say NO.

Input Format
The first line of the input contains an integer n  — the size of string moves
The second line contains the string moves
Output Format
Raju needs to print ”YES” if car returns to origin, else “NO”.

Constraints
1 <= moves.length <= 2 * 104
moves only contains the characters 'U', 'D', 'L' and 'R'.
Sample Testcase 0
Testcase Input
6
UUDDLR
Testcase Output
YES
Explanation
The robot moves:
From (0,0) to (1,0)
From (1,0) to (2,0)
From (2,0) to (1,0)
From (1,0) to (0,0)
From (0,0) to (-1,0)
From (-1,0) to (0,0)
After these moves, the robot ends up back at the origin (0, 0).

Sample Testcase 1
Testcase Input
5
UDLRL
Testcase Output
NO
Explanation
In this scenario, the robot moves:
From (0,0) to (1,0)
From (1,0) to (0,0)
From (0,0) to (-1,0)
From (-1,0) to (0,0)
From (0,0) to (-1,0)
After these moves, the robot does not return to the origin (0, 0). Therefore, the output is false.

SOLUTION : 

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the moves string
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        String moves = scanner.nextLine();   // Read the moves string
        int x = 0;        // Initialize coordinates
        int y = 0;
        // Process each move
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y -= 1;
                    break;
                case 'L':
                    x -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
            }
        } 
        // Check if Raju returns to the origin
        if (x == 0 && y == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}
