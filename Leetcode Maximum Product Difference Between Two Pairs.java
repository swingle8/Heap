5797. Maximum Product Difference Between Two Pairs

class Solution {
    public int maxProductDifference(int[] nums) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0 ; i < nums.length ; i++) {
            maxHeap.add (nums[i]);
        }
        
        int maxProd = maxHeap.remove() * maxHeap.remove();
        
        while (! maxHeap.isEmpty())
            minHeap.add(maxHeap.remove());
        
        int minProd = minHeap.remove() * minHeap.remove();
        
        return maxProd - minProd;
    }
}