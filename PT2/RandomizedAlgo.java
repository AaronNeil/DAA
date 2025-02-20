package PT2;

import java.util.Random;

public class RandomizedAlgo {

    // Method to perform randomized QuickSort
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex + 1, high);
        }
    }

    // Method to partition the array and select a random pivot
    private static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);
        swap(arr, pivotIndex, high);
        return partition(arr, low, high);
    }

    // Method to partition the array around the pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Method to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 2};
        int n = arr.length;

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        randomizedQuickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}