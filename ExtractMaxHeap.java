import java.util.*;
public class ExtractMaxHeap {
    public static void main (String[] args) {
        ArrayList<Integer> list = new ArrayList<> (Arrays.asList(9, 6, 8, 5, 2, 7, 4, 3));
        int n = list.size();
        list = extractMax (list, n);
        n = list.size();
        for (int i = 0 ; i < n ; i ++)
            System.out.print(list.get(i) + " ");
    }


    public static ArrayList<Integer> extractMax (ArrayList<Integer> list, int n) {
        if (n <= 0)
            return list;
        System.out.println(list.get(0));

        if (n == 1) {
            list.remove(0);
            return list;
        }
        
        list.remove(0);
        list.add(0, list.remove(n-2));
        MaxHeapify (list, 0); // O(log N)
        return list;
    }

    public static void MaxHeapify (ArrayList<Integer> arr, int index) {
        int leftChild = 2*index + 1;
        int rightChild = 2*index + 2;
        int max = index;

        if (leftChild < arr.size() && arr.get(leftChild) > arr.get(max))
            max = leftChild;
        if (rightChild < arr.size() && arr.get(rightChild) > arr.get(max))
            max = rightChild;
        if (max != index) {
            int temp = arr.get(max);
            arr.remove(max);
            arr.add(max, arr.get(index));
            arr.remove(index);
            arr.add(index, temp);
            MaxHeapify (arr, max);
        }
    }

}