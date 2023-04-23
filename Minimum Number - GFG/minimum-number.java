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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimumNumber(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int GCD(int a, int b){
        if(a == 0) return b;
        return GCD(b%a, a);
    }
    public static int minimumNumber(int n, int[] arr) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0; i< n; i++) pq.add(arr[i]);
        // int first = Integer.MIN_VALUE, second= Integer.MIN_VALUE;
        // while(second!= 0){
        //     first = pq.poll();
        //     second = pq.poll();
        //     if(second == 0) break;
        //     pq.add(first-second);
        //     pq.add(second);
        // }
        // return first;
        int gcd  = arr[0];
        for(int i=1; i<n; i++){
            gcd = GCD(gcd, arr[i]);
        }
        return gcd;
    }
}