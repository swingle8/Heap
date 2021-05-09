class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length ; i++) {
            if (! map.containsKey(nums[i]))
                map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }
        
        PriorityQueue<KeyVal> minHeap = new PriorityQueue<KeyVal>();
        for (int ke : map.keySet()) {
            int val = map.get(ke);
            KeyVal current = new KeyVal(ke, val);
            if (minHeap.size() < k) {
                minHeap.add(current);
            }
            else if (minHeap.peek().val < val){
                minHeap.remove();
                minHeap.add(current);
            }
        }
        
        int [] ans = new int[minHeap.size()];
        int x = 0;
        while (! minHeap.isEmpty()) {
            KeyVal now = minHeap.remove();
            ans[x] = now.key;
            x++;
        }
        
        return ans;
    }
}
class KeyVal implements Comparable<KeyVal>{
    int key;
    int val;
    KeyVal (int k, int v) {
        key = k;
        val = v;
    }
            
    public int compareTo (KeyVal obj) {
        return this.val - obj.val;
    }
}