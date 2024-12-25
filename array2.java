import java.util.Scanner;

class array2 {
    static final int ROWS = 4; // Number of rows in the 2D array
    static final int COLS = 4; // Number of columns in the 2D array
    static int[][] array = new int[ROWS][COLS]; // 2D array to store elements

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Keep running until the user exits
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Traverse");
            System.out.println("4. Search");
            System.out.println("5. Update");
            System.out.println("6. Exit");
            System.out.print("Your Choice: ");
            int choice = scanner.nextInt(); // Get user's choice of operation

            switch (choice) { // Perform operation based on user's choice
                case 1:
                    System.out.print("Enter row (0-" + (ROWS - 1) + "): ");
                    int rowToInsert = scanner.nextInt();
                    System.out.print("Enter column (0-" + (COLS - 1) + "): ");
                    int colToInsert = scanner.nextInt();
                    System.out.print("Enter value to insert: ");
                    int valueToInsert = scanner.nextInt();
                    insert(rowToInsert, colToInsert, valueToInsert); // Call insert method
                    break;
                case 2:
                    System.out.print("Enter row (0-" + (ROWS - 1) + "): ");
                    int rowToDelete = scanner.nextInt();
                    System.out.print("Enter column (0-" + (COLS - 1) + "): ");
                    int colToDelete = scanner.nextInt();
                    delete(rowToDelete, colToDelete); // Call delete method
                    break;
                case 3:
                    traverse(); // Call traverse method to display all elements
                    break;
                case 4:
                    System.out.print("Enter 1 to search by row and column, 2 by value: ");
                    int searchType = scanner.nextInt(); // Ask for search method
                    if (searchType == 1) {
                        System.out.print("Enter row to search (0-" + (ROWS - 1) + "): ");
                        int rowToSearch = scanner.nextInt();
                        System.out.print("Enter column to search (0-" + (COLS - 1) + "): ");
                        int colToSearch = scanner.nextInt();
                        searchByIndex(rowToSearch, colToSearch); // Search by row and column
                    } else if (searchType == 2) {
                        System.out.print("Enter value to search: ");
                        int valueToSearch = scanner.nextInt();
                        searchByValue(valueToSearch); // Search by value
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 5:
                    System.out.print("Enter row to update (0-" + (ROWS - 1) + "): ");
                    int rowToUpdate = scanner.nextInt();
                    System.out.print("Enter column to update (0-" + (COLS - 1) + "): ");
                    int colToUpdate = scanner.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = scanner.nextInt();
                    update(rowToUpdate, colToUpdate, newValue); // Update value at row, col
                    break;
                case 6:
                    System.out.println("Exiting program."); // Exit the program
                    scanner.close();
                    return; // Exit the loop and the program
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid input
            }
        }
    }

    // Displays all elements in the 2D array
    static void traverse() {
        System.out.println("Array elements:");
        for (int i = 0; i < ROWS; i++) { // Loop through each row
            for (int j = 0; j < COLS; j++) { // Loop through each column in the row
                System.out.print(array[i][j] + " "); // Print each element
            }
            System.out.println(); // Move to the next row
        }
    }

    // Inserts a value at the specified row and column
    static void insert(int row, int col, int value) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) { // Check if the index is valid
            System.out.println("Invalid index.");
            return; // Stop if the index is invalid
        }
        array[row][col] = value; // Insert the value in the array
        System.out.println("Element inserted successfully.");
    }

    // Deletes a value at the specified row and column
    static void delete(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) { // Check if the index is valid
            System.out.println("Invalid index.");
            return; // Stop if the index is invalid
        }
        array[row][col] = 0; // Delete the value (set it to 0)
        System.out.println("Element deleted successfully.");
    }

    // Searches for an element by row and column
    static void searchByIndex(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) { // Check if the index is valid
            System.out.println("Invalid index.");
            return; // Stop if the index is invalid
        }
        System.out.println("Element at [" + row + "][" + col + "]: " + array[row][col]); // Print the element
    }

    // Searches for an element by its value
    static void searchByValue(int value) {
        for (int i = 0; i < ROWS; i++) { // Loop through each row
            for (int j = 0; j < COLS; j++) { // Loop through each column in the row
                if (array[i][j] == value) { // Check if the value matches
                    System.out.println("Value " + value + " found at index [" + i + "][" + j + "].");
                    return; // Stop if the value is found
                }
            }
        }
        System.out.println("Value not found."); // If the value is not found, show this message
    }

    // Updates the value at the specified row and column
    static void update(int row, int col, int value) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) { // Check if the index is valid
            System.out.println("Invalid index.");
            return; // Stop if the index is invalid
        }
        array[row][col] = value; // Update the value in the array
        System.out.println("Element updated successfully.");
    }
}
