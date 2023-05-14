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
            long res = obj.findMaxSubsetSum(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    private static long recursive_approach(int[]arr,int index,int n){
        if(index>=n){
            return 0;
        }
        
        long take,notTake;
        
        take=arr[index]+recursive_approach(arr,index+1,n);
        notTake=(index+1>=n?0:arr[index+1]+ recursive_approach(arr,index+2,n));
        
        return Math.max(take,notTake);
    }
    private static long memoization_approach(int[] arr,int index,int n,long[] t){
        if(index>=n){
            return 0;
        }
        
        long take,notTake;
        
        if(t[index]!=-1){
            return t[index];
        }
        
        take=arr[index]+memoization_approach(arr,index+1,n,t);
        notTake=(index+1>=n?0:arr[index+1]+ memoization_approach(arr,index+2,n,t));
        
        return t[index]=Math.max(take,notTake);
    }
    
    private static long tabulation_approach(int[] arr,int n){
        long[] t=new long[n+2];
        long take,notTake;
        for(int i=n-1;i>=0;i--){
            take=arr[i]+t[i+1];
            notTake=(i+1>=n?0:arr[i+1]+t[i+2]);
            t[i]=Math.max(take,notTake);
        }
        return t[0];
    }
    
    private static long spaceOptimized_approach(int[] arr,int n){
        long take,notTake,prev_1,prev_2;
        prev_1=0;
        prev_2=0;
        
        for(int i=n-1;i>=0;i--){
            take=arr[i]+prev_1;
            notTake=(i+1>=n?0:arr[i+1]+prev_2);
            prev_2=prev_1;
            prev_1=Math.max(take,notTake);
        }
        
        return prev_1;
    }

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
        // return recursive_approach(A,0,N);
        
        // long[] t=new long[N];
        // for(int i=0;i<N;i++){
        //     t[i]=-1;
        // }
        // return memoization_approach(A,0,N,t);
        
        // return tabulation_approach(A,N);
        
        return spaceOptimized_approach(A,N);
        
    }
}   