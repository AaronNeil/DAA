import java.util.Scanner;

public class CircularLinkedList {
    private int listSize = 0;
    private Node head, tail;

    public static class Node {
        int value;
        Node next;

        Node (int v) {
            value = v;
            next = null;
        }

        Node (int v, Node next_){
            value = v;
            next = next_;
        }
    }

    public void display(){
        if (head == null){
            System.out.println("\nNo nodes to display");
            return;
        } 

        Node tempNode = head;
        System.out.print("\ntail -> ");
        do {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        } while (tempNode != head);
        if (head == null) System.out.println("No nodes to display");
        else System.out.println("head\nhead:" + head.value + "\ttail:" + tail.value + "\tlistSize:" + listSize);
    }

    public void createNewNode (int val) {
        Node newNode = new Node(val);

        if (head == null) head = newNode;
        else {
            Node tempNode = head;
            while (tempNode.next != head){
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;        
        }
        
        tail = newNode;             
        tail.next = head;                            
        listSize++;
    }

    public int deleteNewNode (){
        int val;
        if (listSize == 0){
            System.out.println("\nNo nodes to delete.");
            return -1;
        }

        if (listSize == 1){
            val = head.value;
            head = tail = null;
        } else {
            Node tempNode = head;
            for (int i = 0; i < (listSize - 2) ; i++) tempNode = tempNode.next;
            val = tail.value;
            tail = tempNode;
            tail.next = head;
        }
        listSize--;
        return val;
    }

    static boolean processInput(CircularLinkedList list, Scanner sc){
        System.out.println("\n\n[0]Exit\t\t\t[2]Delete last node");
        System.out.println("[1]Create node\t\t[3]Display all info");
        String userInput = sc.next();
        if (!userInput.matches("\\d+")) {
            System.out.println("Invalid input. Please enter a number.");
            return true;
        }

        int input = Integer.parseInt(userInput);
        if (input == 0) return false;
        if (input == 1) {
            System.out.print("Enter value to add: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input.");
                return true;
            }    
            list.createNewNode(sc.nextInt());
        }   
        if (input == 2) list.deleteNewNode();
        if (input == 3) list.display();
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
        while (true) {
            if (!processInput(list, sc)) break;
        }
        sc.close();
    }
}