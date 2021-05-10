// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int k = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int[] arr = new int[n];
            
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            int[] ptr = ob.kthLargest(k,arr,n);
            for(int i=0; i<n; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int [] ans = new int[n];
        for (int i = 0 ; i < k ; i++) {
            minHeap.add(arr[i]);
            if (i < k-1)
                ans[i] = -1;
            else
                ans[i] = minHeap.peek();
        }
        
        for (int i = k ; i < n ; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(arr[i]);
            }
            ans[i] = minHeap.peek();    
        }
        
        return ans;
    }
};