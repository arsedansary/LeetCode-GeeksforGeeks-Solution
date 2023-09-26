//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int tar) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n-3; i++)
        {
            for(int j = i+1; j < n-2; j++)
            {
                int k = j+1;
                int l = n-1;
                while(k < l)
                {
                    int sum = arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum < tar) k++;
                    else if(sum > tar) l--;
                    else
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        if(set.add(temp))
                        list.add(temp);
                        k++;
                        l--;
                    }
                }
            }
        }
        return list;
    }
}