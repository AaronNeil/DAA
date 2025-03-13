import java.util.Scanner;

public class SimpleQueue {
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
        if (top == null) System.out.println("\nNo elements to display");
        else System.out.println("null\nTop: " + top.value);
    }

    public void enqueue(int val){
        Node newNode = new Node(val);
        if (top == null) top = newNode;
        else bottom.next = newNode;
        bottom = newNode;
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

    static boolean processInput(SimpleQueue list, Scanner sc){
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
            list.enqueue(sc.nextInt());
        }
        if (input == 2) list.dequeue();
        if (input == 3) list.display();
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleQueue list = new SimpleQueue();

        while (true) {
            if (!processInput(list, sc)) break;
        }
        sc.close();
    }
}