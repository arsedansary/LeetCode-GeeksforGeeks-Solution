//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{   
    char arr[][];
    String s;
    public int[][] searchWord(char[][] grid, String word)
    {
        arr = grid;
        s = word;
        int n = arr.length;
        int m = arr[0].length;
        
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
         
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                boolean check = solve(i , j, 0, 0, 0);
                if(check){
                    rows.add(i);
                    cols.add(j);
                }; 
            }
        }
        
        int len = rows.size();
        int ans[][] = new int[len][2];
        
        for(int i = 0; i<len; i++){
            ans[i][0] = rows.get(i);
            ans[i][1] = cols.get(i);
        }
        
        return ans;
    }
    
    boolean solve(int i , int j , int r, int c, int x){
        int n = arr.length;
        int m = arr[0].length;
        
        if(x == s.length()) return true;
        if(i>=n || i<0 || j>=m || j<0) return false;
        if(arr[i][j] != s.charAt(x)) return false;
        
        
        if(r == 0 && c == 0){
            int d1[] = {0 , 0 , -1 , 1, 1 , 1, -1 , -1};
            int d2[] = {-1 , 1, 0 , 0, -1 , 1, -1, 1};
            
            for(int k = 0; k<8; k++){
                boolean ans = solve(i+d1[k], j+d2[k], d1[k] , d2[k] , x+1);
                if(ans) return true;
            }
            return false;
        }
        
        return solve(i+r, j+c, r , c , x+1);
        
    }
}