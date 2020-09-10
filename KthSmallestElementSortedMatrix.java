// 378. Kth Smallest Element in a Sorted Matrix
// Medium

// 2671

// 143

// Add to List

// Share
// Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

// Note that it is the kth smallest element in the sorted order, not the kth distinct element.

// Example:

// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,

// return 13.
// Note:
// You may assume k is always valid, 1 ≤ k ≤ n2.




class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Elem> heap = new PriorityQueue<Elem>();
        
        for (int i = 0 ; i < rows ; i ++)
            heap.add(new Elem(i, 0, matrix[i][0]));
        
        for (int i = 0 ; i < k-1 ; i++) {
            Elem smallest = heap.poll();
            if (smallest.y == cols-1)
                continue;
            
            heap.add(new Elem(smallest.x, smallest.y+1, matrix[smallest.x][smallest.y+1]));
        }
        
        return heap.poll().val;
    }
}


public class Elem implements Comparable<Elem>{
    int val;
    int x;
    int y;
    
    public Elem (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    public int compareTo (Elem o1) {
        return this.val-o1.val;
    }
}
