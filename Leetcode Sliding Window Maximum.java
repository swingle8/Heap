class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        PriorityQueue<IndexVal> MaxHeap = new PriorityQueue<IndexVal>(Collections.reverseOrder());
        for (int i = 0 ; i < k ; i++) {
            IndexVal iv = new IndexVal (i, nums[i]);
            MaxHeap.add (iv);
        }
        
        int [] ans = new int[n-k+1];
        int i = 0;
        int j = k;
        while (i < n-k+1) {
            IndexVal top = MaxHeap.peek();
            int topIndex = top.index;
            if (topIndex < i)
                 MaxHeap.remove();
            else {
                ans[i] = top.val;
                i++;
                if (j < n) {
                    MaxHeap.add (new IndexVal(j, nums[j]));
                    j++;
                }
            }
        }
        return ans;
    }
}

class IndexVal implements Comparable<IndexVal> {
    int val;
    int index;
    IndexVal (int i, int v) {
        index = i;
        val = v;
    }
    
    public int compareTo (IndexVal obj) {
        return this.val - obj.val;
    }
}