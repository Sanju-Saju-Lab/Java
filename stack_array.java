import java.util.Scanner;

// Class to implement a stack using an array
class StackArray {
    private static final int MAX_SIZE = 10; // Maximum size of the stack
    private int[] stack;  // Array to hold stack elements
    private int top;  // Keeps track of the top of the stack

    // Constructor to initialize the stack
    public StackArray() {
        stack = new int[MAX_SIZE];  // Initialize the stack with a fixed size
        top = -1;  // Initially the stack is empty, so top is set to -1
    }

    // Method to push an element onto the stack
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow! Can't push " + item);  // Stack is full, can't push new item
        } else {
            stack[++top] = item;  // Add the item to the stack and move the top pointer up
            System.out.println("Pushed: " + item);  // Display the pushed item
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Can't pop.");  // Stack is empty, can't pop
            return -1;
        } else {
            return stack[top--];  // Return the top element and decrease the top pointer
        }
    }

    // Method to view the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");  // If stack is empty, there is no top element
            return -1;
        } else {
            return stack[top];  // Return the top element without removing it
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;  // If top is -1, the stack is empty
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == MAX_SIZE - 1;  // If top is at the last index, the stack is full
    }

    // Method to display all elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");  // If stack is empty, display a message
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");  // Print all elements in the stack
            }
            System.out.println();
        }
    }
}

// Main class to interact with the stack
public class stack_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a stack with a fixed size
        StackArray stack = new StackArray(); 

        while (true) {
            // Display menu of available operations
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();  // Read the user's choice

            switch (choice) {
                case 1:
                    // Push an element onto the stack
                    System.out.print("Enter the value to push: ");
                    int value = scanner.nextInt();  // Read the value to push
                    stack.push(value);
                    break;
                case 2:
                    // Pop an element from the stack
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped: " + poppedValue);  // Display the popped value
                    }
                    break;
                case 3:
                    // Peek the top element of the stack
                    int topValue = stack.peek();
                    if (topValue != -1) {
                        System.out.println("Top element: " + topValue);  // Display the top element
                    }
                    break;
                case 4:
                    // Display the entire stack
                    stack.display();
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;  // Terminate the program
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
