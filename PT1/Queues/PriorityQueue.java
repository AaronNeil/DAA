package PT1.Queues;

import java.util.Scanner;

public class PriorityQueue {
    private int listSize = 0;
    private Node top, bottom;

    public static class Node {
        int value, priority;
        Node next;

        Node (int v, int priority_) {
            value = v;
            priority = priority_;
            next = null;
        }
    }

    public void display(){
        Node tempNode = top;
        while (tempNode != null){
            System.out.print(tempNode.value + " <- ");
            tempNode = tempNode.next;
        }
        System.out.println("null\nTop: " + top.value);
    }

    public void enqueue(int val, int priority){
        Node newNode = new Node(val, priority);
        Node tempNode = top;
        if (top == null) bottom = top = newNode;
        else if (tempNode.priority < newNode.priority){
            newNode.next = top;
            top = newNode;
        } else {
            while (tempNode.next != null && tempNode.next.priority >= newNode.priority) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
        listSize++;
    }

    public int dequeue(){
        Node tempNode = top;
        top = top.next;
        listSize--;
        return tempNode.value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue list = new PriorityQueue();

        while (true) {
            System.out.println("\n[0]Exit\t\t[2]Dequeue");
            System.out.println("[1]Enqueue\t[3]Display Queue");

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
                    if (sc.hasNextInt()) {
                        int value = sc.nextInt();
                        System.out.print("Enter priority (higher index = higher priority): ");
                        if (sc.hasNextInt()) list.enqueue(value, sc.nextInt());
                        else System.out.println("Invalid input.");
                    } else {
                        System.out.println("Invalid value.");
                    }
                    break;
    
                case 2:
                    try { 
                        list.dequeue();
                    } catch (NullPointerException e) {
                        System.out.println("\nNo elements to remove.");
                    }
                    break;
    
                case 3:
                    try {
                        list.display();            
                    } catch (NullPointerException e) {
                        System.out.println("\nNo elements to display.");
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
