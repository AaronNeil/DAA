package PT1.Searching;

import java.util.Scanner;

public class LinearSearch {
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
        if (head == null){
            System.out.println("No nodes to display");
        }
    }

    public void insert (int value){
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

    public int search (int value){
        Node tempNode = head;
        
        for (int i = 0; i <= listSize - 1; i ++){
            if (tempNode.value == value){
                return i;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearSearch list = new LinearSearch();

        while (true) {
            System.out.println("\n\n[0]Exit\t\t[2]Search based on value");
            System.out.println("[1]Create Node\t[3]Display list");
            
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
                    if (sc.hasNextInt()) list.insert(sc.nextInt());
                    else System.out.println("Invalid input.");
                    break;
    
                case 2:
                    System.out.print("Enter value to search: ");
                    if (sc.hasNextInt()) {
                        int  element = list.search(sc.nextInt());
                        if (element == -1) System.out.println("\nNo nodes exist with given value.");
                        else System.out.println("The value is at index[" + element + "]");
                    } 
                    else System.out.println("Invalid input.");
                    break;
                    
                case 3:
                    list.display();            
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        sc.close();
    } 
}
