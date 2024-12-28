import java.util.Scanner;

public class InsertionSort {

    // This function sorts an array using the insertion sort algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;  // Get the length of the array
        for (int i = 1; i < n; i++) {  // Start from the second element
            int key = arr[i];  // Store the current element to be inserted
            int j = i - 1;  // Start comparing with the element before it

            // Move elements that are greater than 'key' to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift element to the right
                j = j - 1;  // Move to the previous element
            }
            arr[j + 1] = key;  // Place the key at its correct position
        }
    }

    // This function prints the elements of the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  // Print each element
        }
        System.out.println();  // Move to the next line after printing the array
    }

    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the number of elements in the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();  // Read the number of elements

        // Declare an array to store the elements
        int[] arr = new int[n];

        // Ask the user to enter the elements of the array
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();  // Read each element into the array
        }

        // Print the original unsorted array
        System.out.println("Original Array:");
        printArray(arr);

        // Call the insertionSort function to sort the array
        insertionSort(arr);

        // Print the sorted array
        System.out.println("Sorted Array:");
        printArray(arr);

        scanner.close();  // Close the scanner object to avoid memory leaks
    }
}
