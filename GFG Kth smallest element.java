// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0 ; i < k ; i++)
            maxheap.add(arr[i]);
        
        for (int i = k ; i < arr.length ; i++) {
            if (arr[i] < maxheap.peek()) {
                maxheap.remove();
                maxheap.add(arr[i]);
            }
        }
        
        return maxheap.poll();
    } 
}
