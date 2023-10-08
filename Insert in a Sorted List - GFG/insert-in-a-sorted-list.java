//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        if (head1 == null || head1.data > key) { //
            // Create a new node with 'key' as data
            Node head = new Node(key);
            // Set the next of the new node to the current head of the list
            head.next = head1;
            // Return the new node as the new head of the modified linked list
            return head;
        }

        // Initialize two pointers, prev and curr, to traverse the list
        Node prev = null;
        Node curr = head1;

        // Traverse the linked list to find the appropriate position for insertion
        while (curr != null && curr.data <= key) {
            prev = curr;
            curr = curr.next;
        }

        // If we reached the end of the list (curr == null), insert the new node at the end
        if (curr == null) {
            Node node = new Node(key);
            prev.next = node;
        } else {
            // Insert the new node between prev and curr
            Node node = new Node(key);
            prev.next = node;
            node.next = curr;
        }

        // Return the original head of the modified linked list
        return head1;
    }
}

 