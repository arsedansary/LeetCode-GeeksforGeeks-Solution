//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    
    int mod = (int)(1e9 + 7);
    Integer[] dp = new Integer[10001];
    
    public int CountWays(String str){
        int len = str.length();
        //base case
        if(len == 0) return 1;
        if(str.charAt(0) == '0') return 0;
        
        if(dp[len] != null) return dp[len];
        
        int ans = CountWays(str.substring(1));
        // checking for legit letter 
        if(len > 1 && Integer.parseInt(str.substring(0, 2)) < 27){
            ans = (ans + CountWays(str.substring(2)))%mod;
        }
        return dp[len] = ans;
    }
}