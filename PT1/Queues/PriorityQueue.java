package PT1.Queues;

import java.util.Scanner;

public class PriorityQueue {
    private Node top;

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
        if (top == null) System.out.println("\nNo elements to display");
        else System.out.println("null\nTop: " + top.value);
    }

    public void enqueue(Scanner sc){
        int value, priority;
        
        System.out.print("Enter value to add: ");
        if (sc.hasNextInt()) {
            value = sc.nextInt();
            System.out.print("Enter priority (higher index = higher priority): ");
            if (sc.hasNextInt()){
                priority = sc.nextInt();
            }
            else {
                System.out.println("Invalid input.");
                return;
            }
        } else {
            System.out.println("Invalid value.");
            return;
        }
 
        Node newNode = new Node(value, priority);
        Node tempNode = top;
        if (top == null) top = newNode;
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
    }

    public int dequeue(){
        if (top == null){
            System.out.println("\nNo elements to pop.");
            return -1;
        }
        
        Node tempNode = top;
        top = top.next;
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
            if (input == 1) list.enqueue(sc);
            if (input == 2) list.dequeue();
            if (input == 3) list.display();
        }
        sc.close();
    }
}