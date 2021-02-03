//Build max Heap
//input = [1, 2, 3, 4, 56, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]
// output = [17, 16, 15, ]

import java.util.*;
public class Heap {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int [] arr = new int[len];
        for (int i = 0 ; i < len ; i++)
            arr[i] = sc.nextInt();

        Heap heap = new Heap();
        heap.buildHeap (arr, len);
        heap.displayMaxHeap(arr);
    }

    public void buildHeap (int [] arr, int len) {
        int nonRootIndex = (len-2)/2;
        for (int i = nonRootIndex ; i >= 0 ; i --) {
            heapify(arr, len, i);
            //displayMaxHeap (arr);
        }
    }

    public void heapify (int [] arr, int len, int i) {
        int leftChild = (2*i)+1;
        int rightChild = (2*i)+2;
        int max = i;
        
        if (leftChild < len && arr[leftChild] > arr[max])
            max = leftChild;

        if (rightChild < len && arr[rightChild] > arr[max])
            max = rightChild;

        if (i != max) {
            int data = arr[i];
            arr[i] = arr[max];
            arr[max] = data;
            heapify (arr, len, max);
        }
    }

    public void displayMaxHeap (int [] arr) {
        int len = arr.length;
        for (int i = 0 ; i < len ; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}