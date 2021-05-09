public class decreaseKeyMaxHeap {
    public static void main (String[] args) {
        int [] arr = {9, 6, 8, 5, 2, 7, 4, 3};
        int n = arr.length; //8
        decreasekey (arr, 0, 15);
        for (int i = 0 ; i < n ; i ++)
            System.out.print(arr[i] + " ");
    }


    public static int [] decreasekey (int [] arr, int index, int value) {
        if (index < 0 || index >= arr.length)
            return arr;
        arr[index] -= value;
        MaxHeapify(arr, index);

        return arr;
    }

    //time = O(log N) space = O(log N)
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