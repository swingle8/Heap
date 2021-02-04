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
        int [] ans = new int [n];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i = 0 ; i < k ; i++) {
            q.add(arr[i]);
            if (i == k-1)
                ans[i] = q.peek();
            else
                ans[i] = -1;
        }
        
        int KSmallest = q.peek();
        for (int i = k ; i < n ; i++) {
            int currElem = arr[i];
            //System.out.println(q.peek());
            if (currElem >= KSmallest) {
                q.poll();
                
                q.add(currElem);
            }
            //System.out.println(q.peek());
            ans[i] = q.peek();
            KSmallest = ans[i];
        }
        return ans;
    }
};