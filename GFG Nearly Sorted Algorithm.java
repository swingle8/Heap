//https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases -- > 0 ) {
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int [] arr = new int[n];
	        for (int i = 0 ; i < n ; i ++)
	            arr[i] = sc.nextInt();
	        
	        arr = sortCompletely (arr, n, k);
	        for (int i = 0 ; i < n ; i++)
	            System.out.print (arr[i] + " ");
	        
	        System.out.println();
	    }
	}
	
	public static int[] sortCompletely (int [] arr, int n, int k) {
	    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	    for (int i = 0 ; i < k ; i++) {
	        minHeap.add(arr[i]);
	    }
	   
	    int [] ans = new int [n];
	    int j = 0;
	    int i = k;
	    while (! minHeap.isEmpty()) {
	        int val = minHeap.remove();
	        
	        ans[j] = val;
	        j++;
	        
	        if (i < n) {
	            minHeap.add(arr[i]);
	            i++;
	        }
	    }
	    
	    return ans;
	}
}