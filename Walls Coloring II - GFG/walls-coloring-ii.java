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
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
		int minCost(int [][] costs) {
		//Write your code here
		
		// Base case handle
		if(costs[0].length == 1 && costs.length > 1) return -1;
		if(costs[0].length == 1 && costs.length == 1) return costs[0][0];
		
		int firstMin = Integer.MAX_VALUE, minIndex = -1, secondMin = Integer.MAX_VALUE;
		
		for(int i=0; i<costs[0].length; i++){
		    if(firstMin > costs[0][i]){
		        secondMin = firstMin;
		        firstMin = costs[0][i];
		        minIndex = i;
		    } else if (secondMin > costs[0][i]){
		        secondMin = costs[0][i];
		    }
		}
		// check the best price
		for(int i=1; i<costs.length; i++){
		    int fMin = Integer.MAX_VALUE, mIndex = -1, sMin = Integer.MAX_VALUE;
		    for(int j=0; j<costs[0].length; j++){
		        if(j == minIndex){
		            costs[i][j] += secondMin;
		        } else {
		            costs[i][j] += firstMin;
		        }
		        
    		    if(fMin > costs[i][j]){
    		        sMin = fMin;
    		        fMin = costs[i][j];
    		        mIndex = j;
    		    } else if (sMin > costs[i][j]){
    		        sMin = costs[i][j];
    		    }
		    }
		    firstMin = fMin;
		    secondMin = sMin;
		    minIndex = mIndex;
		}
		
		// last row min for ans
		Integer ans = Integer.MAX_VALUE;
		for(int i=0; i<costs[0].length; i++){
		    ans = Math.min(ans, costs[costs.length-1][i]);
		}
		return ans;
	}
}