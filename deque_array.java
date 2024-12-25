import java.util.Scanner;

public class deque_array {
    private int[] deque; // Array to store the deque elements
    private int front, rear, size; // front and rear pointers, size of the deque
    private static final int MAX_SIZE = 10; // Maximum size of the deque

    // Constructor to initialize the deque
    public deque_array(int size) {
        this.size = size;
        deque = new int[size]; // Create an array to hold the deque elements
        front = -1; // Front pointer starts at -1 to indicate empty deque
        rear = -1; // Rear pointer starts at -1 to indicate empty deque
    }

    // Method to check if the deque is empty
    private boolean isEmpty() {
        return front == -1;
    }

    // Method to check if the deque is full
    private boolean isFull() {
        return (rear + 1) % size == front; // Full when rear is one position before front
    }

    // Method to insert an element at the front (for input-restricted deque)
    public void insertFront(int value) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        // If deque is empty, set both front and rear to 0
        front = isEmpty() ? (rear = 0) : (front - 1 + size) % size;
        deque[front] = value; // Place the value at the front
    }

    // Method to insert an element at the rear
    public void insertRear(int value) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        // If deque is empty, set both front and rear to 0
        rear = isEmpty() ? (front = 0) : (rear + 1) % size;
        deque[rear] = value; // Place the value at the rear
    }

    // Method to delete an element from the front
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }
        // If only one element is in the deque, reset both pointers to -1
        front = front == rear ? (rear = -1) : (front + 1) % size;
    }

    // Method to delete an element from the rear
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }
        // If only one element is in the deque, reset both pointers to -1
        rear = front == rear ? (front = -1) : (rear - 1 + size) % size;
    }

    // Method to display all the elements of the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        System.out.print("Deque: ");
        // Loop through the deque from front to rear and print the elements
        for (int i = front; ; i = (i + 1) % size) {
            System.out.print(deque[i] + " ");
            if (i == rear) break; // Stop when the rear is reached
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        deque_array deque = new deque_array(MAX_SIZE); // Create a deque with max size

        int dequeType;
        // Prompt user to choose between input-restricted and output-restricted deque
        do { 
            System.out.println("Choose deque type:");
            System.out.println("1. Input Restricted");
            System.out.println("2. Output Restricted");
            System.out.print("Your choice: ");
            dequeType = scanner.nextInt();

            if (dequeType < 1 || dequeType > 2) {
                System.out.println("Invalid choice.");
            }
        } while (dequeType < 1 || dequeType > 2);

        while (true) {
            System.out.println("\nChoose an operation:");
            // Display different options based on the chosen deque type
            if (dequeType == 1) { // Input Restricted
                System.out.println("1. Insert at Rear");
                System.out.println("2. Delete from Front");
                System.out.println("3. Delete from Rear");
            } else { // Output Restricted
                System.out.println("1. Insert at Front");
                System.out.println("2. Insert at Rear");
                System.out.println("3. Delete from Front");
            }
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            if (choice == 5) break; // Exit the loop if user chooses 5

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    if (dequeType == 1) deque.insertRear(value); // Input Restricted: Insert at rear
                    else deque.insertFront(value); // Output Restricted: Insert at front
                    break;
                case 2:
                    if (dequeType == 1) deque.deleteFront(); // Input Restricted: Delete from front
                    else {
                        System.out.print("Enter value: ");
                        deque.insertRear(scanner.nextInt()); // Output Restricted: Insert at rear
                    }
                    break;
                case 3:
                    if (dequeType == 1) deque.deleteRear(); // Input Restricted: Delete from rear
                    else deque.deleteFront(); // Output Restricted: Delete from front
                    break;
                case 4:
                    deque.display(); // Display the current state of the deque
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close(); // Close the scanner to release resources
    }
}
