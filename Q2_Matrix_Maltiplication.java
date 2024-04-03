package April_02_Assignment;

import java.util.Scanner;

public class Q2_Matrix_Maltiplication {
    public static int minCost(int[] dimensions, int i, int j) {
        if (i == j) // Base case: single matrix, no cost
            return 0;

        int minCost = Integer.MAX_VALUE;

        // Try all possible splits
        for (int k = i; k < j; k++) {
            int cost = minCost(dimensions, i, k) +
                    minCost(dimensions, k + 1, j) +
                    dimensions[i] * dimensions[k + 1] * dimensions[j + 1];

            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the number of matrices for test case " + (i + 1) + ": ");
            int n = scanner.nextInt(); // Number of matrices for the current test case
            int[] dimensions = new int[n + 1]; // Array to store dimensions of matrices

            System.out.println("Enter the dimensions of the matrices:");
            for (int j = 0; j <= n; j++) {
                dimensions[j] = scanner.nextInt(); // Input dimensions of matrices
            }

            System.out.println("Minimum cost to multiply matrices for test case " + (i + 1) + ": " +
                    minCost(dimensions, 0, n - 1));
        }

        scanner.close(); // Close the scanner
    }
}
