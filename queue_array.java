import java.util.Scanner;

class queue_array{
    private static final int MAX_SIZE = 10; // Define maximum size
    private int[] queue = new int[MAX_SIZE]; // Fixed-size array
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    // Enqueue operation
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add element: " + element);
            return;
        }
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = element;
        size++;
        System.out.println("Enqueued: " + element);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove element.");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % MAX_SIZE;
        size--;
        return element;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % MAX_SIZE] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    int dequeuedElement = queue.dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued: " + dequeuedElement);
                    }
                    break;
                case 3:
                    int peekElement = queue.peek();
                    if (peekElement != -1) {
                        System.out.println("Front element: " + peekElement);
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
