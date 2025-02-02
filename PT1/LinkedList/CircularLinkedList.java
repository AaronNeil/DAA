package PT1.LinkedList;
import java.util.Scanner;

public class CircularLinkedList {
    private int listSize = 0;
    private Node head, tail;

    public static class Node {
        int value;
        Node next;

        Node (int v) {
            value = v;
            next = null;
        }

        Node (int v, Node next_){
            value = v;
            next = next_;
        }
    }

    public void display(){
        Node tempNode = head;
        System.out.print(tempNode != null ? "\nNode[" + (listSize - 1) + "] -> " : "\n");
        do {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        } while (tempNode != head);
        System.out.println("Node[0]\nhead:" + head.value + "\ttail:" + tail.value + "\tlistSize:" + listSize);
    }

    public void createNewNode (int val) {
        Node newNode = new Node(val);

        // If list is empty, make the new Node into the head. Else,
        // Get the 2nd to last node.
        if (head == null) head = newNode;
        else {
            Node tempNode = head;
            while (tempNode.next != head){
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;        // Create a Node and place it at the last.
        }
        
        // Change the tail into the new Node and the next node of the created node will become the head.
        tail = newNode;             
        newNode.next = head;                            
        listSize++;
    }

    public void insertAtIndex (int val, int index) {
        Node tempNode = head;
        //create new node if list is empty
        if (head == null) {
            createNewNode(val);
            return;
        }

        //create node at head
        if (index <= 0){
            head = new Node(val, head);
            tail.next = head;
            listSize++;
            return;
        }
        
        //get prev node of node[index] 
        for (int i = 0; i < index - 1 && tempNode.next != head; i++) tempNode = tempNode.next;
        
        //
        tempNode.next = new Node(val, tempNode.next);
        if (tempNode.next.next == head) tail = tempNode.next;
        listSize++;

    }

    public int deleteNewNode (){
        Node tempNode = head;
        listSize--;

        //if list size is 1, remove head
        if (head == tail){
            head = null;
            return tempNode.value;
        } 
        
        //get 2nd to last node
        while (tempNode.next != tail) {
            tempNode = tempNode.next;
        }
        
        //set next of 2nd to last node = head
        //change tail to 2nd to last node 
        tempNode.next = head;
        tail = tempNode;

        //remove tail
        return tempNode.value;
    }

    public int deleteAtIndex (int index) {
        Node tempNode = head;
        
        //get the prev node of the index
        for (int i = 0; i < (index - 1) ; i++) tempNode = tempNode.next;
        
        //delete tail
        if (tempNode.next == tail) return deleteNewNode();
        
        //delete head
        else if (tempNode.next == head){
            int val = head.value;
            head = head.next;
            if (head == null) tail = null;
            listSize--;
            return val;
        }
        //delete in-between
        else {
            int val = tempNode.next.value;
            tempNode.next = tempNode.next.next;
            listSize--;
            return val;
        }
    }

    public void callNodeAtIndex (int index) {
        // Outputs if list is empty.
        if (head == null) {
            System.out.println("Node [" + index + "] does not exist / null.");
            return;
        }
        Node tempNode = head;

        // Loops through the list to find node[index].
        for (int i = 0; i < index; i++) tempNode = tempNode.next;
        
        // Outputs Node value and value of next node.
        System.out.println("\nNode value of index[" + index + "]: " + tempNode.value);
        System.out.println("Node value of next index: " + tempNode.next.value + "\n");
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
    
        while (true) {

            System.out.println("\n\n[0]Exit\t\t\t[3]Insert node at index\t\t[6]Display all info");
            System.out.println("[1]Create node\t\t[4]Delete node at index");
            System.out.println("[2]Delete last node\t[5]Get node info based on index");

            
            String userInput = sc.next();
            if (!userInput.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
    
            int input = Integer.parseInt(userInput);
            if (input == 0) break;
    
            switch (input) {
                case 1:
                    System.out.print("Enter value to add: ");
                    if (sc.hasNextInt()) list.createNewNode(sc.nextInt());
                    else System.out.println("Invalid input.");
                    break;
    
                case 2:
                    try { 
                        list.deleteNewNode();
                    } catch (NullPointerException e) {
                        System.out.println("\nNo nodes to remove.");
                    }
                    break;
    
                case 3:
                    System.out.print("Enter value to add: ");
                    if (sc.hasNextInt()) {
                        int value = sc.nextInt();
                        System.out.print("Enter index: ");
                        if (sc.hasNextInt()) list.insertAtIndex(value, sc.nextInt());
                        else System.out.println("Invalid index.");
                    } else {
                        System.out.println("Invalid value.");
                    }
                    break;
    
                case 4:
                    System.out.print("Enter index of node to delete: ");
                    try {
                        if (sc.hasNextInt()) list.deleteAtIndex(sc.nextInt());
                        else System.out.println("Invalid index.");
                    } catch (NullPointerException e) {
                        System.out.println("\nNo nodes to remove.");
                    }
                    break;
    
                case 5:
                    System.out.print("Enter index of node to call: ");
                    if (sc.hasNextInt()) list.callNodeAtIndex(sc.nextInt());
                    else System.out.println("Invalid index.");
                    break;
    
                case 6:
                    try {
                        list.display();            
                    } catch (NullPointerException e) {
                        System.out.println("\nNo nodes to display.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        sc.close();
    }
}
