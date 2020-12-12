class MedianFinder {

    PriorityQueue<Integer> min;
    int totalMinCount;
    PriorityQueue<Integer> max;
    int totalMaxCount;
    
    public MedianFinder() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
        totalMinCount = 0;
        totalMaxCount = 0;
    }
    
    public void addNum(int num) {
        if (totalMinCount == 0) {
            min.add(num);
            totalMinCount++;
        }
        else {
            int minHeapVal = min.peek();
            if (minHeapVal <= num) {
                min.add(num);
                totalMinCount++;
            }
            else {
                max.add(num);
                totalMaxCount++;
            }
        }
        
        rearrageHeaps();
    }
    
    public double findMedian() {
        if ((totalMinCount + totalMaxCount) % 2 == 0) {
            int minVal = min.peek();
            int maxVal = max.peek();
            return (double)(maxVal + minVal)/2;
        }
        
        return min.peek();
            
    }
    
    public void rearrageHeaps () {
        if (totalMinCount == totalMaxCount || totalMinCount - 1 == totalMaxCount)
            return;
        if (totalMinCount > totalMaxCount) {
            int minData = min.remove();
            totalMinCount--;
            max.add(minData);
            totalMaxCount++;
        }
        
        else {
            int maxData = max.remove();
            totalMaxCount--;
            min.add(maxData);
            totalMinCount++;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */