//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        // Complete the function
        
        long a = Integer.MIN_VALUE;
        long b = Integer.MIN_VALUE;
        long c = Integer.MIN_VALUE;
        long y = Integer.MAX_VALUE;
        long z = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            
            long k = arr[i];

            if(a<k){ c = b; b = a; a = k; }
            else if(b<k){ c = b; b = k; }
            else if(c<k){ c = k; }
            
            if(y>k){ z = y; y = k; }
            else if(z>k){ z = k; }
            
        }
        
        return Math.max(a*b*c,a*y*z);
        
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends