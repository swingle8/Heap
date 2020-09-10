// 786. K-th Smallest Prime Fraction
// Hard

// 396

// 26

// Add to List

// Share
// A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.

// What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.

// Examples:
// Input: A = [1, 2, 3, 5], K = 3
// Output: [2, 5]
// Explanation:
// The fractions to be considered in sorted order are:
// 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
// The third fraction is 2/5.

// Input: A = [1, 7], K = 1
// Output: [1, 7]
// Note:

// A will have length between 2 and 2000.
// Each A[i] will be between 1 and 30000.
// K will be between 1 and A.length * (A.length - 1) / 2.




class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Tupple> heap = new PriorityQueue<Tupple>();
        for (int i = 0 ; i < A.length-1 ; i ++) {
            heap.add(new Tupple(i, A.length-1, (double) A[i]/A[A.length-1]));
        }
        
        for (int i = 0 ; i < K-1 ; i++) {
            Tupple smallest = heap.poll();
            if (smallest.y - smallest.x > 1)
                heap.add(new Tupple(smallest.x, smallest.y-1, (double) A[smallest.x]/A[smallest.y-1]));
        }
        
        Tupple ans = heap.poll();
        int [] XY = new int [2];
        XY[0] = A[ans.x];
        XY[1] = A[ans.y];
        return XY;
    }
}

public class Tupple implements Comparable<Tupple> {
    int x;
    int y;
    double fraction;
    
    public Tupple (int x, int y, double fraction) {
        this.x = x;
        this.y  = y;
        this.fraction = fraction; 
    }
    
    public int compareTo (Tupple that) {
        if (this.fraction < that.fraction)
            return -1;
        else if (this.fraction > that.fraction)
            return 1;
        else
            return 0;
    }
}