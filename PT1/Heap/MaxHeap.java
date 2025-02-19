package PT1.Heap;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxHeap {

    public static void insert(LinkedList<Integer> heap, Scanner sc) {
        int value;

        System.out.print("Enter value to insert: ");
        if (sc.hasNextInt()) {
            value = sc.nextInt();
            System.out.println("Inserted " + value + " into the max-heap.");
        } else {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0 && heap.get((index - 1) / 2) < heap.get(index)) {
            int temp = heap.get((index - 1) / 2);
            heap.set((index - 1) / 2, heap.get(index));
            heap.set(index, temp);
            index = (index - 1) / 2;
        }
    }

    public static void display(LinkedList<Integer> heap) {
        if (heap.isEmpty()) {
            System.out.println("The heap is empty.");
            return;
        }
        System.out.print("Current max-heap: ");
        for (int val : heap) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> heap = new LinkedList<>();

        while (true) {
            System.out.println("\n\n[0]Exit\t\t[2]Display heap");
            System.out.println("[1]Insert Value");
            
            String userInput = sc.next();
            if (!userInput.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
    
            int input = Integer.parseInt(userInput);
            if (input == 0) break;
            if (input == 1) insert(heap, sc);
            if (input == 2) display(heap);
        }
        sc.close();
    }
}