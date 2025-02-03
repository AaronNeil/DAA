package PT1.Stack;
import java.util.Scanner;


public class Stack {
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
        Node tempNode = bottom;
        while (tempNode != null){
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null\nTop: " + top.value);
    }

    public void push(int val){
        Node newNode = new Node(val);
        if (top == null) bottom = top = newNode;
        else{
            top.next = newNode;
            top = newNode;
        }
        listSize++;
    }

    public int pop(){
        Node tempNode = bottom;
        for (int i = 0; i < (listSize - 2) ; i++) tempNode = tempNode.next;
        if (listSize == 1) {
            top = bottom = null;
            return tempNode.value;
        } else {
            int val = tempNode.next.value; 
            tempNode.next = null;
            top = tempNode;
            listSize--;
            return val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack list = new Stack();

        while (true) {
            System.out.println("\n[0]Exit\t\t[2]Pop");
            System.out.println("[1]Push\t\t[3]Display Stack");

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
                    if (sc.hasNextInt()) list.push(sc.nextInt());
                    else System.out.println("Invalid input.");
                    break;
    
                case 2:
                    try { 
                        list.pop();
                    } catch (NullPointerException e) {
                        System.out.println("\nNo keys to remove.");
                    }
                    break;
    
                case 3:
                    try {
                        list.display();            
                    } catch (NullPointerException e) {
                        System.out.println("\nNo keys to display.");
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