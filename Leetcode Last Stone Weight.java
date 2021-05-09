//https://leetcode.com/problems/last-stone-weight/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0 ; i < stones.length ; i++)
                heap.add(stones[i]);
        
        while (heap.size() > 1) {
            int num1 = heap.remove();
            int num2 = heap.remove();
            int diff = Math.abs(num1 - num2);
            if (diff > 0)
                heap.add(diff);
        }
        
        if (heap.size() == 0)
            return 0;
        return heap.remove();
    }
}