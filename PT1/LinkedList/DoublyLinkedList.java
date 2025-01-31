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

        Node (int v, Node next_, Node prev_){
            value = v;
            next = next_;
            prev = prev_;
        }
    }
    
    public void display(){

    }
    
    public void createNewNode (int val) {
        Node newNode = new Node(val);
        newNode.next = null;
        if (head == null){
            head = newNode;
            newNode.prev = null;
        } else {
            Node tempNode = head;
            while (tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
            tempNode.prev = tempNode;
        }
        tail = newNode;
        listSize++;
    }

    public void insertAtIndex (int val, int index){

    }

    public void deleteNewNode (){

    }
    public void deleteAtIndex (int index){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println("\n0 - Exit, 1 - Create node, 2 - Delete last node");
            System.out.println("3 - Insert node at index, 4 - Delete node at index");
            
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
                        System.out.println("No nodes to remove.");
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
                        System.out.println("No nodes to remove.");
                    }
                    break;
    
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            try {
                list.display();            
            } catch (NullPointerException e) {
                System.out.println("No nodes to display.");
            }
        }
        sc.close();
    }
}
