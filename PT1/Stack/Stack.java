import java.util.Scanner;


public class Stack {
    private Node top;

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
        if (top == null) System.out.println("No elements to display.");
        else System.out.println("null\nTop: " + top.value);
    }

    public void push(int val){
        Node newNode = new Node(val);
        if (top == null) top = newNode;
        else{
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop(){
        if (top == null){
            System.out.println("\nNo elements to pop.");
            return -1;
        }
        Node tempNode = top;
        top = top.next;
        return tempNode.value;
    }

    static boolean processInput(Stack list, Scanner sc){
        System.out.println("\n[0]Exit\t\t[2]Pop");
        System.out.println("[1]Push\t\t[3]Display Stack");

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
            list.push(sc.nextInt());
        }
        if (input == 2) list.pop();
        if (input == 3) list.display();
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack list = new Stack();

        while (true) {
            if (!processInput(list, sc)) break;
        }
        sc.close();
    }
}