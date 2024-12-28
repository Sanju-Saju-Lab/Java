import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        // Creating a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Asking the user for the number of elements they want to sort
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Creating an array to store the elements
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        // Reading the elements from the user and storing them in the array
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calling the bubbleSort function to sort the array
        bubbleSort(arr);

        // Displaying the sorted array to the user
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // This function sorts the array using the Bubble Sort algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped; // A flag to check if any elements were swapped during a pass
        // Outer loop: repeats passes to move elements to their correct positions
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Resetting the flag for each pass
            // Inner loop: compares adjacent elements and swaps them if they are in the wrong order
            for (int j = 0; j < n - 1 - i; j++) {
                // If the current element is greater than the next, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Marking that a swap has occurred
                }
            }
            // If no swaps were made, the array is already sorted, so exit the loop early
            if (!swapped) {
                break;
            }
        }
    }
}
