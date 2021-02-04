// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Merge g = new Merge();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Merge
{
    Node mergeKList(Node[]a,int N)
    {
        if (N == 1)
            return a[0];
        
        Node prev = mergeTwoList (a[0], a[1]);
        for (int i = 2; i < N ; i++) {
            prev = mergeTwoList (prev, a[i]);
        }
        return prev;
    }
    
    Node mergeTwoList (Node a, Node b) {
        Node ans = null;
        if (a.data < b.data) {
            ans = a;
            a = a.next;
        }
        else {
            ans = b;
            b = b.next;
        }
        Node head = ans;
        
        while (a != null && b != null) {
            if (a.data < b.data) {
                head.next = a;
                a = a.next;
                head = head.next;
            }
            else {
                head.next = b;
                b = b.next;
                head = head.next;
            }
        }
        
        if (a != null)
            head.next = a;
        if (b != null)
            head.next = b;
            
        return ans;
    }   
}
