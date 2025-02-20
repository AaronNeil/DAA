package PT2;
import java.util.*;

public class BranchAndBound {

    static class Node {
        int level;
        int cost;
        int[] path;
        boolean[] visited;

        Node(int level, int cost, int[] path, boolean[] visited) {
            this.level = level;
            this.cost = cost;
            this.path = path.clone();
            this.visited = visited.clone();
        }
    }

    public static int tsp(int[][] graph) {
        int n = graph.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        int[] initialPath = new int[n + 1];
        boolean[] initialVisited = new boolean[n];
        initialVisited[0] = true;
        Node root = new Node(0, 0, initialPath, initialVisited);
        pq.add(root);

        int minCost = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.level == n - 1) {
                int finalCost = current.cost + graph[current.path[current.level]][0];
                if (finalCost < minCost) {
                    minCost = finalCost;
                    current.path[n] = 0;
                    System.out.println("Path: " + Arrays.toString(current.path) + " Cost: " + finalCost);
                }
                continue;
            }

            for (int i = 1; i < n; i++) {
                if (!current.visited[i]) {
                    int[] newPath = current.path.clone();
                    boolean[] newVisited = current.visited.clone();
                    newPath[current.level + 1] = i;
                    newVisited[i] = true;
                    int newCost = current.cost + graph[current.path[current.level]][i];
                    Node child = new Node(current.level + 1, newCost, newPath, newVisited);
                    pq.add(child);
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int minCost = tsp(graph);
        System.out.println("Minimum cost: " + minCost);
    }
}