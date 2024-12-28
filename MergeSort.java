import java.util.Scanner;

public class MergeSort {

    // Main function to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the size of the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] arr = new int[n];

        // Ask user to input the array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Display the original array
        System.out.println("Original Array:");
        printArray(arr);

        // Call mergeSort to sort the array
        mergeSort(arr, 0, arr.length - 1);

        // Display the sorted array
        System.out.println("Sorted Array:");
        printArray(arr);

        scanner.close();
    }

    // Function to sort an array using merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point of the array
            int mid = (left + right) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two sorted halves of the array
    public static void merge(int[] arr, int left, int mid, int right) {
        // Find the sizes of the two sub-arrays to merge
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the values of the two sub-arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy the data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // Compare elements from both sub-arrays and put the smaller element in the original array
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from leftArray (if any)
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightArray (if any)
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Helper function to print an array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
