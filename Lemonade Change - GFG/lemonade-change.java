//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        int net5=0, net10=0;
        for (int i=0; i< N; i++){
            if (bills[i]==5)
                net5= net5+1;
            else if (bills[i]==10){
                net5-=1;
                net10+=1;
                if (net5<0)
                    return false;
            }
            else if (bills[i]==20){
                if(net10>0 && net5>0){
                    net10--;
                    net5--;
                }
                else if(net5>=3){
                    net5-=3;
                }
                else
                    return false;
            }
            
        }
        return true;
    }
}