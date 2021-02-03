// { Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            hs.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    public void heapSort(int arr[], int n)
    {
        GfG g = new GfG();
        g.buildHeap(arr, n);
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            g.heapify(arr, i, 0);
        }
    }
}


// } Driver Code Ends


class GfG
{
    void buildHeap(int arr[], int n)
    {
        int nodeHavingChild = n/2 - 1;
        for (int i = nodeHavingChild ; i >= 0 ; i--) {
            heapify (arr, n, i);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
       int leftChild = i*2 + 1;
       int rightChild = i*2 + 2;
       int max = i;
       if (leftChild < n && arr[leftChild] > arr[max])
            max = leftChild;
       if (rightChild < n && arr[rightChild] > arr[max])
            max = rightChild;
        
        if (i != max) {
            int num = arr[i];
            arr[i] = arr[max];
            arr[max] = num;
            heapify (arr, n, max);
        }
        
    }
 }
 
 