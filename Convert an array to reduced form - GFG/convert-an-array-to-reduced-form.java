//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int val=0;
        for(int num : temp) hm.put(num , val++);
        for(int i=0;i<n;i++)    arr[i] = hm.get(arr[i]);
    }
}




// 1) Arrays | HashMap
// Time Complexity : O(N) + O(NLogN) + O(N) + O(N) = O(N Log N)

// Space Complexity : O(N) + O(N) = O(2N) = O(N)

 

// Step 1 : Make clone of original array as temp.

// Step 2 : Sort the temp array;

// Step 3 : Take HashMap hm and insert one by one elements of temp array and assign them values from 0 to N-1.

// Step 4 :  Traverse array arr and assign values from HashMap.