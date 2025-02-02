package PT1.LinkedList;

import java.util.Scanner;

public class SinglyLinkedList {
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
        System.out.println();
        while (tempNode != null){
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null\nhead:" + head.value + "\ttail:" + tail.value + "\tlistSize:" + listSize);
    }
    
    public void createNewNode (int val) {
        Node newNode = new Node(val);
        newNode.next = null;

        // If list is empty, make the new Node into the head. Else,
        // Get the 2nd to last node.
        if (head == null) head = newNode;
        else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;        // Create a Node and place it at the last.
        }

        // Change the tail into the new Node and increment size by 1.
        tail = newNode;
        listSize++;
    }

    public void insertAtIndex (int val, int index) {
        Node tempNode = head;

        // Create a node at head or if list is empty
        if (head == null || index <= 0) {
            head = new Node(val, head);
            if (head.next == null) tail = head;
            listSize++;
            return;
        }

        // Get the prev node of node[index]
        for (int i = 0; i < index - 1 && tempNode.next != null; i++) tempNode = tempNode.next;
        
        //Create the node based on the index and change the tail if the created node is on the lasst.
        tempNode.next = new Node(val, tempNode.next);
        if (tempNode.next.next == null) tail = tempNode.next;
        listSize++;
    }

    public int deleteNewNode(){
        //  If list size is 1, run deleteAtIndex method else, 
        //  remove tail
        if (listSize <= 1) return deleteAtIndex(0);
        else {
            Node tempNode = head;
            
            //  Get prev node of tail, setthe node as  tail, and change the next node of the tail to null.
            for (int i = 0; i < (listSize - 2) ; i++) tempNode = tempNode.next;
            
            int val = tail.value;
            tail = tempNode;
            tail.next = null;
            listSize--;
            return val;
        }
    }

    public int deleteAtIndex(int index){
        
        // delete head node and move it to the next node.
        if (index <= 0){
            int val = head.value;
            head = head.next;
            
            //  If list is empty, change tail to null.
            if (head == null) tail = null;
            listSize--;
            return val;
        }
        
        //  If index is removing tail, run deleteNewNode() method
        if (index >= (listSize - 1)) return deleteNewNode();
        else {
            Node tempNode = head;

            //  remove the the node[index] and change the prev node's next node into the next of the node[index].
            for (int i = 0; i < (index - 1) ; i++) tempNode = tempNode.next;
            int val = tempNode.next.value;
            tempNode.next = tempNode.next.next;
            listSize--;
            return val;
        }
    }

    public void callNodeAtIndex(int index) {
        //  Outputs if list is empty
        if (head == null || index >= listSize) {
            System.out.println("Node [" + index + "] does not exist / null.");
            return;
        }
        Node tempNode = head;

        // Loops through the list to find node[index].
        for (int i = 0; i < index; i++) tempNode = tempNode.next;
    
        // Outputs Node value and value of next node.
        System.out.println("\nNode value of index[" + index + "]: " + tempNode.value);
        System.out.println("Node value of next index: " + (tempNode.next != null ? tempNode.next.value : "null") + "\n");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
    
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