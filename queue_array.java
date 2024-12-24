import java.util.Scanner;

class queue_array {
    private static final int MAX_SIZE = 10; // Maximum size of the queue
    private int[] queue = new int[MAX_SIZE]; // Array to store queue elements
    private int front = -1; // Front of the queue, initialized to -1 (empty)
    private int rear = -1; // Rear of the queue, initialized to -1 (empty)

    // Adds an element to the queue
    public void enqueue(int element) {
        if (isFull()) { // Check if the queue is full
            System.out.println("Queue is full. Cannot add element: " + element);
            return;
        }
        if (front == -1 && rear == -1) { // If the queue is empty
            front = 0; // Set front to 0
            rear = 0; // Set rear to 0
        } else {
            rear++; // Move the rear pointer to the next position
        }
        queue[rear] = element; // Add the element to the queue
        System.out.println("Enqueued: " + element); // Confirm the addition
    }

    // Removes and returns the front element from the queue
    public int dequeue() {
        if (isEmpty()) { // Check if the queue is empty
            System.out.println("Queue is empty. Cannot remove element.");
            return -1; // Return -1 if the queue is empty
        }
        int element = queue[front]; // Get the front element
        front++; // Move the front pointer to the next position
        if (front > rear) { // If the queue becomes empty
            front = -1; // Reset front
            rear = -1; // Reset rear
        }
        return element; // Return the dequeued element
    }

    // Returns the front element without removing it
    public int peek() {
        if (isEmpty()) { // Check if the queue is empty
            System.out.println("Queue is empty. Nothing to peek.");
            return -1; // Return -1 if the queue is empty
        }
        return queue[front]; // Return the front element
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return front == -1 && rear == -1; // Queue is empty if front and rear are both -1
    }

    // Checks if the queue is full
    public boolean isFull() {
        return rear == MAX_SIZE - 1; // Queue is full if rear is at the last index
    }

    // Displays all elements in the queue
    public void display() {
        if (isEmpty()) { // Check if the queue is empty
            System.out.println("Queue is empty."); // Inform the user if it's empty
            return;
        }
        System.out.print("Queue elements: "); // Show the queue elements
        for (int i = front; i <= rear; i++) { // Loop through all elements from front to rear
            System.out.print(queue[i] + " "); // Print each element
        }
        System.out.println(); // Print a newline after displaying the elements
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        queue_array queue = new queue_array(); // Create a new queue object
        Scanner scanner = new Scanner(System.in); // Create a scanner for user input

        while (true) { // Infinite loop for user interaction
            System.out.println("\nChoose an operation:"); // Display options
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt(); // Get the user's choice

            switch (choice) {
                case 1: // Enqueue operation
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt(); // Get the element to add
                    queue.enqueue(element); // Call the enqueue method
                    break;
                case 2: // Dequeue operation
                    int dequeuedElement = queue.dequeue(); // Remove an element from the front
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued: " + dequeuedElement); // Confirm the removal
                    }
                    break;
                case 3: // Peek operation
                    int peekedElement = queue.peek(); // Get the front element without removing it
                    if (peekedElement != -1) {
                        System.out.println("Front element: " + peekedElement); // Display the front element
                    }
                    break;
                case 4: // Display operation
                    queue.display(); // Display the queue elements
                    break;
                case 5: // Exit operation
                    System.out.println("Exiting program. Goodbye!"); // Exit the program
                    scanner.close(); // Close the scanner
                    return; // Exit the loop and the program
                default: // Invalid choice
                    System.out.println("Invalid choice. Please try again."); // Prompt the user to try again
            }
        }
    }
}
