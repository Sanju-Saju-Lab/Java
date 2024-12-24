import java.util.Scanner;

class cqueue_array {
    // Define the maximum size of the queue
    static final int MAX_SIZE = 10;

    // Create an array to store the queue elements
    int[] queue = new int[MAX_SIZE];
    int front = -1, rear = -1;  // front and rear pointers for the queue

    // Enqueue operation: Adds an element to the queue
    void enqueue(int value) {
        // Check if the queue is full (when rear+1 is the same as front)
        if ((rear + 1) % MAX_SIZE == front) {
            System.out.println("Queue is full!");  // If full, print message
        } else {
            // If the queue is empty, set front to 0
            if (front == -1) {
                front = 0;
            }
            // Move rear pointer to the next position in a circular way
            rear = (rear + 1) % MAX_SIZE;
            queue[rear] = value;  // Add the new value to the queue
            System.out.println(value + " enqueued.");
        }
    }

    // Dequeue operation: Removes an element from the queue
    void dequeue() {
        // Check if the queue is empty
        if (front == -1) {
            System.out.println("Queue is empty!");  // If empty, print message
        } else {
            System.out.println(queue[front] + " dequeued.");  // Print dequeued element
            // If there's only one element, reset front and rear to -1 (empty queue)
            if (front == rear) {
                front = rear = -1;
            } else {
                // Move front pointer to the next element in a circular way
                front = (front + 1) % MAX_SIZE;
            }
        }
    }

    // Peek operation: Shows the front element without removing it
    void peek() {
        // Check if the queue is empty
        if (front == -1) {
            System.out.println("Queue is empty!");  // If empty, print message
        } else {
            System.out.println("Front element is: " + queue[front]);  // Show front element
        }
    }

    // Display operation: Prints all the elements in the queue
    void display() {
        // Check if the queue is empty
        if (front == -1) {
            System.out.println("Queue is empty!");  // If empty, print message
        } else {
            // Print all the elements from front to rear
            System.out.print("Queue elements: ");
            int i = front;
            // Loop through the queue elements in circular manner
            while (i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % MAX_SIZE;
            }
            System.out.println(queue[rear]);  // Print the last element (rear)
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a scanner to read user input
        cqueue_array cqueue = new cqueue_array();  // Create a queue object
        int choice, value;

        // Loop to display menu until user exits
        do {
            // Display menu of operations
            System.out.println("\nChoose an Operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();  // Get user choice

            // Switch to perform the corresponding operation
            switch (choice) {
                case 1:
                    // Enqueue operation
                    System.out.print("Enter value to enqueue: ");
                    value = sc.nextInt();  // Get value to enqueue
                    cqueue.enqueue(value);  // Call enqueue method
                    break;
                case 2:
                    // Dequeue operation
                    cqueue.dequeue();  // Call dequeue method
                    break;
                case 3:
                    // Peek operation
                    cqueue.peek();  // Call peek method
                    break;
                case 4:
                    // Display queue operation
                    cqueue.display();  // Call display method
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;
                default:
                    // Handle invalid choice
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);  // Repeat until the user chooses to exit

        sc.close();  // Close the scanner
    }
}
