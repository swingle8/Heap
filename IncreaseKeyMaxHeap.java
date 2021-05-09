import java.util.*;
public class IncreaseKeyMaxHeap {
    public static void main (String[] args) {
        int [] arr = {9, 6, 8, 5, 2, 7, 4, 3};
        int n = arr.length; //8
        increasekey (arr, 6, 15);
        for (int i = 0 ; i < n ; i ++)
            System.out.print(arr[i] + " ");
    }


    public static int [] increasekey (int [] arr, int index, int value) {
        if (index < 0 || index >= arr.length)
            return arr;
        arr[index] += value;
        perculateUp(arr, index);

        return arr;
    }

    //No Recursion : space O(1) && Time = O(log N)
    public static void perculateUp (int [] arr, int index) {
        if (index <= 0)
            return;
        int parent = (index/2) - 1;
        while (parent >= 0 && arr[parent] < arr[index]) {
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
            index = parent;
            parent = (index/2) - 1;
        }
        
    }  
}