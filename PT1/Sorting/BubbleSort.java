package PT1.Sorting;

import java.util.Scanner;

public class BubbleSort {
    private int listSize = 0;
    private Node head;

    public static class Node {
        int value;
        Node next;

        Node (int v) {
            value = v;
            next = null;
        }

    }


    public void display(){
        Node tempNode = head;
        System.out.println();   
        while (tempNode != null){
            System.out.print(tempNode.value + ", ");
            tempNode = tempNode.next;
        }
        if (head == null) System.out.println("No nodes to display");
    }

    public void insert (Scanner sc){
        int value;
        
        System.out.print("Enter value to add: ");
        if (sc.hasNextInt()) value = sc.nextInt();
        else {
            System.out.println("Invalid input.");
            return;
        }
        
        Node newNode = new Node(value);
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        listSize++;
    }
    
    public void sort() {
        if (head == null || head.next == null) {
            System.out.println("No nodes to sort.");
            return;
        }
        boolean swapped;
        Node tempNode;
        Node lastSorted = null;
    
        do {
            swapped = false;
            tempNode = head;
    
            while (tempNode.next != lastSorted) {
                if (tempNode.value > tempNode.next.value) {

                    int temp = tempNode.value;
                    tempNode.value = tempNode.next.value;
                    tempNode.next.value = temp;
                    swapped = true;
                }
                tempNode = tempNode.next;
            }
            lastSorted = tempNode; 
        } while (swapped);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BubbleSort list = new BubbleSort();

        while (true) {
            System.out.println("\n\n[0]Exit\t\t[2]Sort the Nodes");
            System.out.println("[1]Create Node\t[3]Display list");
            
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
    public static void processInput(int input, Scanner sc, BubbleSort list) {
        try {
            switch (input) {
                case 1 -> list.insert(sc);
                case 2 -> list.sort();
                case 3 -> list.display();
                default -> System.out.println("Invalid choice.");
            }
        } catch (NullPointerException e) {
            System.out.println("\nNo elements exist.");
        }
    }
}