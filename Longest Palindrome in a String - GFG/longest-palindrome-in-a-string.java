//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        int MOD = (int)1e9 + 7;
        int p = 31;
        int max = Integer.MIN_VALUE;
        int l = -1,r = -1;
        for(int i = 0;i < s.length();i++){
            long hash = 0;
            long revHash = 0;
            long curr = p;
            for(int j = i;j < s.length();j++){
                int c = s.charAt(j) - 'a';
                hash = (hash + (c * curr) % MOD) % MOD;
                curr = (curr * p) % MOD;
                revHash = ((revHash * p) % MOD + (c * p) % MOD) % MOD;
                if(hash == revHash){
                    if(max < (j - i + 1)){
                        max = j - i + 1;
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l,r + 1);
    }
}