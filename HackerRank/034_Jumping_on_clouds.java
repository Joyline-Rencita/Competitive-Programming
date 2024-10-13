import java.util.Scanner;

public class CloudHoppingGame {
    
    public static int jumpingOnClouds(int[] c, int k) {
        int energy = 100; // Starting energy level
        int position = 0; // Start at cloud 0

        do {
            position = (position + k) % c.length; // Jump to the next cloud

            energy--; // Decrease energy for the jump
            if (c[position] == 1) {
                energy -= 2; // Additional energy cost for thunderhead
            }
        } while (position != 0); // Continue until back to the starting cloud

        return energy; // Return the remaining energy
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(cItems[i]);
        }

        int result = jumpingOnClouds(c, k);
        System.out.println(result);

        scanner.close();
    }
}
