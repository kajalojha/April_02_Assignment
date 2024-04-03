package April_02_Assignment;

import java.util.Scanner;

public class Q3_Unique_PathIn_Maze {
    static final int MOD = 1000000007;

    public static int uniquePaths(int[][] maze, int rows, int cols) {
        // Create a 2D array to store the number of unique paths to reach each cell
        int[][] dp = new int[rows][cols];

        // Initialize the top-left cell with 1 since there's only one way to reach it
        dp[0][0] = 1;

        // Fill the first row: if a cell has obstacle or blockage, then stop considering the cells
        for (int j = 1; j < cols; j++) {
            if (maze[0][j] == -1)
                break;
            dp[0][j] = dp[0][j - 1];
        }

        // Fill the first column: if a cell has obstacle or blockage, then stop considering the cells
        for (int i = 1; i < rows; i++) {
            if (maze[i][0] == -1)
                break;
            dp[i][0] = dp[i - 1][0];
        }

        // Fill the remaining cells based on the possible paths from top and left cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (maze[i][j] != -1) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        // Return the number of unique paths to reach the bottom-right cell
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the number of rows for test case " + (i + 1) + ": ");
            int rows = scanner.nextInt(); // Number of rows
            System.out.print("Enter the number of columns for test case " + (i + 1) + ": ");
            int cols = scanner.nextInt(); // Number of columns

            int[][] maze = new int[rows][cols]; // Array to store the maze

            System.out.println("Enter the maze elements for test case " + (i + 1) + ":");
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    maze[j][k] = scanner.nextInt(); // Input maze elements
                }
            }

            System.out.println("Number of unique paths for test case " + (i + 1) + ": " + uniquePaths(maze, rows, cols));
        }

        scanner.close(); // Close the scanner
    }
}
