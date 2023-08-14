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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int xorans = 0;
        for (int num : nums) {
            xorans ^= num;
        }
        
        int rightMostBit = xorans & ~(xorans - 1);
        
        int set1 = 0, set2 = 0;
        for (int num : nums) {
            if ((rightMostBit & num) == 0) {
                set1 ^= num;
            }
            else {
                set2 ^= num;
            }
        }
        
        int[] ans = new int[2];
        ans[0] = set1;
        ans[1] = set2;
        Arrays.sort(ans);
        return ans;
    }
}