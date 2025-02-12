package PT1.Queues;

import java.util.Scanner;

public class SimpleQueue {
    private int listSize = 0;
    private Node top, bottom;

    public static class Node {
        int value;
        Node next;

        Node (int v) {
            value = v;
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

    public void enqueue(int val){
        Node newNode = new Node(val);
        if (top == null) bottom = top = newNode;
        else{
            bottom.next = newNode;
            bottom = newNode;
        }
        listSize++;
    }

    public int dequeue(){
        Node tempNode = top;
        if (listSize == 1) {
            top = bottom = null;
            listSize--;
            return tempNode.value;
        } else {
            int val = tempNode.value;
            top = tempNode.next;
            tempNode.next = null;
            listSize--;
            return val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleQueue list = new SimpleQueue();

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
                    if (sc.hasNextInt()) list.enqueue(sc.nextInt());
                    else System.out.println("Invalid input.");
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
