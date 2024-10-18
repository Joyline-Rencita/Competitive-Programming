import java.io.*;
import java.util.*;

public class Solution {

    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;

            // Change j > 0 to j >= 0 to include the 0th index
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        // Print the array only once, after sorting is complete
        printArray(A);
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println(); // Add a newline after printing
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        insertionSort(ar);
    }
}
