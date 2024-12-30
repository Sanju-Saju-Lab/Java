import java.util.Scanner;

// A class representing a single node in the linked list
class Node {
    int data; // The value stored in the node
    Node next; // Reference to the next node in the list

    // Constructor to create a new node with given data
    public Node(int data) {
        this.data = data;
        this.next = null; // Next is initially null
    }
}

// A class representing the singly linked list
class SinglyLinkedList {
    Node head; // Reference to the first node of the list

    // Constructor to initialize an empty linked list
    public SinglyLinkedList() {
        this.head = null;
    }

    // Insert a new node at the beginning of the list
    public void insertAtFirst(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head; // Point new node to the current head
        head = newNode; // Update head to the new node
    }

    // Insert a new node at the end of the list
    public void insertAtLast(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) { // If the list is empty
            head = newNode; // Make new node the head
        } else {
            Node current = head;
            // Traverse to the last node
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Link the last node to the new node
        }
    }

    // Insert a new node at a specific position in the list
    public void insertAtPosition(int data, int pos) {
        if (pos < 0) { // Check for invalid position
            System.out.println("Position cannot be negative.");
            return;
        }

        if (pos == 0) { // Insertion at the beginning
            insertAtFirst(data);
            return;
        }

        Node newNode = new Node(data); // Create a new node
        Node current = head;
        // Traverse to the position before the desired position
        for (int i = 0; i < pos - 1; i++) {
            if (current == null) { // Check if position is out of bounds
                System.out.println("Position exceeds the list");
                return;
            }
            current = current.next;
        }

        if (current == null) { // Additional check for out-of-bounds
            System.out.println("Position exceeds the list");
            return;
        }

        newNode.next = current.next; // Link new node to the next node
        current.next = newNode; // Link current node to the new node
    }

    // Remove the first node from the list
    public void removeAtFirst() {
        if (head == null) { // If the list is empty
            System.out.println("List is empty...");
            return;
        }
        System.out.println(head.data + " removed from the list"); // Print removed value
        head = head.next; // Update head to the next node
    }

    // Remove the last node from the list
    public void removeAtLast() {
        if (head == null) { // If the list is empty
            System.out.println("List is empty...");
            return;
        }
        if (head.next == null) { // If there's only one node
            removeAtFirst(); // Use existing method to remove it
        } else {
            Node current = head;
            // Traverse to the second-last node
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println(current.next.data + " removed from list"); // Print removed value
            current.next = null; // Remove the last node
        }
    }

    // Remove a node from a specific position in the list
    public void removeAtPosition(int pos) {
        if (pos < 0) { // Check for invalid position
            System.out.println("Position cannot be negative.");
            return;
        }

        if (pos == 0) { // Removal at the beginning
            removeAtFirst();
            return;
        }

        Node current = head;
        // Traverse to the position before the desired position
        for (int i = 0; i < pos - 1; i++) {
            if (current == null) { // Check if position is out of bounds
                System.out.println("Position exceeds list");
                return;
            }
            current = current.next;
        }

        if (current == null || current.next == null) { // Additional check for out-of-bounds
            System.out.println("Position exceeds list");
            return;
        }

        System.out.println(current.next.data + " removed from list"); // Print removed value
        current.next = current.next.next; // Remove the node
    }

    // Display all elements of the linked list
    public void display() {
        Node current = head;
        while (current != null) { // Traverse through the list
            System.out.print(current.data + " -> "); // Print each node's data
            current = current.next;
        }
        System.out.println("null"); // Indicate end of the list
    }

    // Main method for user interaction
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int choice = 1, data, pos;

        // Initial insertion into the list
        System.out.println("Enter elements to the list: ");
        while (choice == 1) {
            System.out.print("Enter data: ");
            data = input.nextInt();
            list.insertAtLast(data); // Insert data at the end of the list
            System.out.println("Do you want to insert more elements to the list 0(No) or 1(Yes): ");
            choice = input.nextInt();
        }

        System.out.println("List after initial insertion: ");
        list.display(); // Display the list

        // Menu-driven operations on the list
        while (true) {
            System.out.println("\nLinked list operations: ");
            System.out.println("1. Insert at the beginning.");
            System.out.println("2. Insert at the end.");
            System.out.println("3. Insert at a specified position.");
            System.out.println("4. Remove from the beginning.");
            System.out.println("5. Remove from the end.");
            System.out.println("6. Remove from a specified position.");
            System.out.println("7. Traverses.");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            // Perform operations based on user's choice
            switch (choice) {
                case 1:
                    System.out.println("Enter the data: ");
                    data = input.nextInt();
                    list.insertAtFirst(data);
                    break;
                case 2:
                    System.out.println("Enter the data: ");
                    data = input.nextInt();
                    list.insertAtLast(data);
                    break;
                case 3:
                    System.out.println("Enter the data: ");
                    data = input.nextInt();
                    System.out.println("Enter the position: ");
                    pos = input.nextInt();
                    list.insertAtPosition(data, pos);
                    break;
                case 4:
                    list.removeAtFirst();
                    break;
                case 5:
                    list.removeAtLast();
                    break;
                case 6:
                    System.out.println("Enter the position: ");
                    pos = input.nextInt();
                    list.removeAtPosition(pos);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.exit(0); // Exit the program
            }
        }
    }
}
