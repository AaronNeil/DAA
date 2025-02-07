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

    public static void insert(Scanner sc){
        int userInput = 0;
        while (true) {
            System.out.println("Enter root node: ");
            if(sc.hasNextInt()) userInput = sc.nextInt();
            break;
        }
        Node rootNode = new Node(userInput);
    }

    public void delete(){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree list = new BinaryTree();
        
        

        while (true) {
            System.out.println("\n\n[0]Exit\t\t\t[2]Delete key");
            System.out.println("[1]Insert key(s)");

            String userInput = sc.next();
            if (!userInput.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            int input = Integer.parseInt(userInput);
            if (input == 0) break;

            switch (input) {
                case 1:
                    // try {
                        insert(sc);
                    // } catch (){

                    // }
                    break;
            
                default:
                System.out.println("Invalid choice.");
                    break;
            }
        }
        

    }
}
