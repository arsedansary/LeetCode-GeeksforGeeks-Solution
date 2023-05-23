//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    private Node dfs(int arr1[],int arr2[],int s1,int e1,int s2,int e2){
        
        Node node= new Node(arr1[s1]);
        int m1,m2,c1,c2;
        
        if(s1+1>e1){
            return node;
        }
        
        c1=s1+1;
        c2=s2+1;
        
        for(;c1<=e1;c1++){
            if(arr2[s2+1]==arr1[c1]){
                break;
            }
        }
        for(;c2<=e2;c2++){
            if(arr1[s1+1]==arr2[c2]){
                break;
            }
        }
        
        node.left= dfs(arr1,arr2,s1+1,c1-1,c2,e2);
        node.right = dfs(arr1,arr2,c1,e1,s2+1,c2-1);
        
        return node;
    }
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        return dfs(pre,preM,0,size-1,0,size-1);
    }
    
}