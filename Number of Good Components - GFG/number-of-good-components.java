//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static int total_nodes = 0;
    static boolean isFullyConnected = true;
    
    private void dfs(int node, int size, boolean visited[], ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = true;
        total_nodes++;
        
        if(size!=adj.get(node).size())
        {
            isFullyConnected = false;
        }
        
        for(int nei : adj.get(node))
        {
            if(visited[nei]==false)
            {
                dfs(nei, size, visited, adj);
            }
        }
        
    }
    
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int ans = 0;
        boolean visited[] = new boolean[V+1];
        
        for(int i=1; i<=V; i++)
        {
            if(visited[i] == false)
            {
                total_nodes = 0;
                isFullyConnected = true;
                int deg = adj.get(i).size();
                dfs(i, deg, visited, adj);
                
                if(isFullyConnected && total_nodes-1==deg)
                {
                    ans++;
                }
                
            }
        }
        
        
        return ans;
        
        
    }
}