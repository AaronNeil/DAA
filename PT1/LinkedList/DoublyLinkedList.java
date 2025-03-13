import java.util.Scanner;

public class DoublyLinkedList {
    private int listSize = 0;
    private Node head, tail;

    public static class Node {
        int value;
        Node next, prev;

        Node (int v) {
            value = v;
            next = null;
            prev = null;
        }

        Node (int v, Node next_) {
            value = v;
            next = next_;
            prev = null;
        }

        Node (int v, Node next_, Node prev_){
            value = v;
            next = next_;
            prev = prev_;
        }
    }
    
    public void display(){
        Node tempNode = head;
        System.out.print(tempNode != null ? "\nnull <-" : "\n");
        while (tempNode != null){
            System.out.print(" " + tempNode.value + " -");
            tempNode = tempNode.next;
        }
        if (head == null) System.out.println("No nodes to display");
        else System.out.println("> null\nhead:" + head.value + "\ttail:" + tail.value + "\tlistSize:" + listSize);
    }
    
    public void createNewNode (int val) {
        Node newNode = new Node(val);

        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;            
            newNode.prev = tail;
            tail = newNode;
        }
        listSize++;       
    }

    public int deleteNewNode (){
        if (listSize == 0){
            System.out.println("\nNo nodes to delete.");
            return -1;
        } 
        
        int val;
        if (listSize == 1){
            val = head.value;
            head = tail = null;
        }
        else{
            val = tail.value;
            tail = tail.prev;
            tail.next = null;
        }
        listSize--;
        return val;
    }

    static boolean processInput(DoublyLinkedList list, Scanner sc){
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
        boolean n = true; 
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            if (!processInput(list, sc)) break;
        }
        sc.close();
    }
}