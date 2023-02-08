//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine().trim());
        while(T>0)
        {
            String s[]=in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[][] a = new int[k][2];
            for(int i=0; i<k; i++){
                s=in.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
            }
            Solution g = new Solution();
            long[] res = g.countZero(n,k,a);
            
            for(int i=0; i<res.length; i++){
                out.print(res[i]+" ");
            }
            out.println();
            T--;
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    long[] countZero(int N, int K, int[][] arr){
        // code here
        long freeCells = N*N;
        boolean[] filledRows = new boolean[N];
        boolean[] filledCols = new boolean[N];
        int rowCount = 0 , colCount = 0;
        long[] ans = new long[K];
        
        for(int i = 0 ; i < K ; i++){
            
            int row = arr[i][0];
            int col = arr[i][1];
            
            //if it is a new row to be filled
            if(!filledRows[row-1]){
                freeCells -= (N-colCount);
                filledRows[row-1] = true;
                rowCount++;
            }
            
            //if it is a new col to be filled
            if(!filledCols[col-1]){
                freeCells -= (N-rowCount);
                filledCols[col-1] = true;
                colCount++;
            }
            
            //remaining freeCells after filling row and col
            ans[i] = freeCells;
        }
        return ans;
    }
}