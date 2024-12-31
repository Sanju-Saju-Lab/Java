import java.util.Scanner;

// Node class represents an element in the doubly linked list
class Node {
    int data;  // Data held by the node
    Node next; // Reference to the next node in the list
    Node prev; // Reference to the previous node in the list

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// DLL class represents a Doubly Linked List
class DLL {
    Node head; // Points to the first node of the list
    Node tail; // Points to the last node of the list

    // Constructor initializes an empty doubly linked list
    public DLL() {
        this.head = null;
        this.tail = null;
    }

    // Method to add a node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (head == null) {  // If the list is empty, the new node becomes both the head and tail
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.prev = tail;  // Set the previous node of the new node to the current tail
        tail.next = newNode;  // Set the next node of the current tail to the new node
        tail = newNode;  // Update the tail to the new node
    }

    // Method to add a node at the beginning of the list
    public void prepend(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (head == null) {  // If the list is empty, the new node becomes both the head and tail
            head = newNode;
            tail = newNode;
            return;
        }
        head.prev = newNode; // Set the previous node of the current head to the new node
        newNode.next = head; // Set the next node of the new node to the current head
        head = newNode; // Update the head to the new node
    }

    // Method to insert a node at a specified position in the list
    public void insertAtPosition(int pos, int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (pos == 1) {  // If position is 1, add the node at the beginning
            prepend(data);
            return;
        }
        Node current = head;
        int currentPosition = 1;
        // Traverse the list to find the position
        while (current != null && currentPosition < pos - 1) {
            current = current.next;
            currentPosition++;
        }
        // If position is invalid (out of bounds)
        if (current == null) {
            System.out.println("Invalid position.");
        } else if (current == tail) {  // If position is at the end, append the node
            append(data);
        } else {
            newNode.next = current.next;  // Set the next of the new node
            current.next.prev = newNode;  // Set the previous of the next node to the new node
            current.next = newNode;  // Set the next of the current node to the new node
            newNode.prev = current;  // Set the previous of the new node to the current node
        }
    }

    // Method to delete the first node of the list
    public void deleteFirst() {
        if (head == null) {  // If the list is empty
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {  // If there's only one node in the list
            head = tail = null;
        } else {
            head = head.next;  // Move the head to the next node
            head.prev = null;  // Set the previous of the new head to null
        }
    }

    // Method to delete the last node of the list
    public void deleteLast() {
        if (tail == null) {  // If the list is empty
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {  // If there's only one node in the list
            head = tail = null;
        } else {
            tail = tail.prev;  // Move the tail to the previous node
            tail.next = null;  // Set the next of the new tail to null
        }
    }

    // Method to delete a node at a specified position
    public void deleteNode(int pos) {
        if (head == null) {  // If the list is empty
            System.out.println("List is empty.");
            return;
        }
        if (pos == 1) {  // If position is 1, delete the first node
            deleteFirst();
            return;
        }
        Node current = head;
        int currentPosition = 1;
        // Traverse the list to find the position
        while (current != null && currentPosition < pos) {
            current = current.next;
            currentPosition++;
        }
        // If position is invalid (out of bounds)
        if (current == null) {
            System.out.println("Invalid position.");
        } else if (current == tail) {  // If position is the last node, delete the last node
            deleteLast();
        } else {
            current.prev.next = current.next;  // Bypass the current node
            current.next.prev = current.prev;  // Bypass the current node
        }
    }

    // Method to traverse the list from the beginning (head to tail)
    public void traverseForward() {
        if (head == null) {  // If the list is empty
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        // Traverse and print all nodes from head to tail
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to traverse the list from the end (tail to head)
    public void traverseBackward() {
        if (tail == null) {  // If the list is empty
            System.out.println("List is empty.");
            return;
        }
        Node current = tail;
        // Traverse and print all nodes from tail to head
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLL dll = new DLL(); // Create a new doubly linked list

        // Allow the user to append nodes to the list
        int choice = 1, data;
        while (choice == 1) {
            System.out.print("Enter the data: ");
            data = scanner.nextInt();
            dll.append(data);  // Append the node
            System.out.print("Do you want to insert more elements? 0(No) or 1(Yes): ");
            choice = scanner.nextInt();
        }

        dll.traverseForward();  // Display the list

        // Main menu for operations on the doubly linked list
        while (true) {
            System.out.println("\nDoubly Linked List Menu");
            System.out.println("1. Insert at the beginning.");
            System.out.println("2. Insert at the end.");
            System.out.println("3. Insert at a specified position.");
            System.out.println("4. Remove from the beginning.");
            System.out.println("5. Remove from the end.");
            System.out.println("6. Remove from a specified position.");
            System.out.println("7. Traverse Forward");
            System.out.println("8. Traverse Backward");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.print("Enter the data: ");
                    data = scanner.nextInt();
                    dll.prepend(data);  // Insert at the beginning
                    dll.traverseForward();
                    break;
                case 2:
                    System.out.print("Enter the data: ");
                    data = scanner.nextInt();
                    dll.append(data);  // Insert at the end
                    dll.traverseForward();
                    break;
                case 3:
                    System.out.print("Enter the data: ");
                    data = scanner.nextInt();
                    System.out.print("Enter the position: ");
                    int position = scanner.nextInt();
                    dll.insertAtPosition(position, data);  // Insert at the specified position
                    dll.traverseForward();
                    break;
                case 4:
                    dll.deleteFirst();  // Delete the first node
                    dll.traverseForward();
                    break;
                case 5:
                    dll.deleteLast();  // Delete the last node
                    dll.traverseForward();
                    break;
                case 6:
                    System.out.print("Enter the position: ");
                    int pos = scanner.nextInt();
                    dll.deleteNode(pos);  // Delete the node at the specified position
                    dll.traverseForward();
                    break;
                case 7:
                    System.out.println("Traverse Forward:");
                    dll.traverseForward();  // Traverse from head to tail
                    break;
                case 8:
                    System.out.println("Traverse Backward:");
                    dll.traverseBackward();  // Traverse from tail to head
                    break;
                case 9:
                    System.out.println("Exited");
                    scanner.close();
                    System.exit(0);  // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
