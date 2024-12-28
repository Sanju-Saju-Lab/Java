import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the number of elements in the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an array to store the elements
        int[] arr = new int[n];

        // Prompt the user to enter the elements for the array
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();  // Store each entered element in the array
        }

        // Call the selectionSort method to sort the array
        selectionSort(arr);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");  // Print each element in the sorted array
        }

        // Close the scanner object to prevent resource leaks
        scanner.close();
    }

    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;  // Get the length of the array

        // Loop through the array to sort it
        for (int i = 0; i < n - 1; i++) {
            // Assume the first element is the smallest
            int minIndex = i;

            // Loop through the unsorted
