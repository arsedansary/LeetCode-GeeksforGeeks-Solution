//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends

class Solution
{
        public boolean isWordExist(char[][] arr, String s)
    {
        int x = 0;
        boolean [][]vis = new boolean[arr.length][arr[0].length];
        for(int i = 0 ; i < arr.length ; i ++){
            for(int j = 0 ; j < arr[0].length ; j ++){
                if(arr[i][j] == s.charAt(0) && !vis[i][j]){
//                    System.out.println("at "+i+", "+j);
                    if(isWordExistUtil(arr, i, j, x, vis, s)) return true;
                }
            }
        }
        return false;
    }
     boolean isSafe(char [][]arr, int i, int j, char ch){
        return i < arr.length && j < arr[0].length && i >= 0 && j >= 0 && arr[i][j] == ch;
    }

     boolean isWordExistUtil(char [][]arr, int i, int j, int x ,boolean [][]vis, String s){
        if(x == s.length())return true;
       if(isSafe(arr, i, j, s.charAt(x)) && !vis[i][j]){
           vis[i][j] = true;
           //left
            if(isWordExistUtil(arr, i, j-1, x+1, vis, s)){
//                System.out.println("left");
                return true;
            }
            //right
            if(isWordExistUtil(arr, i, j+1, x+1, vis, s)){
//                System.out.println("right");
                return true;
            }
            //up
           if(isWordExistUtil(arr, i-1, j, x+1, vis, s)){
//               System.out.println("up");
               return true;
           }
           //down
           if(isWordExistUtil(arr, i+1, j, x+1, vis, s)){
//               System.out.println("down");
               return true;
           }
           vis[i][j] = false;
           return false;
       }
       return false;
    }
}