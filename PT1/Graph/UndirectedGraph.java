import java.util.*;

public class UndirectedGraph {

    public static void addEdge(Map<Integer, List<Integer>> adj, int src, int dest) {
        adj.putIfAbsent(src, new ArrayList<>());
        adj.putIfAbsent(dest, new ArrayList<>());
        adj.get(src).add(dest);
        adj.get(dest).add(src);
        System.out.println("Edge added between " + src + " and " + dest);
    }

    public static void display(Map<Integer, List<Integer>> adj) {
        System.out.println("Adjacency List Representation:");
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int val : entry.getValue()) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static boolean processInput(Map<Integer, List<Integer>> adj, Scanner sc) {
        System.out.println("\n[0]Exit\t\t[2]Display adjacency list");
        System.out.println("[1]Add Edge");

        String userInput = sc.next();
        if (!userInput.matches("\\d+")) {
            System.out.println("Invalid input. Please enter a number.");
            return true;
        }

        int input = Integer.parseInt(userInput);
        if (input == 0) return false;
        if (input == 1) {
            System.out.print("Enter source vertex: ");
            if (!sc.hasNextInt()){
                System.out.println("Invalid input. Please enter an integer.");
                return true;
            }
            int src = sc.nextInt();

            System.out.print("Enter destination vertex: ");  
            if (!sc.hasNextInt()){
                System.out.println("Invalid input. Please enter an integer.");
                return true;
            } 
            int dest = sc.nextInt();
            
            addEdge(adj, src, dest);
        }
        if (input == 2) display(adj);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, List<Integer>> adj = new HashMap<>();

        while (true) {
            if (!processInput(adj, sc)) break;
        }
        sc.close();
    }
}