package PT1.Trees;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static Node rootNode; 
    
        private static class Node {
            int value;
            Node left, right;
        
            Node(int v){
                value = v;
                left = right = null;
            }
        }
    
        public void display(){
            if (rootNode == null) {
                System.out.println("Tree is empty.");
                return;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(rootNode);
            int level = 0;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                System.out.print(level == 0 ? "root: " : "level " + level + ": ");

                for (int i = 0; i < levelSize; i++) {
                    Node current = queue.poll();
                    System.out.print(current.value + (i < levelSize - 1 ? ", " : ""));
            
                    if (current.left != null) queue.add(current.left);
                    if (current.right != null) queue.add(current.right);
                }
                System.out.println();
                level++;
            }
        }
    
        public void insert(Scanner sc){
            int userInput = 0;
            while (true) {
                System.out.println("Enter root node: ");
                if(sc.hasNextInt()) userInput = sc.nextInt();
                break;
            }
            rootNode = new Node(userInput);
            insert(sc, rootNode);
        }
    
        public void insert (Scanner sc, Node node){
            boolean left = false, right = false;
            int value = 0;
            
            System.out.print("\nDo you want to enter left of " + node.value + " [true / false]: ");
            if (sc.hasNextBoolean()) left = sc.nextBoolean();
            else {
                System.out.println("Invalid input");
                System.exit(0);
            }
            if (left) {
                System.out.print("Enter the value of the left of " + node.value + ": ");
                if (sc.hasNextInt()) value = sc.nextInt();
                else{
                    System.out.println ("Invalid input");
                    System.exit(0);
                }
                node.left = new Node(value);
                display();
                insert(sc, node.left);
            }
    
            System.out.print("\nDo you want to enter right of " + node.value + " [true / false]: ");
            if (sc.hasNextBoolean()) right = sc.nextBoolean();
            else {
                System.out.println ("Invalid input");
                System.exit(0);
            }
            if (right) {
                System.out.print("Enter the value of the right of " + node.value + ": ");
                if (sc.hasNextInt()) value = sc.nextInt();
                else{
                    System.out.println ("Invalid input");
                    System.exit(0);
                }
                node.right = new Node(value);
                display();
                insert(sc, node.right);
            }
        }

    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            BinaryTree list = new BinaryTree();
    
            while (true) {
                System.out.println("\n\n[0]Exit\t\t\t[2]Display tree");
                System.out.println("[1]Insert key(s)");
    
                String userInput = sc.next();
                if (!userInput.matches("\\d+")) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                int input = Integer.parseInt(userInput);
                if (input == 0) break;
                if (input == 1) list.insert(sc);
                if (input == 2) list.display();
        }
        sc.close();
    }
}
