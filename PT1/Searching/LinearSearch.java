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
        System.out.println("\nList: ");
        while (tempNode != null){
            System.out.print(tempNode.value + ", ");
            tempNode = tempNode.next;
        }
        if (head == null) System.out.println("No elements to display");
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

    public void search (int value){    
        int index = -1;        
        Node tempNode = head;

        if (listSize == 0) index = -1;
        else {
            for (int i = 0; i <= listSize - 1; i ++){
                if (tempNode.value == value) index = i;
                tempNode = tempNode.next;
            }
        }
        
        if (index == -1) System.out.println("\nNo elements exist with given value.");
        else System.out.println("The value is at index[" + index + "]");

    }

    static boolean processInput(LinearSearch list, Scanner sc){
        System.out.println("\n[0]Exit\t\t[2]Search based on value");
        System.out.println("[1]Create Node\t[3]Display list");
        
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
            list.insert(sc.nextInt());

        }
        if (input == 2) {
            System.out.print("Enter value to search: ");
            if (!sc.hasNextInt()){
                System.out.println("Invalid input.");
                return true;
            } 
            list.search(sc.nextInt());
        }
        if (input == 3) list.display();
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearSearch list = new LinearSearch();

        while (true) {
            if (!processInput(list, sc)) break;
        }
        sc.close();
    } 
}