//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
    public String kthPermutation(int n, int k) {
        List<Integer> v = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            v.add(i);
        }

        k--;
        int[] kthP = new int[n];
        int[] fact = new int[n];
        fact[0] = 1;

        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        int i = 0;
        while (k > 0) {
            int f = fact[v.size() - 1];
            int ind = k / f;
            kthP[i] = v.get(ind);
            k %= f;
            v.remove(ind);
            i++;
        }

        int j = 0;
        while (i < n) {
            kthP[i] = v.get(j);
            i++;
            j++;
        }

        StringBuilder ans = new StringBuilder();
        for (int num : kthP) {
            ans.append(num);
        }

        return ans.toString();
    }
}
        


//{ Driver Code Starts.

class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends