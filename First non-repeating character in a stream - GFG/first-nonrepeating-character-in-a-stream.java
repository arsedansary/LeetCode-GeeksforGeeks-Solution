//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
      int n = A.length();
        
        StringBuilder res = new StringBuilder();
        
        int[] lastOccured = new int[26];
        Arrays.fill(lastOccured, -1);
        
        for (int i = 0 ; i < n ; i++) {
            char ch = A.charAt(i);
            
            if (lastOccured[ch-'a'] == -1) {
                lastOccured[ch-'a'] = i;
            } else {
                lastOccured[ch-'a'] = n;
            }
            
            int min = n;
            for (int j = 0 ; j < 26 ; j++) {
                if (lastOccured[j] != -1 && min > lastOccured[j]) {
                    min = lastOccured[j];
                }
            }
            
            if (min == n) {
                res.append('#');
            } else {
                res.append(A.charAt(min));
            }
        }
        
        return res.toString();
    }
}