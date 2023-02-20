//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java
class Solution{

 public static int countPaths(int N){

 //code here
 int m=1000000007;

 long ans=0;

 for(int i=2;i<=N;i++){

     if(i%2==0){

        ans =(ans%m*3%m)%m+3;
     }
     else{

         ans=(ans%m*3%m)%m-3;

    }
 }
 return (int)(ans%m);

 }
}

//{ Driver Code Starts.

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
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends