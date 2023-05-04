//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG implements Runnable
{
    public static void main(String args[])throws IOException
    {
        new Thread(null, new GFG(), "whatever", 1<<26).start();
    }
    public void run()
    {
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine());
            while(t-->0){
                int n=Integer.parseInt(in.readLine().trim());
                int a[][]=new int[n][3];
                for(int i=0;i<n;i++){
                    String s[]=in.readLine().trim().split(" ");
                    a[i][0]=Integer.parseInt(s[0]);
                    a[i][1]=Integer.parseInt(s[1]);
                    a[i][2]=Integer.parseInt(s[2]);
                }
                Solution ob=new Solution();
                out.println(ob.maxCoins(n,a));
            }
            out.close();
        }catch(Exception e){
            ;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int maxCoins(int n,int arr[][])
    {
        Arrays.sort(arr, (a, b)->a[1]==b[1]? a[0]-b[0]:a[1]-b[1]);
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 0);
        for(int p[] : arr){
            int key = tm.floorKey(p[0]);
            int prev = tm.get(key);
                // System.out.println(key+" "+prev+" ----> "+p[0]+" "+p[1]+" "+p[2]);
                max = Math.max(prev+p[2], max);
                int prevEndMax = tm.get(tm.floorKey(p[1]));
                
                        tm.put(p[1], Math.max(prevEndMax,p[2]));
                    
            
        }
        return max;
    }
}