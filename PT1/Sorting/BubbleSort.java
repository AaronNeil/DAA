package PT1.Sorting;

import java.util.Scanner;;

public class BubbleSort {
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

    public void insert (int value){
        Node newNode = head;

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
    
    public void sort (){
        Node tempNode = head;
        Node nextTempNode;
        boolean swapped;
        for (int i = 0; i < listSize - 1; i++){
            swapped = false;
            for (int j = 0; i < listSize - i - 1; j++){
                if (tempNode.value > tempNode.next.value){
                    nextTempNode.value = tempNode.next.value;

                }
            }
        }
    }
}
