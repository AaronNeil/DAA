package PT1.LinkedList;

import java.util.Scanner;

public class DoublyLinkedList {
    private int listSize = 0;
    private Node head, tail;

    public static class Node {
        int value;
        Node next, prev;

        Node (int v) {
            value = v;
            next = null;
            prev = null;
        }

        Node (int v, Node next_) {
            value = v;
            next = next_;
            prev = null;
        }

        Node (int v, Node next_, Node prev_){
            value = v;
            next = next_;
            prev = prev_;
        }
    }
    
    public void display(){
        Node tempNode = head;
        System.out.print(tempNode != null ? "\nnull <-" : "\n");
        while (tempNode != null){
            System.out.print(" " + tempNode.value + " -");
            tempNode = tempNode.next;
        }
        System.out.println("> null\nhead:" + head.value + "\ttail:" + tail.value + "\tlistSize:" + listSize);
    }
    
    public void createNewNode (Scanner sc) {
        int val;
        System.out.print("Enter value to add: ");
        if (sc.hasNextInt()) val = sc.nextInt();
        else {
            System.out.println("Invalid input.");
            return;
        }
 
        Node newNode = new Node(val);
        newNode.next = null;

        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;            
            newNode.prev = tail;
            tail = newNode;
        }
        listSize++;       
    }

    public void insertAtIndex (Scanner sc){
        int val, index;

        System.out.print("Enter value to add: ");
        if (sc.hasNextInt()) {
            val = sc.nextInt();
            System.out.print("Enter index: ");
            if (sc.hasNextInt()) index = sc.nextInt();
            else{
                System.out.println("Invalid index.");
                return;
            } 
        } else {
            System.out.println("Invalid value.");
            return;
        }
        
        Node tempNode = head;

        if (head == null || index <= 0) {
            head = new Node(val, head);
            if (head.next == null) tail = head;
            listSize++;
            return;
        }

        for (int i = 0; i < index - 1 && tempNode.next != null; i++) tempNode = tempNode.next;

        tempNode.next = new Node(val, tempNode.next, tempNode.prev);
        if (tempNode.next.next == null) tail = tempNode.next;
        listSize++;
    }

    public int deleteNewNode (boolean bool){
        if (listSize <= 1 || bool == true){
            int val = head.value;
            head = head.next;
            
            if (head == null) tail = null;
            listSize--;
            return val;
        }
        else{
            int val = tail.value;
            tail = tail.prev;
            tail.next = null;
            listSize--;
            return val;
        }
    }

    public int deleteAtIndex (Scanner sc){
        int index;

        System.out.print("Enter index of node to delete: ");
        if (sc.hasNextInt()) index = sc.nextInt();
        else {
            System.out.println("\nThere are no Nodes.");
            return -1;
        }

        if (index == 0) return deleteNewNode(true);
        if (index >= (listSize - 1)) return deleteNewNode(false);
        else{
            Node tempNode = head;
            
            for (int i = 0; i < (index - 1) ; i++) tempNode = tempNode.next;
            int val = tempNode.next.value;
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            listSize--;
            return val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println("\n\n[0]Exit\t\t\t[3]Insert node at index");
            System.out.println("[1]Create node\t\t[4]Delete node at index");
            System.out.println("[2]Delete last node\t[5]Display all info");
            
            String userInput = sc.next();
            if (!userInput.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
    
            int input = Integer.parseInt(userInput);
            if (input == 0) break;

            processInput(input, sc, list);
 
        }
        sc.close();
    }
    public static void processInput(int input, Scanner sc, DoublyLinkedList list) {
        try {
            switch (input) {
                case 1 -> list.createNewNode(sc);
                case 2 -> list.deleteNewNode(false);
                case 3 -> list.insertAtIndex(sc);
                case 4 -> list.deleteAtIndex(sc);
                case 5 -> list.display();
                default -> System.out.println("Invalid choice.");
            }
        } catch (NullPointerException e) {
            System.out.println("\nThere are no Nodes.");
        }
    }
}