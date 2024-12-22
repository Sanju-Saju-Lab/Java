import java.util.Scanner;

class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public Stack(int size) {
        stack = new int[size];
        top = -1;
        capacity = size;
    }

    // Push operation
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow! Can't push " + item);
        } else {
            stack[++top] = item;
            System.out.println("Pushed: " + item);
        }
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Can't pop.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stack[top];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Display the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class stack_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped: " + poppedValue);
                    }
                    break;
                case 3:
                    int topValue = stack.peek();
                    if (topValue != -1) {
                        System.out.println("Top element: " + topValue);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}