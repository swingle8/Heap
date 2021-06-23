class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Data> pq = new PriorityQueue<Data>(Collections.reverseOrder());
        
        for (int i = 0 ; i < points.length ; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int val = (x*x) + (y*y); 
            if (pq.size() < k) {
                pq.add(new Data (Math.sqrt(val), x, y));
            }
            else if (pq.peek().val > Math.sqrt(val)) {
                pq.remove();
                pq.add(new Data (Math.sqrt(val), x, y));
            }
        }
        
        int [][] ans = new int[k][2];
        int i = 0;
        while (! pq.isEmpty()) {
            Data curr = pq.remove();
            ans[i][0] = curr.x;
            ans[i][1] = curr.y;
            i++;
        }
        
        return ans;
    }
    
}

class Data implements Comparable<Data> {
    double val;
    int x;
    int y;
    Data (double val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }
    
    public int compareTo (Data obj) {
        if (obj.val - this.val > 0)
            return -1;
        else if (obj.val - this.val < 0)
            return 1;
        return 0;
    }
}