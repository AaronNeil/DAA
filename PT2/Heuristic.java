package PT2;

import java.util.*;

public class Heuristic {

    static class Node {
        int x, y;
        int cost, heuristic;
        Node parent;

        Node(int x, int y, int cost, int heuristic, Node parent) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.heuristic = heuristic;
            this.parent = parent;
        }
    }

    public static List<Node> aStar(int[][] grid, Node start, Node goal) {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost + a.heuristic));
        Set<Node> closedList = new HashSet<>();
        openList.add(start);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            if (current.x == goal.x && current.y == goal.y) {
                return constructPath(current);
            }

            closedList.add(current);

            for (Node neighbor : getNeighbors(grid, current)) {
                if (closedList.contains(neighbor)) {
                    continue;
                }

                int tentativeCost = current.cost + 1; // Assuming uniform cost for simplicity

                if (!openList.contains(neighbor) || tentativeCost < neighbor.cost) {
                    neighbor.cost = tentativeCost;
                    neighbor.heuristic = heuristic(neighbor, goal);
                    neighbor.parent = current;

                    if (!openList.contains(neighbor)) {
                        openList.add(neighbor);
                    }
                }
            }
        }

        return Collections.emptyList(); // No path found
    }

    private static List<Node> getNeighbors(int[][] grid, Node node) {
        List<Node> neighbors = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = node.x + dx[i];
            int newY = node.y + dy[i];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                neighbors.add(new Node(newX, newY, node.cost + 1, 0, node));
            }
        }

        return neighbors;
    }

    private static int heuristic(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y); // Manhattan distance
    }

    private static List<Node> constructPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
        };

        Node start = new Node(0, 0, 0, 0, null);
        Node goal = new Node(0, 4, 0, 0, null);

        List<Node> path = aStar(grid, start, goal);

        if (!path.isEmpty()) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}