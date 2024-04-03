package April_02_Assignment;

import java.util.Scanner;

public class Q1_Max_Profit {
    public static int maxProfit(int[] prices) {
        int n = prices.length; // Get the number of days
        if (n <= 1)
            return 0; // If there is only one day or less, return 0 as no transaction can be made

        // Initialize variables to store maximum profit after two transactions
        int[] forward = new int[n]; // Array to store maximum profit from one transaction before day i
        int[] backward = new int[n]; // Array to store maximum profit from one transaction after day i

        // Calculate maximum profit in forward direction
        int minPrice = prices[0]; // Initialize the minimum price seen so far to the price of the first day
        forward[0] = 0; // Initialize the maximum profit to 0 for the first day
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]); // Update the minimum price seen so far
            forward[i] = Math.max(forward[i - 1], prices[i] - minPrice); // Calculate the maximum profit up to day i
        }

        // Calculate maximum profit in backward direction
        int maxPrice = prices[n - 1]; // Initialize the maximum price seen so far to the price of the last day
        backward[n - 1] = 0; // Initialize the maximum profit to 0 for the last day
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]); // Update the maximum price seen so far
            backward[i] = Math.max(backward[i + 1], maxPrice - prices[i]); // Calculate the maximum profit starting from day i
        }

        // Calculate maximum combined profit from two transactions
        int maxProfit = 0; // Initialize the maximum combined profit to 0
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, forward[i] + backward[i]); // Calculate the maximum combined profit for each day
        }

        return maxProfit; // Return the maximum combined profit
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt(); // Get the number of days from the user
        int[] prices = new int[n]; // Initialize an array to store the stock prices
        System.out.println("Enter the stock prices for each day:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt(); // Get the stock prices for each day from the user
        }
        System.out.println("Maximum profit: " + maxProfit(prices)); // Print the maximum profit
        scanner.close(); // Close the scanner
    }
}
