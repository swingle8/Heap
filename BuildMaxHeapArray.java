public class BuildMaxHeapArray {
    public static void main (String[] args) {
        int [] arr = {2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        buildMaxHeap (arr, n);
        for (int i = 0 ; i < n ; i ++)
            System.out.print(arr[i] + " ");
    }


    public static int [] buildMaxHeap (int [] arr, int n) {
        int leafNodeStartIndex =  n/2;
        
        for (int i = leafNodeStartIndex-1 ; i >= 0 ; i--) {
            MaxHeapify(arr, i);
        }

        return arr;
    }

    public static void MaxHeapify (int [] arr, int index) {
        int leftChild = 2*index + 1;
        int rightChild = 2*index + 2;
        int max = index;

        if (leftChild < arr.length && arr[leftChild] > arr[max])
            max = leftChild;
        if (rightChild < arr.length && arr[rightChild] > arr[max])
            max = rightChild;
        if (max != index) {
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            MaxHeapify (arr, max);
        }
    }

}