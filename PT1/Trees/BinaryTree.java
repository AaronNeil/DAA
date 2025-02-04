package PT1.Trees;
import java.util.Scanner;

public class BinaryTree {
    
    private static class Node {
        int value;
        Node left, right;
    
        Node(int v){
            value = v;
            left = right = null;
        }
    }

    public void display(){

    }

    public void insert(){
        
    }

    public void insertAtIndex(int index){

    }

    public void delete(){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput = 0;

        while (true) {
            System.out.println("Enter root node: ");
            if(sc.hasNextInt()) userInput = sc.nextInt();
            break;
        }
        Node rootNode = new Node(userInput);
        

        while (true) {
            System.out.println("\n\n[0]Exit\t\t\t[4]Replace key");
            System.out.println("[1]Insert key\t\t[6]Display all info");
            System.out.println("[2]Delete key\t\t[5]Get info on key based on index");
        }
        

    }
}
