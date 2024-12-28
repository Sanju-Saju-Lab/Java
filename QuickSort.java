import java.util.Scanner;

public class QuickSort {

    // Function to perform the Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);  // Find the pivot index (where the pivot element is positioned correctly)
            quickSort(arr, low, pi - 1);          // Recursively sort the left sub-array
            quickSort(arr, pi + 1, high);         // Recursively sort the right sub-array
        }
    }

    // Function to partition the array based on a pivot element
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choose the last element as the pivot
        int i = (low - 1);      // Index of the smaller element

        // Loop through the array to rearrange elements based on the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {  // If the current element is smaller than the pivot
                i++;                // Move the index for the smaller element
                swap(arr, i, j);     // Swap the current element with the smaller element
            }
        }

        // Place the pivot element in its correct position
        swap(arr, i + 1, high);  
        return i + 1;            // Return the index of the pivot
    }

    // Function to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];  // Store the value of arr[i] in a temporary variable
        arr[i] = arr[j];    // Place the value of arr[j] in arr[i]
        arr[j] = temp;      // Place the stored value of arr[i] in arr[j]
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {  // Loop through each element of the array
            System.out.print(num + " ");  // Print the element followed by a space
        }
        System.out.println();  // Move to the next line after printing all elements
    }

    // Main function to take input and run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object for taking user input

        // Asking the user for the size of the array
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();  // Read the number of elements

        // Creating an array to hold the elements
        int[] arr = new int[n];
        System.out.println("Enter the elements:");

        // Loop to take input for each element in the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Read each element
        }

        // Perform the Quick Sort on the array
        quickSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted Array:");
        printArray(arr);  // Print the sorted array

        sc.close();  // Close the scanner to free resources
    }
}
