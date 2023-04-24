//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
int [] nearestSmallestTower(int [] arr){
		//Write your code here
		Stack<Integer> stack = new Stack<>();
		int leftNearest[] = new int[arr.length];
		int rightNearest[] = new int[arr.length];
		
		//Finding left nearest  
		for(int i=0;i<arr.length;i++){
		    if(stack.empty()){
		        leftNearest[i] = -1;
		    }
		    else {
		        if(arr[stack.peek()]<arr[i]){
		            leftNearest[i] = stack.peek();
		        }
		        else {
		            while(!stack.empty() && arr[stack.peek()]>=arr[i]){
		                stack.pop();
		            }
		            
		            if(stack.empty()){
		                leftNearest[i] = -1;
		            }
		            else {
		                leftNearest[i] = stack.peek();
		            }
		        }
		        
		    }
		    stack.push(i);
		}
		stack.clear();
		//Finding right nearest  
		for(int i=arr.length-1;i>=0;i--){
		    if(stack.empty()){
		        rightNearest[i] = -1;
		    }
		    else {
		        if(arr[stack.peek()]<arr[i]){
		            rightNearest[i] = stack.peek();
		        }
		        else {
		            while(!stack.empty() && arr[stack.peek()]>=arr[i]){
		                stack.pop();
		            }
		            
		            if(stack.empty()){
		                rightNearest[i] = -1;
		            }
		            else {
		                rightNearest[i] = stack.peek();
		            }
		        }
		        
		    }
		    stack.push(i);
		}
		
		int ans[] = new int[arr.length];
		for(int i=0;i<arr.length;i++){
		    if(rightNearest[i]==-1 && leftNearest[i]==-1){
		        ans[i] = -1;
		    }
		    else if(rightNearest[i]==-1 || leftNearest[i]==-1){
		        ans[i] = (rightNearest[i]==-1) ? leftNearest[i] : rightNearest[i];
		    }
		    else {
		        //Differences are same
		        if(Math.abs(i-rightNearest[i]) == Math.abs(i-leftNearest[i])){
		            //Go for small value
		            if(arr[rightNearest[i]] < arr[leftNearest[i]]){
		                ans[i] = rightNearest[i];
		            }
		            else if(arr[rightNearest[i]] > arr[leftNearest[i]]){
		                ans[i] = leftNearest[i];
		            }
		            else {
		                //Both values are also same
		                ans[i] = Math.min(leftNearest[i], rightNearest[i]);
		            }
		        }
		        else if(Math.abs(i-rightNearest[i]) < Math.abs(i-leftNearest[i])){
		            ans[i] = rightNearest[i];
		        }
		        else {
		            ans[i] = leftNearest[i];
		        }
		    }
		}
		return ans;
	}
}