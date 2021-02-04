import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases-- > 0) {
	        String s = sc.next();
	        GFG g = new GFG();
	        System.out.println(g.hasAdjacent(s));
	    }
	}
	
	public int hasAdjacent (String s) {
	    PriorityQueue<Node> q = new PriorityQueue<Node>();
	    int [] chars = new int[26];
	    
	    for (int i = 0 ; i < s.length() ; i ++)
	        chars[s.charAt(i) - 'a']++;
	        
	    for (int i = 0 ; i < 26 ; i++) {
	        if (chars[i] > 0)
	            q.add(new Node((char)(i+97), chars[i]));
	    }
	    
	    Node prev = new Node('*', -1);
	    StringBuffer sb = new StringBuffer();
	    while (! q.isEmpty()) {
	        Node curr = q.remove();
	        sb.append(curr.c);
	        curr.count--;
	        if (prev.count > 0)
	            q.add(prev);
	        
	        prev = curr;
	    }
	    
	    if (sb.toString().length() == s.length())
	        return 1;
	   return 0;
	}
}

class Node implements Comparable<Node>{
    char c;
    int count = 0;
    Node (char x, int counting) {
        c = x;
        count = counting;
    }
    
    public int compareTo (Node n) {
        if (n.count == count)
            return 0;
        if (n.count > count)
            return 1;
        else
            return -1;
    }
}