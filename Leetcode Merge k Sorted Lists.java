/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        PriorityQueue<NodeVal> minHeap = new PriorityQueue<NodeVal>();
        for (int i = 0 ; i < lists.length ; i++) {
            if (lists[i] != null)
                minHeap.add (new NodeVal (lists[i], lists[i].val));
        }
        
        ListNode ans = null;
        ListNode head = null;
        
        while (! minHeap.isEmpty()) {
            NodeVal curr = minHeap.remove();
            if (head == null) {
                head = curr.node;
                ans = head;
            }
            else {
                head.next = curr.node;
                head = head.next;
            }
            
            if (curr.node.next != null) {
                minHeap.add(new NodeVal (curr.node.next, curr.node.next.val));
            }
        }
        
        
        return ans;
    }

class NodeVal implements Comparable<NodeVal> {
    ListNode node;
    int val;
    NodeVal (ListNode nv, int va) {
        node = nv;
        val = va;
    }
    
    public int compareTo (NodeVal obj) {
        return this.val - obj.val;
    }
}