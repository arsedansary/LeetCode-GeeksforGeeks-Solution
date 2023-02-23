//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
   static final int mod=1000000007;
    
    static int recurse(int i,int j,int n,int m,int[][]arr,int[][]dp)
    {
        //Base Cases
        
        // If We Get Out Of The Array, We Return 0
        if(i>n || j>m || arr[i][j]==0)
            return 0;
        
        // If We Reach The Last Cell, We Return 1 As In 1 Way To Reach Last Cell Found
        if(i==n && j==m)
            return 1;
            
        // If DP Array At Current Cell Doesn't Have A Default Value, It Means We Can Use The Previous Result
        if(dp[i][j]!=-1)
            return (dp[i][j])%mod;
        
        // If Not, We Store The Current Result In The DP Array
        dp[i][j] = (recurse(i,j+1,n,m,arr,dp)+recurse(i+1,j,n,m,arr,dp))%mod;
        
        return (dp[i][j])%mod;
    }
    
    static int uniquePaths(int n, int m, int[][] grid) {
        
        // If First Or Last Cell Is 0, Meaning We Can't Reach The Last Cell, So Return 0 Ways
        if(grid[0][0]==0 || grid[n-1][m-1]==0)
            return 0;
        
        // Initializing 2D DP Array
        int dp[][]=new int[n+1][m+1];
        
        // Filling DP Array With -1 Default Value 
        for(int[]temp:dp)
            Arrays.fill(temp,-1);
        
        // Returning The Answer From Recurse Function
        return (recurse(0,0,n-1,m-1,grid,dp))%mod;
        
    }
};