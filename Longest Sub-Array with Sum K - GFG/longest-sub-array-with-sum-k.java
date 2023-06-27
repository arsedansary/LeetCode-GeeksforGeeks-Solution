//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int lenOfLongSubarr (int arr[], int n, int k) {
		
		HashMap<Integer,Integer> map=new HashMap<>();
		map.put(0,-1);
		int i=0;
		int sum=0;
		int size=0;
		
		while(i<n) {
			sum=sum+arr[i];
			int rsum=sum-k;
			if(map.containsKey(rsum)) {
				int temp=i-map.get(rsum);
				size=Math.max(size, temp);
			}
			if(!map.containsKey(sum))map.put(sum, i);
			i++;
		}
        return size;
    }
}
