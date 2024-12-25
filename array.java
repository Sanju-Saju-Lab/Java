import java.util.Scanner;

class array {
    static final int MAX_SIZE = 10; // Maximum size of the array
    static int[] array = new int[MAX_SIZE]; // Array to store elements
    static int size = 0; // Tracks the current number of elements in the array

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Infinite loop for menu-driven program
        while (true) {
            // Display menu options
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Traverse");
            System.out.println("4. Search");
            System.out.println("5. Update");
            System.out.println("6. Exit");
            System.out.println("Your Choice:");
            int choice = scanner.nextInt(); // Take user's choice

            // Perform the corresponding operation based on user input
            switch (choice) {
                case 1:
                    System.out.print("Enter index to insert (0-" + (MAX_SIZE - 1) + "): ");
                    int indexToInsert = scanner.nextInt(); // Get index for insertion
                    System.out.print("Enter value to insert: ");
                    int valueToInsert = scanner.nextInt(); // Get value to insert
                    insert(indexToInsert, valueToInsert); // Call insert method
                    break;
                case 2:
                    System.out.print("Enter index to delete: ");
                    int indexToDelete = scanner.nextInt(); // Get index for deletion
                    delete(indexToDelete); // Call delete method
                    break;
                case 3:
                    traverse(); // Call traverse method to display elements
                    break;
                case 4:
                    System.out.print("Enter 1 to search by index, 2 by value: ");
                    int searchType = scanner.nextInt(); // Determine search type
                    if (searchType == 1) {
                        System.out.print("Enter index to search: ");
                        int indexToSearch = scanner.nextInt(); // Get index for search
                        searchByIndex(indexToSearch); // Call search by index method
                    } else if (searchType == 2) {
                        System.out.print("Enter value to search: ");
                        int valueToSearch = scanner.nextInt(); // Get value to search
                        searchByValue(valueToSearch); // Call search by value method
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 5:
                    System.out.print("Enter index to update: ");
                    int indexToUpdate = scanner.nextInt(); // Get index to update
                    System.out.print("Enter new value: ");
                    int newValue = scanner.nextInt(); // Get new value to update
                    update(indexToUpdate, newValue); // Call update method
                    break;
                case 6:
                    System.out.println("Exiting program."); // Exit program
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid input
            }
        }
    }

    // Displays all elements in the array
    static void traverse() {
        System.out.println("Array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " "); // Print each element
        }
        System.out.println();
    }

    // Inserts a new element at a specific index
    static void insert(int index, int value) {
        if (size >= MAX_SIZE) { // Check if array is full
            System.out.println("Array is full. Cannot insert new element.");
            return;
        }
        if (index < 0 || index > size) { // Check for valid index
            System.out.println("Invalid index.");
            return;
        }
        for (int i = size; i > index; i--) { // Shift elements to the right
            array[i] = array[i - 1];
        }
        array[index] = value; // Insert the new value
        size++; // Increase the size of the array
        System.out.println("Element inserted successfully.");
    }

    // Deletes an element at a specific index
    static void delete(int index) {
        if (index < 0 || index >= size) { // Check for valid index
            System.out.println("Invalid index.");
            return;
        }
        for (int i = index; i < size - 1; i++) { // Shift elements to the left
            array[i] = array[i + 1];
        }
        size--; // Decrease the size of the array
        System.out.println("Element deleted successfully.");
    }

    // Searches for an element by its index
    static void searchByIndex(int index) {
        if (index < 0 || index >= size) { // Check for valid index
            System.out.println("Invalid index.");
            return;
        }
        System.out.println("Element at index " + index + ": " + array[index]); // Display element
    }

    // Searches for an element by its value
    static void searchByValue(int value) {
        for (int i = 0; i < size; i++) { // Iterate through the array
            if (array[i] == value) { // Check if the value matches
                System.out.println("Value " + value + " found at index " + i + ".");
                return;
            }
        }
        System.out.println("Value not found."); // Display if value is not found
    }

    // Updates an element at a specific index
    static void update(int index, int value) {
        if (index < 0 || index >= size) { // Check for valid index
            System.out.println("Invalid index.");
            return;
        }
        array[index] = value; // Update the value at the index
        System.out.println("Element updated successfully.");
    }
}