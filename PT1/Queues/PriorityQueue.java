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

    public void enqueue(int value, int priority){
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

    static boolean processInput(PriorityQueue list, Scanner sc){
        System.out.println("\n[0]Exit\t\t[2]Dequeue");
        System.out.println("[1]Enqueue\t[3]Display Queue");

        String userInput = sc.next();
        if (!userInput.matches("\\d+")) {
            System.out.println("Invalid input. Please enter a number.");
            return true;
        }

        int input = Integer.parseInt(userInput);
        if (input == 0) return false;
        if (input == 1) {
            System.out.print("Enter value to add: ");
            if (!sc.hasNextInt()){
                System.out.println("Invalid input.");
                return true;
            }
            int value = sc.nextInt();
            System.out.print("Enter priority: ");
            if (!sc.hasNextInt()){
                System.out.println("Invalid input.");
                return true;
            }
            int priority = sc.nextInt();
            list.enqueue(value, priority);
        }
        if (input == 2) list.dequeue();
        if (input == 3) list.display();
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue list = new PriorityQueue();

        while (true) {
            if (!processInput(list, sc)) break;
        }
        sc.close();
    }
}