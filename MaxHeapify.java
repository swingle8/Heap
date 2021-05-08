public void MaxHeapify (int [] arr, int index) {
    int big = index;
    int leftChild = 2*index+1;
    int rightChild = 2*index+2;

    if (leftChild < arr.length && arr[leftChild] > arr[big])
        big = leftChild;
    if (rightChild < arr.length && arr[rightChild] > arr[big])
        big = rightChild;
    if (big != index) {
        int temp = arr[big];
        arr[big] = arr[index];
        arr[index] = temp;
        MaxHeapify (arr, big);
    }
}