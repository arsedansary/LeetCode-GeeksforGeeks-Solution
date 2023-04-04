//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
		//Write your code here
	int count = 0;
    int sum = str.length();
    for (int i = 1; i < sum; i++) {
        if (str.charAt(i) != str.charAt(i - 1))
            count++;
    }
    if(str.charAt(0)!=str.charAt(sum-1))
        return (count)/2 +2;
        
    return count / 2 + 1;
	}
}