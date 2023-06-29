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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int nextHappy(int N){
        while(true){
            if(isHappy(++N)) return N;
        }
    }
    
    static boolean isHappy(int n){
        if(n>9){
            int res = 0;
            while(n>0){
                res+= (n%10)*(n%10);
                n/=10;
            }
            return isHappy(res);
        }
        
        if(n == 7 || n == 1) return true;
        else return false;
      
    }
}