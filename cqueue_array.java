import java.util.Scanner;

class cqueue_array {
    static final int MAX_SIZE = 10;
    int[] queue = new int[MAX_SIZE];
    int front = -1, rear = -1;

    // Enqueue operation
    void enqueue(int value) {
        if ((rear + 1) % MAX_SIZE == front) {
            System.out.println("Queue is full!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % MAX_SIZE;
            queue[rear] = value;
            System.out.println(value + " enqueued.");
        }
    }

    // Dequeue operation
    void dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println(queue[front] + " dequeued.");
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % MAX_SIZE;
            }
        }
    }

    // Peek operation
    void peek() {
        if (front == -1) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front element is: " + queue[front]);
        }
    }

    // Display the queue
    void display() {
        if (front == -1) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            while (i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % MAX_SIZE;
            }
            System.out.println(queue[rear]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cqueue_array cqueue = new cqueue_array();
        int choice, value;

        do {
            System.out.println("\nChoose an Operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    value = sc.nextInt();
                    cqueue.enqueue(value);
                    break;
                case 2:
                    cqueue.dequeue();
                    break;
                case 3:
                    cqueue.peek();
                    break;
                case 4:
                    cqueue.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
