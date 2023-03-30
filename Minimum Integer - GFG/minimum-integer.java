//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.minimumInteger(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
   public static int minimumInteger(int N, int[] A) {
        // code here
        long sum =0; 
        // from here we get the minimum value
        int ans = Integer.MAX_VALUE;
        
        // calculating sum
        for(int i=0; i<A.length; i++){
            sum+=A[i];
        }
        // comparin the sum  with the given cond
        for(int i=0; i<N; i++){
            if(sum<=(long)N*A[i]){
                ans=Math.min(ans,A[i]);
            }
        }
        return ans;
    }
}     
