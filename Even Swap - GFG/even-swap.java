//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] a, int n) {
		//Write your code here
		int s = 0; // start
        int e = -1; // end
        int[] result = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && (a[i] + a[i + 1]) % 2 == 0) {
                e = i + 1; // if it is true just keep increasing the range
            } else {
                if (e == -1) {
                    // single element
                    result[k++] = a[s];
                } else {
                    // multiple elements
                    int[] subArray = Arrays.copyOfRange(a, s, e + 1);
                    Arrays.sort(subArray);
                    for (int j = subArray.length - 1; j >= 0; j--) {
                        result[k++] = subArray[j];
                    }
                }
                s = i + 1;
                e = -1;
            }
        }
        return result;
	}
}